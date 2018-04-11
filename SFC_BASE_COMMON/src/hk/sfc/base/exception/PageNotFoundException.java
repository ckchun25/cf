package hk.sfc.base.exception;


/**
 * Exception thrown when the request is not found.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/06/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class PageNotFoundException extends SfcCheckedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1289947863955659342L;

	/**
	 * Constructor.
	 * @param msg
	 */
	public PageNotFoundException(String msg) {
		super(msg);

	}

}
