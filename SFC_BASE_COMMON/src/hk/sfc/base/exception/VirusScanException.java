package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.exception.SvcException;

/**
 * Exception thrown when virus scan fails.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>25/02/2011</TD><TD>lcktong1</TD><TD>Initial version based on P2B</TD></TR>
 * </TABLE>
 */
public class VirusScanException extends SvcException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6057577893117112238L;

	/**
	 * Constructor with error message.
	 * @param msg error message
	 */
	public VirusScanException(SfcErrorMessage msg) {
		super(msg);
	}
}
