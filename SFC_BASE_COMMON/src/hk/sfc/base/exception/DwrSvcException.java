package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcErrorMessage;

/**
 * DWR Service Exception.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>30/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class DwrSvcException extends SvcException {

	private static final long serialVersionUID = 7191853701363979225L;

	/**
	 * Create a instance of DwrSvcException.
	 * @param errMsg
	 */
	public DwrSvcException(SfcErrorMessage errMsg) {
		super(errMsg);
	}

}
