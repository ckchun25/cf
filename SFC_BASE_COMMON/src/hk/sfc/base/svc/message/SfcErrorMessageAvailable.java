package hk.sfc.base.svc.message;



/**
 *  Add the capability to get SfcErrorMessage.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface SfcErrorMessageAvailable {
	
	/**
	 * Get the LicErrorMessage object.
	 * @return	a LicErrorMessage.
	 */
	public SfcErrorMessage getErrorMessage();

}
