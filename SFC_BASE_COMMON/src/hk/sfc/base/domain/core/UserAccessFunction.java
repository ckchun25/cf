package hk.sfc.base.domain.core;

import hk.sfc.base.domain.SfcDomainObject;
import hk.sfc.base.security.AccessControl;

import java.util.List;

/**
 * It stores the user access function.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>07/05/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class UserAccessFunction extends SfcDomainObject {

	// Make use of the current SFC authority level where D>U>R.
	// Hence, AUTHORITY_SUBMIT > AUTHORITY_SAVE.
	// The authority comparison is left for AccessControl object handle.

	/** The user authority, this means the user has submit authority.  */
	public static final String AUTHORITY_SUBMIT = AccessControl.AUTHORITY_DELETE;

	/** The user authority, this means the user has save authority.  */
	public static final String AUTHORITY_SAVE = AccessControl.AUTHORITY_UPDATE;

	/** The access level for submit. */
	//public static final Integer ACCESS_LEVEL_SUBMIT = AccessControl.ACCESS_LEVEL_DELETE;

	/** The access level for save. */
	//public static final Integer ACCESS_LEVEL_SAVE = AccessControl.ACCESS_LEVEL_UPDATE;

	private static final long serialVersionUID = 8725301325504729549L;

	private String authority;

	private String functionGroupCode;

	private String userGroupCode;

	private String userClass;

	private List functionGroupObjects;

	/**
	 * Default constructor.
	 */
	public UserAccessFunction() {

	}

	/**
	 * Create a instance with function group code and authority.
	 * @param functionGroupCode
	 * @param authority
	 */
	public UserAccessFunction(String functionGroupCode, String authority) {
		setFunctionGroupCode(functionGroupCode);
		setAuthority(authority);
	}

	/**
	 * getter method of authority
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * setter method of authority
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * getter method of functionGroupCode
	 * @return the functionGroupCode
	 */
	public String getFunctionGroupCode() {
		return functionGroupCode;
	}

	/**
	 * setter method of functionGroupCode
	 * @param functionGroupCode the functionGroupCode to set
	 */
	public void setFunctionGroupCode(String functionGroupCode) {
		this.functionGroupCode = functionGroupCode;
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
	 * getter method of functionGroupObjects
	 * @return the functionGroupObjects
	 */
	public List getFunctionGroupObjects() {
		return functionGroupObjects;
	}

	/**
	 * setter method of functionGroupObjects
	 * @param functionGroupObjects the functionGroupObjects to set
	 */
	public void setFunctionGroupObjects(List functionGroupObjects) {
		this.functionGroupObjects = functionGroupObjects;
	}

	/**
	 * Return true if the function group code and the authority are the same.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {

		// Ensure the functionGroupCode and authority are not null first. 
		if (getFunctionGroupCode() != null && getAuthority() != null) {

			// Ensure the passing object is not null and is instance of UserAccessFunction.
			if (o != null && o instanceof UserAccessFunction) {

				UserAccessFunction _userAccessFunction = (UserAccessFunction) o;

				// Ensure the passing object's functionGroupCode and authority are not null.
				if (_userAccessFunction.getFunctionGroupCode() != null
						&& _userAccessFunction.getAuthority() != null) {

					if (functionGroupCode.trim().equalsIgnoreCase(
							_userAccessFunction.getFunctionGroupCode().trim())
							&& authority.trim().equalsIgnoreCase(
									_userAccessFunction.getAuthority().trim())) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
