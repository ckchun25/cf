package hk.sfc.base.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *  Base validator.
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
public abstract class SfcValidator implements Validator {

	/* (non-Javadoc) Interface Method */
	/**
	 * This method is finalize to convert the Errors to SfcValidationContext. Developers should code their validation logic in validateObject method.
	 */
	public final void validate(Object target, Errors errors) {

		validateObject(target, SfcValidationUtils.toValidationContext(errors));
	}

	/**
	 * Validate the input object and use LicValidationContext to register the errors.
	 * @param target
	 * @param validationContext
	 */
	public abstract void validateObject(Object target, SfcValidationContext validationContext);

}
