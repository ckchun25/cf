package hk.sfc.base.exception;

import java.util.Locale;

import org.springframework.context.MessageSource;

import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.validation.SfcErrors;

/**
 *  Service Exception. All service method should throws this exception.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SvcException extends SfcCheckedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2180583342888585624L;

	/**
	 * constructor
	 * @param msg
	 */
	public SvcException(String msg) {
		super(msg);
	}

	/**
	 * Create a instance of SvcException. 
	 * It will use the input MessageSource and Locale to resolve the code from LicErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param errMsg
	 * @param msgSrc
	 * @param locale
	 */
	public SvcException(SfcErrorMessage errMsg, MessageSource msgSrc,
			Locale locale) {
		super(errMsg, msgSrc, locale);
		
	}

	/**
	 * Create a instance of SvcException. 
	 * It will use the default Locale to resolve the code from LicErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param errMsg
	 * @param msgSrc
	 */
	public SvcException(SfcErrorMessage errMsg, MessageSource msgSrc) {
		super(errMsg, msgSrc);
		
	}

	/**
	 * Create a instance of SvcException. 
	 * It will use the default MessageSource and Locale to resolve the code from LicErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param errMsg
	 */
	public SvcException(SfcErrorMessage errMsg) {
		super(errMsg);
		
	}

	/**
	 * Create a instance of SvcException.
	 * It will use the input MessageSource and Locale to resolve the code from the first SfcErrorMessage in SfcErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param sfcErrs
	 * @param msgSrc
	 * @param locale
	 */
	public SvcException(SfcErrors sfcErrs, MessageSource msgSrc, Locale locale) {
		super(sfcErrs, msgSrc, locale);
		
	}

	/**
	 * Create a instance of SvcException.
	 * It will use the default MessageSource and Locale to resolve the code from the first SfcErrorMessage in SfcErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param errs
	 */
	public SvcException(SfcErrors errs) {
		super(errs);
		
	}

	/**
	 * Create a instance of SvcException.
	 * The input message will be used as the exception message.
	 * Also, the internal LicErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * 
	 * @param msg
	 * @param ex
	 */
	public SvcException(String msg, Throwable ex) {
		super(msg, ex);
		
	}

	/**
	 * Create a instance of SvcException.
	 * The internal LicErrors object will register a LicInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * 
	 * @param ex
	 */
	public SvcException(Throwable ex) {
		super(ex);
		
	}

}
