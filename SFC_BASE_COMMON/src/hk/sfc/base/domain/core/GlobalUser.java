package hk.sfc.base.domain.core;

import hk.sfc.base.domain.SfcDomainObject;


/**
 * Analog to GL_T_USERS table.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>24/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class GlobalUser extends SfcDomainObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -586224642291880839L;

	private String userCode;
	private String userGroupCode;
	private String userClass;
	private String userName;
	private String ownerUnit;
	private String divCode;
	private String deptCode;
	private String ext;
	private String email;
	
	/**
	 * getter method of userCode
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	
	/**
	 * setter method of userCode
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	
	/**
	 * getter method of userGroupCode
	 * @return the userGroupCode
	 */
	public String getUserGroupCode() {
		return userGroupCode;
	}

	
	/**
	 * setter method of userGroupCode
	 * @param userGroupCode the userGroupCode to set
	 */
	public void setUserGroupCode(String userGroupCode) {
		this.userGroupCode = userGroupCode;
	}

	
	/**
	 * getter method of userClass
	 * @return the userClass
	 */
	public String getUserClass() {
		return userClass;
	}

	
	/**
	 * setter method of userClass
	 * @param userClass the userClass to set
	 */
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}


	/**
	 * setter method of userName
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * getter method of userName
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
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

	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
