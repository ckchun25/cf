package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcAppErrorMessage;

/**
 * Exception thrown when notification section authorization check fails.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>14/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SectionAuthorizationException extends SvcException {

	private static final long serialVersionUID = -7235568058029494091L;

	/**
	 * Constructor.
	 * @param ceref central entity reference
	 * @param sectionClassName section class name
	 */
	public SectionAuthorizationException(String ceref, String sectionClassName) {
		super(SfcAppErrorMessage.SECTION_AUTHORIZATION_FAILURE.withArgs(new Object[] { ceref,
				sectionClassName }));
	}
}