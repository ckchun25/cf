package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcAppErrorMessage;

import java.util.Arrays;

/**
 * Exception thrown when entity authorization check in entity service fails for CAD group.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>18/03/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class GroupEntityAuthorizationException extends EntityAuthorizationException {

	private static final long serialVersionUID = -1598700552956431153L;

	/**
	 * Constructor for single entity object associated with a group.
	 * @param funcName function name
	 * @param ceref CE reference number
	 * @param cls class of entity object
	 * @param id ID of entity object
	 */
	public GroupEntityAuthorizationException(String funcName, String ceref, Class cls, Object id) {
		super(SfcAppErrorMessage.GROUP_ENTITY_AUTHORIZATION_FAILURE.withArgs(new Object[] {
				funcName, ceref, cls.getName().substring(cls.getName().lastIndexOf(".") + 1), id }));
	}

	/**
	 * Constructor for multiple entity objects associated with a group.  
	 * @param funcName function name
	 * @param ceref CE reference number
	 * @param cls class of entity object
	 * @param ids List of ID of entity object
	 */
	public GroupEntityAuthorizationException(String funcName, String ceref, Class cls, Object[] ids) {
		super(SfcAppErrorMessage.GROUP_ENTITY_AUTHORIZATION_FAILURE.withArgs(new Object[] {
				funcName, ceref, cls.getName().substring(cls.getName().lastIndexOf(".") + 1),
				Arrays.toString(ids) }));
	}
}