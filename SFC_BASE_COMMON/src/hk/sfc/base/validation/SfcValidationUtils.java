package hk.sfc.base.validation;

import org.springframework.binding.validation.ValidationContext;
import org.springframework.validation.Errors;

/**
 *  Utility class for validation.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>13/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public final class SfcValidationUtils {

	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private SfcValidationUtils() {
	}

	/**
	 * Get the SfcValidationContext with Errors.
	 * @param errors	a Errors object.
	 * @return	a SfcValidationContext.
	 */
	public static SfcValidationContext toValidationContext(Errors errors) {
		return new SfcSpringMvcValidationContext(errors);
	}

	/**
	 * Get the SfcValidationContext with ValidationContext.
	 * @param context	a ValidationContext.
	 * @return	a SfcValidationContext.
	 */
	public static SfcValidationContext toValidationContext(ValidationContext context) {
		return new SfcSpringWebflowValidationContext(context);
	}

}
