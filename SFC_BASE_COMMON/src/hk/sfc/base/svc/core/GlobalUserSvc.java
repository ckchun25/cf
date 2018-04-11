package hk.sfc.base.svc.core;

import hk.sfc.base.domain.core.GlobalUser;

/**
 * Entity service for GlobalUser.
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
public interface GlobalUserSvc {

	/**
	 * Retrieve the user group code and user class based on user Id.
	 * @param userId
	 * @return GlobalUser
	 */
	public GlobalUser retrieveForAuthorizationChecking(String userId);

	/**
	 * Retrieve a valid user.
	 * @param userId
	 * @return GlobalUser
	 */
	public GlobalUser retrieveForValidUser(String userId);

	/**
	 * Create a GlobalUser object with default setting.
	 * @param userId
	 * @param userName
	 */
	public void createForAuthorization(String userId, String userName);

}
