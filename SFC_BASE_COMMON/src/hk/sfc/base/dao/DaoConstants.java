package hk.sfc.base.dao;

/**
 *  Constants for DAO.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public final class DaoConstants {
	
	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private DaoConstants() {
	}
	
	public static final String CREATE_TIME = "creationTime";
	
	public static final String MODIFY_TIME = "modificationTime";
	
	public static final String USER_ID = "userId";
	
	public static final String LOGIN_NAME = "loginName";

}
