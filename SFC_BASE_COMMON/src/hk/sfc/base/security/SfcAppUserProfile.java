package hk.sfc.base.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SfcAppUserProfile {

	static protected Log logger = LogFactory.getLog(SfcAppUserProfile.class);

	private SfcAppUser appUser;
	private boolean processedBySecurityModule = false;
	private boolean securityChecked = false;
	private boolean securityCheckRequired = true;
	
	public String getLoginName() {			
		return appUser!=null?appUser.getLoginName():null;
	}
	
	public SfcAppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(SfcAppUser appUser) {
		this.appUser = appUser;
	}
		
	public boolean isProcessedBySecurityModule() {
		return processedBySecurityModule;
	}
	public void setProcessedBySecurityModule(boolean processBySecurityModule) {
		this.processedBySecurityModule = processBySecurityModule;
	}
	
	public boolean isSecurityChecked() {
		return securityChecked;
	}
	public void setSecurityChecked(boolean securityChecked) {
		this.securityChecked = securityChecked;
	}
	
	public boolean isAuthenticated() {
		return getAppUser()!=null;
	}
	
	public boolean isSecurityCheckRequired() {
		return securityCheckRequired;
	}
	public void setSecurityCheckRequired(boolean securityCheckRequired) {
		this.securityCheckRequired = securityCheckRequired;
	}

	public boolean isAuthorize(String objectCode) {
		boolean _authorized = false;
		if (appUser != null) {
			AccessControl _ACL = appUser.getAccessControl();
			if (_ACL != null) {
				_authorized = _ACL.isAuthorize(objectCode);
			}
		}
		return _authorized;
	}

	/**
	 * Get the unique key for the user, it will try to call getUserId() first, if not found, then call getUserCode().
	 * It caters licensing portal system using data type Long as the unique key but licensing admin use data type String as the unique key.
	 */
	public Object getUserUniqueKey() {
		if (appUser == null) {
			return null;
		}

		if (appUser.getUserId() != null) {
			return appUser.getUserId();
		}

		if (appUser.getUserCode() != null) {
			return appUser.getUserCode();
		}

		return null;
	}}
