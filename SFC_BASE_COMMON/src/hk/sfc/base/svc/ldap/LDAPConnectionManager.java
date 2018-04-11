package hk.sfc.base.svc.ldap;

import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.exception.SvcException;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;

/**
 * LDAP Connection Manager.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>19/03/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>ITUAT-324</TD></TR>
 * <TR><TD>ASR14171</TD><TD>16/07/2009</TD><TD>ssyli1</TD><TD>ITUAT-321</TD></TR>
 * </TABLE>
 *
 */
public class LDAPConnectionManager {

	protected final Log logger = LogFactory.getLog(getClass());

	private static final int DEFAULT_TIMEOUT = 0;

	/**
	 * Password Encrypted by SFCPASSWORD.jar
	 */
	private String password;

	// LDAP port
	private Integer port;

	// LDAP version
	private Integer version;

	// LDAP Host
	private String host;

	// LDAP Login DN
	private String loginDN;

	// LDAP Admin Login DN
	private String adminLoginDN;

	// LDAP Encodimg
	private String encoding;

	// LDAP failover Host
	private String failoverLdapHost;

	// LDAP Timeout
	private Integer ldapTimeout;
	
	// Admin application login DN
	private String adminAppLoginDN;
	
	// Admin application login DN Password
	private String adminAppLoginPassword;
	
	// Admin application LDAP Host
	private String adminAppLdapHost;
	
	/**
	 * LDAP Host Constant to store which ldapServer application should connect to
	 */
	private static String ldapHost;

	// Getter and Setter

	/**
	 * Constructor of LDAPConnectionManager
	 */
	public LDAPConnectionManager() {
	}

	/**
	 * Open LDAP Connection API by provided username and password
	 * @param userId User ID
	 * @param password Password
	 * @return LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	// Open LDAP Connection by username and password
	public LDAPConnection openConnection(String userId, String password) throws LDAPException,
			SvcException {
		if (logger.isDebugEnabled()) {
			logger.debug("Open LDAP Connection" + userId);
		}
		String _ldapLoginDN = "cn=" + userId + ", " + loginDN;
		return openLDAPConnection(_ldapLoginDN, password);
	}

	/**
	 * Open the LDAP Admin Connection
	 * @return LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	public LDAPConnection openAdminConnection() throws LDAPException, SvcException {
		if (logger.isDebugEnabled()) {
			logger.debug("Open Admin LDAP Connection");
		}
		return openLDAPConnection(adminLoginDN, password);
	}
	
	/**
	 * Open the LDAP Admin Application Connection
	 * @return LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	public LDAPConnection openAdminAppConnection() throws LDAPException, SvcException{
		if (logger.isDebugEnabled()) {
			logger.debug("Open Admin Application LDAP Connection");
		}
		return openLDAPConnection(adminAppLoginDN, adminAppLoginPassword, adminAppLdapHost);
	}
	
	/**
	 * Common Method to open LDAP Connection
	 * @param userDN User CN
	 * @param password Password
	 * @return LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	private LDAPConnection openLDAPConnection(String userDN, String password) throws LDAPException,
	SvcException {
		return openLDAPConnection(userDN, password, host);
	}
	
	/**
	 * Common Method to open LDAP Connection
	 * Default timeout is 10 mins
	 * @param userDN User CN
	 * @param password Password
	 * @param host LDAP Host
	 * @return LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	private LDAPConnection openLDAPConnection(String userDN, String password, String host) throws LDAPException,
			SvcException {
		LDAPConnection _lc = new LDAPConnection();
		try {
			_lc.connect(host, port.intValue());
			_lc.bind(version.intValue(), userDN, password.getBytes(encoding));
			enableLDAPSocketTimeOut(_lc);
		} catch (NumberFormatException e) {
			throw new SfcRuntimeException(SfcInternalErrorMessage.EXCEPTION
					.withArgs(new Object[] { e.getMessage() }));
		} catch (UnsupportedEncodingException e) {
			throw new SfcRuntimeException(SfcInternalErrorMessage.EXCEPTION
					.withArgs(new Object[] { e.getMessage() }));
		}
		return _lc;
	}

	/**
	 * Enable the LDAP Socket Timeout and Idle Timeout
	 * Set Socket TimeOut to ldapTimeOut at lic-common.properties
	 * @param lc LDAPConnection 
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	public void enableLDAPSocketTimeOut(LDAPConnection lc) throws LDAPException, SvcException {
		setLDAPSocketTimeout(lc, ldapTimeout.intValue());
	}

	/**
	 * Disable LDAP Socket timeout and Idle Timeout with default value
	 * @param lc LDAPConnection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	public void disableLDAPSocketTimeOut(LDAPConnection lc) throws LDAPException, SvcException {
		setLDAPSocketTimeout(lc, DEFAULT_TIMEOUT);
	}

	/**
	 * Set LDAP Socket TimeOut
	 * @param lc LDAP Connection
	 * @param timeout LDAP timeout value
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException Service Exception
	 */
	private void setLDAPSocketTimeout(LDAPConnection lc, int timeout) throws LDAPException,
			SvcException {
		if (lc != null && lc.isConnected() && lc.isConnectionAlive()) {
			lc.setSocketTimeOut(timeout);
		}
	}

	/**
	 * Close LDAP Connection API.
	 * @param lc LDAPConnection
	 * @throws LDAPException when disconnect LDAP Connection got problem
	 */
	public static void CloseConnection(LDAPConnection lc) throws LDAPException {
		lc.disconnect();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the loginDN
	 */
	public String getLoginDN() {
		return loginDN;
	}

	/**
	 * @param loginDN the loginDN to set
	 */
	public void setLoginDN(String loginDN) {
		this.loginDN = loginDN;
	}

	/**
	 * @return the adminLoginDN
	 */
	public String getAdminLoginDN() {
		return adminLoginDN;
	}

	/**
	 * @param adminLoginDN the adminLoginDN to set
	 */
	public void setAdminLoginDN(String adminLoginDN) {
		this.adminLoginDN = adminLoginDN;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * @return the failoverLdapHost
	 */
	public String getFailoverLdapHost() {
		return failoverLdapHost;
	}

	/**
	 * @param failoverLdapHost the failoverLdapHost to set
	 */
	public void setFailoverLdapHost(String failoverLdapHost) {
		this.failoverLdapHost = failoverLdapHost;
	}

	/**
	 * @return the ldapHost
	 */
	public static String getLdapHost() {
		return ldapHost;
	}

	/**
	 * @param ldapHost the ldapHost to set
	 */
	public static void setLdapHost(String ldapHost) {
		LDAPConnectionManager.ldapHost = ldapHost;
	}

	/**
	 * @return the ldapTimeout
	 */
	public Integer getLdapTimeout() {
		return ldapTimeout;
	}

	/**
	 * @param ldapTimeout the ldapTimeout to set
	 */
	public void setLdapTimeout(Integer ldapTimeout) {
		this.ldapTimeout = ldapTimeout;
	}

	/**
	 * @param adminAppLoginDN the adminAppLoginDN to set
	 */
	public void setAdminAppLoginDN(String adminAppLoginDN) {
		this.adminAppLoginDN = adminAppLoginDN;
	}

	/**
	 * @return the adminAppLoginDN
	 */
	public String getAdminAppLoginDN() {
		return adminAppLoginDN;
	}

	/**
	 * @param adminAppLoginPassword the adminAppLoginPassword to set
	 */
	public void setAdminAppLoginPassword(String adminAppLoginPassword) {
		this.adminAppLoginPassword = adminAppLoginPassword;
	}

	/**
	 * @return the adminAppLoginPassword
	 */
	public String getAdminAppLoginPassword() {
		return adminAppLoginPassword;
	}

	/**
	 * @param adminAppLdapHost the adminAppLdapHost to set
	 */
	public void setAdminAppLdapHost(String adminAppLdapHost) {
		this.adminAppLdapHost = adminAppLdapHost;
	}

	/**
	 * @return the adminAppLdapHost
	 */
	public String getAdminAppLdapHost() {
		return adminAppLdapHost;
	}
	
}