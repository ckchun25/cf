package hk.sfc.base.svc.core;

import hk.sfc.base.domain.core.FunctionGroupObject;
import hk.sfc.base.domain.core.UserAccessFunction;
import hk.sfc.base.exception.SvcException;

import java.util.List;

/**
 * User Access Function Entity Service.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>29/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface UserAccessFunctionSvc {

	/**
	 * It retrieves access access function depends on userId, userGroup, userClass and application code.
	 * @param userId	the unique ID of the user. 
	 * @param userGroup	the user group of the user belongs to.
	 * @param userClass	the user class of the user belongs to.
	 * @param applicationCode	the application that the user access to.
	 * @return	a list of {@link UserAccessFunction} that belongs to the input criteria.
	 * @throws SvcException
	 */
	public List queryForAuthorizationObjects(String userId, String userGroup, String userClass,
			String applicationCode) throws SvcException;

	/**
	 * Query a list of FunctionGroupObject by the functionGroupCode.
	 * @param functionGroupCode	the function group code.
	 * @return	a list of {@link FunctionGroupObject} that belong to the function group code.
	 * @throws SvcException
	 */
	public List queryFunctionGroupObjects(String functionGroupCode) throws SvcException;

}
