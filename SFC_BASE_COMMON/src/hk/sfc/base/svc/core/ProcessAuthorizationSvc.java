package hk.sfc.base.svc.core;

import hk.sfc.base.exception.SvcException;
import hk.sfc.base.security.AccessControl;

import java.util.List;

/**
 * Provide authorization related service.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>27/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface ProcessAuthorizationSvc {

	/**
	 * Get access control for user. The user ID should be retrieved in <code>SecurityProfile</code> instead of passing in.
	 * @return AccessControl object if user is exist (even no access function object is granted for him), otherwise null. 
	 */
	public AccessControl getAccessControlForUser(String loginName) throws SvcException;
	
	/**
	 * Get access control for user. The user ID should be retrieved in <code>SecurityProfile</code> instead of passing in.
	 * @return AccessControl object if user is exist (even no access function object is granted for him), otherwise null. 
	 */
	public AccessControl getAccessControlForUser() throws SvcException;

	/**
	 * The purpose of this function is to load user access control data base on the SFC framework access control (cater for user based function access control) and
	 * combine access control data not by user (e.g. select different CE). The "not by user" access control data is provided by a list of <code>UserAccessFunction</code> where it contains
	 * the function object group code and function group objects.<p>
	 * 
	 * There will be 2 steps for access control retrieving and combining:
	 * <ol>
	 * <li>By user ID and get a list of <code>UserAccessFunction</code> from database.
	 * <li>Merging the input list of <code>UserAccessFunction</code>.
	 * </ol> 
	 * 
	 * @param userAccessFunctions
	 * @return	AccessControl object
	 * @throws SvcException
	 */
	public AccessControl getAccessControlForUser(List userAccessFunctions) throws SvcException;

}
