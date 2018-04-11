package hk.sfc.base.exception;

import hk.sfc.base.validation.SfcErrors;


/**
 *  Add the capability to get LicErrors object.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface SfcErrorsAvailable {
	
	/**
	 * Get SfcErrors.
	 * @return LicErrors
	 */
	public SfcErrors getErrors();
	
	/** 
	 * Get the root cause of the error.
	 * @return Throwable
	 */
	public Throwable getCause();

}
