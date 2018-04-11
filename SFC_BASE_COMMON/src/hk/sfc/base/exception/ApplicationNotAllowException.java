package hk.sfc.base.exception;

/**
 * Exception thrown when access to the application is not allowed. E.g. EOD is running.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/05/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ApplicationNotAllowException extends SfcCheckedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029389895318385075L;

	/**
	 * Constructor of ApplicationNotAllowException.
	 * @param msg	the error message.
	 */
	public ApplicationNotAllowException(String msg) {
		super(msg);
	}

}
