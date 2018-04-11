package hk.sfc.base.svc.ldap;

import hk.sfc.base.exception.SvcException;

import java.util.Date;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;

/**
 *  LDAP Service Interface
 *  Remarks: LDAP cannot be rollback
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * <TR><TD>ASR15559</TD><TD>17/09/2009</TD><TD>Kenny Yip</TD><TD>Bug fix of activating account.</TD></TR>
 * </TABLE>
 *
 */
public interface LDAPSvc {

	/**
	 * Add User into LDAP
	 * <ol>
	 * <li>Add user into TempUser or User Container in LDAP</li>
	 * <li>Add the group relationship to LDAP</li>
	 * <li>If initialAccount = false: User is added to ou=USER,ou=APPLICATION,o=SFC</li>
	 * <li>group relationship:General User,ou=GROUP,ou=APPLICATION,o=SFC and Licensing,ou=GROUP,ou=APPLICATION,o=SFC</li>
	 * <li>If initialAccount = true: User is added to TempUser container, ou=TEMPUSER,ou=APPLICATION,o=SFC</li>
	 * <li>group relationship: General User,ou=GROUP,ou=APPLICATION,o=SFC and Licensing,ou=GROUP,ou=APPLICATION,o=SFC</li>
	 * <li>if password is violate password policy, SvcException(LDAP_SVR_ERR) will throw out</li>
	 * </ol>
	 * @param initialAccount Temp Account or not
	 * @param oldUserId old User ID
	 * @param userId User ID
	 * @param password Password
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException when violate Password Policy Exception
	 */
	public void addUser(boolean initialAccount, String oldUserId, String userId, String password,
			LDAPConnection ldapConnection) throws LDAPException, SvcException;

	/**
	 * Delete user and group in LDAP related to the provided usedId
	 * @param initialAccount Temp Account or not
	 * @param userId User ID
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 */
	public void deleteUser(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Check whether the provided userId is existed in LDAP
	 * @param initialAccount Temp Account or not
	 * @param userId User ID
	 * @param ldapConnection LDAP Connection
	 * @return boolean 
	 * @throws LDAPException LDAP Exception
	 */
	public boolean searchUser(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Change password in LDAP by provided newPassword
	 * if newPassword is violate password policy, SvcException(LDAP_SVR_ERR) will throw out
	 * Remarks: this API will check the password history in Password Policy
	 * @param userId user ID
	 * @param oldPassword old Password
	 * @param newPassword new Password
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException when violate Password Policy
	 */
	public void changePassword(String userId, String oldPassword, String newPassword,
			LDAPConnection ldapConnection) throws LDAPException, SvcException;

	/**
	 * Reset Password in LDAP by provided password
	 * if newPassword is violate password policy, SvcException(LDAP_SVR_ERR) will throw out
	 * Remarks: this API will not check the password history in Password Policy
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param newPassword new Password
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException when violate Password Policy
	 */
	public void resetPassword(boolean initialAccount, String userId, String newPassword,
			LDAPConnection ldapConnection) throws LDAPException, SvcException;

	/**
	 * Enable LDAP user Account by userId
	 * After enable, User can login to the provided userId
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 */
	public void setEnable(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Disable LDAP user Account by userId
	 * After disable, user cannot login to the provided userId
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection
	 * @throws LDAPException LDAP Exception
	 */
	public void setDisabled(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Check whether the account is disabled 
	 *(Check loginDisabled attribute in LDAP)
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection
	 * @return boolean
	 * @throws LDAPException LDAP Exception
	 */
	public boolean isDisabled(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Verify the provided password for the provided user is correct or not
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param password Password
	 * @param ldapConnection LDAP Connection
	 * @return true if the provided password is valid for the provided user, otherwise false.
	 * @throws LDAPException LDAP Exception
	 */
	public boolean verifyUser(boolean initialAccount, String userId, String password,
			LDAPConnection ldapConnection) throws LDAPException;

	/**
	 * Change the account from initial Account to Permanent account
	 * <ol>
	 * <li>Check oldUser = newUser, throw Exception if so</li>
	 * <li>Check newUser is existed in LDAP container or not, throw Exception if existed</li>
	 * <li> Add User by newUser in cn=General User,ou=GROUP,ou=APPLICATION,o=SFC</li>
	 * <li>delete user by provided oldUser in cn=Temp Account,ou=GROUP,ou=APPLICATION,o=SFC</li>
	 * <li>Reset Password Expiration Time(passwordExpirationTime): currentDate + 60 days</li>
	 * </ol>
	 * Remarks: if newPassword is violate password policy, SvcException(LDAP_SVR_ERR) will throw out 
	 * @param oldUser old User ID
	 * @param newUser new User ID
	 * @param newPassword new Password
	 * @param ldapConnection LDAP Connection 
	 * @throws LDAPException LDAP Exception
	 * @throws SvcException when violate Password Policy
	 */
	public void modifyUser(String oldUser, String newUser, String newPassword,
			LDAPConnection ldapConnection) throws LDAPException, SvcException;

	/**
	 * Get last login Time by provided userId
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @return Date last Login Time
	 * @throws LDAPException LDAP Exception
	 */
	public Date getLastLoginTime(String userId, LDAPConnection ldapConnection) throws LDAPException;

	/**
	 * Check whether the provided userId is locked by 3 consecutive invalid login
	 * @param initialAccount Temp Account or not
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @return boolean
	 * @throws LDAPException LDAP Exception
	 */
	public boolean isLocked(boolean initialAccount, String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * If the account is locked by 3 consecutive invalid login
	 * this API can activate the account(unlock the account)
	 * After unlock the account, user can login to the provided userId
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @throws LDAPException LDAP Exception
	 */
	public void activate(String userId, LDAPConnection ldapConnection) throws LDAPException;

	/**
	 * If the account is locked by 3 consecutive invalid login
	 * this API can activate the account(unlock the account)
	 * After unlock the account, user can login to the provided userId
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @throws LDAPException LDAP Exception
	 */
	public void activate(boolean initialAccount, String userId, LDAPConnection ldapConnection) throws LDAPException;
	
	/**
	 * If initial account has not been initialised in 90 days
	 * this API can deactivate the account(lock the account)
	 * After lock the account, user cannot login to the provided userId
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @throws LDAPException LDAP Exception
	 */
	public void deactivate(boolean initialAccount, String userId, LDAPConnection ldapConnection) throws LDAPException;
	
	/**
	 * Check whether the password is expired
	 * LDAP attributes to check: LastReminderTime 
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @return boolean
	 * @throws LDAPException LDAP Exception
	 */
	public boolean isPasswordExpired(String userId, LDAPConnection ldapConnection)
			throws LDAPException;

	/**
	 * Check whether the password is expired and needed to alert the user (password need change)
	 * LDAP attributes to check: passwordExpirationTime and LastReminderTime 
	 * @param userId user ID
	 * @param ldapConnection LDAP Connection 
	 * @return boolean
	 * @throws LDAPException LDAP Exception
	 */
	public boolean needChangePasswordReminder(String userId, LDAPConnection ldapConnection)
			throws LDAPException;
	
	
	/**
	 * Used by Admin application to get User Id from the LDAP Lotus Notes
	 * @param userId Login User Name
	 * @param ldapConnection LDAP Connection
	 * @return String: login user Id(uid)
	 * @throws LDAPException LDAP Exception
	 */
	public String retrieveAdminLoginUserName(String userId, LDAPConnection ldapConnection) throws LDAPException;
}
