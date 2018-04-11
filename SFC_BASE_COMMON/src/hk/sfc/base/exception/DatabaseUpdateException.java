package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcAppErrorMessage;

/**
 * Exception thrown when database record fails to be updated as expected.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>06/04/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class DatabaseUpdateException extends SfcRuntimeException {

	private static final long serialVersionUID = 7822140907187697065L;

	/**
	 * Constructor for single entity object associated with a CE Ref#.
	 * @param funcName function name
	 * @param id ID of entity object
	 */
	public DatabaseUpdateException(String funcName, Object id) {
		super(SfcAppErrorMessage.DATABASE_UPDATE_FAILURE.withArgs(new Object[] { funcName, id }));
	}
}
