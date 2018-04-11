package hk.sfc.base.validation;


import hk.sfc.base.svc.message.SfcErrorMessage;

import org.springframework.validation.Errors;

/**
 *  The SfcErrorMessage object container which can register a group of SfcErrorMessage.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface SfcErrors extends Errors {

	/**
	 * Register a SfcErrorMessage
	 * @param err a SfcErrorMessage
	 */
	public void reject(SfcErrorMessage err);

	/**
	 * Return a string represent the collection of the SfcErrorMessage.
	 * @return	a string represent the collection of the SfcErrorMessage.
	 */
	public String showErrors();

}
