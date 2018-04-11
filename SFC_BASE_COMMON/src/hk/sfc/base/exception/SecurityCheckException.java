package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcErrorMessage;

/**
 * Security check exception. Create this exception when security checking is failure.
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
public class SecurityCheckException extends SfcRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8556646162802063810L;

	/**
	 * Create a instance of SecurityCheckException
	 * @param err	the SfcErrorMessage object.
	 */
	public SecurityCheckException(SfcErrorMessage err) {
		super(err);
	}

}
