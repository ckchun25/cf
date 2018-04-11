package hk.sfc.base.security;

import java.io.Serializable;
import java.util.Date;

/**
 *  Object that store the login user information.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>08/04/2010</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>CECPHASETWO-1</TD><TD>03/06/2013</TD><TD>wstse1</TD><TD>Update for web dial flag checking</TD></TR>
 * </TABLE>
 *
 */
public class SfcAppUser implements Serializable {

	/** The login name of the user. */
	private String loginName;

	/** The surrogate key of the user in DB. */
	private Long userId;

	/** The surrogate key of the user in DB. */
	private String userCode;

	/** The surname of the user. */
	private String surname;

	/** The first name of the user */
	private String firstName;

	/** The company name of the user */
	private String companyName;

	private String ownerUnit;
	
	private String ownerUnitDesc;
	
	private String ownerGroup;
	
	private String divCode;

	private String deptCode;
	
	/** The last login date */
	private Date lastLoginDate;

	/** The last password change date */
	private Boolean isPasswordExpired;

	/** Indicator for anonymous login */
	private boolean anonymousLogin;
	
	/** The accessControl object belong to the user */
	private AccessControl accessControl;
	
	/** extension number of user */
	private String ext;
	
	/** web dail availability */
	private Boolean canDial;
	
	/** The email of the user **/
	private String email;
	

	/**
	 * Get the user id.
	 * @return	the user id.
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Set the user id.
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * setter method of userCode
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * getter method of userCode
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * Get the login name of user.
	 * @return	the login name.
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Set the login name of user.
	 * @param loginName the login name
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * getter method of surname
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * setter method of surname
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * getter method of firstName
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setter method of firstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter method of companyName
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * setter method of companyName
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getOwnerUnit() {
		return ownerUnit;
	}
	public void setOwnerUnit(String ownerUnit) {
		this.ownerUnit = ownerUnit;
	}

	public String getDivCode() {
		return divCode;
	}
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	/**
	 * getter method of lastLoginDate
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * setter method of lastLoginDate
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * getter method of isPasswordExpired
	 * @return the lastPasswordChangeDate
	 */
	public Boolean getIsPasswordExpired() {
		return isPasswordExpired;
	}

	/**
	 * setter method of isPasswordExpired
	 * @param lastPasswordChangeDate the lastPasswordChangeDate to set
	 */
	public void setIsPasswordExpired(Boolean isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}

	/**
	 * getter method of accessControl
	 * @return the accessControl
	 */
	public AccessControl getAccessControl() {
		return accessControl;
	}

	/**
	 * setter method of accessControl
	 * @param accessControl the accessControl to set
	 */
	public void setAccessControl(AccessControl accessControl) {
		this.accessControl = accessControl;
	}

	public boolean isAnonymousLogin() {
		return anonymousLogin;
	}

	public void setAnonymousLogin(boolean anonymousLogin) {
		this.anonymousLogin = anonymousLogin;
	}

	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}

	public Boolean isCanDial() {
		return canDial;
	}
	public void setCanDial(Boolean canDial) {
		this.canDial = canDial;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
