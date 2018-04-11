package hk.sfc.base.exception;


import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.validation.SfcErrors;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 *  System Exception.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcSystemException extends SfcRuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1602182636082875494L;

	/**
	 * Create a instance of SfcSystemException. 
	 * It will use the input MessageSource and Locale to resolve the code from SfcErrorMessage. 
	 * The resolved message will be used as exception message.
	 * @param err	the SfcErrorMessage object.
	 * @param msgSrc	the MessageSource object.
	 * @param locale	the Locale object.
	 */
	public SfcSystemException(SfcErrorMessage err, MessageSource msgSrc, Locale locale) {
		super(err, msgSrc, locale);
	}

	/**
	 * Create a instance of SfcSystemException. 
	 * It will use the default Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param err	the SfcErrorMessage object.
	 */
	public SfcSystemException(SfcErrorMessage err) {			
		super(err);
	}

	/**
	 * Create a instance of SfcSystemException. 
	 * It will use the default MessageSource and Locale to resolve the code from LicErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param err	the SfcErrorMessage object.
	 * @param msgSrc	the MessageSource object.
	 */
	public SfcSystemException(SfcErrorMessage err, MessageSource msgSrc) {
		super(err, msgSrc);
	}

	/**
	 * Create a instance of SfcSystemException.
	 * It will use the input MessageSource and Locale to resolve the code from the first LicErrorMessage in LicErrors.
	 * The resolved message will be used as exception message.
	 * @param sfcErrs	SfcErrorMessage object.
	 * @param msgSrc	MessageSource object.
	 * @param locale	Locale object.
	 */
	public SfcSystemException(SfcErrors sfcErrs, MessageSource msgSrc, Locale locale) {
		super(sfcErrs, msgSrc, locale);
	}

	/**
	 * Create a instance of SfcSystemException.
	 * It will use the default MessageSource and Locale to resolve the code from the first LicErrorMessage in LicErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param licErrs	LicErrorMessage object.
	 */
	public SfcSystemException(SfcErrors errs) {
		super(errs);
	}

	/**
	 * Create a instance of SfcSystemException.
	 * The input message will be used as the exception message.
	 * Also, the internal LicErrors object will register a LicInternalErrorMessage.MSG_ERR with the input message as the argument.
	 * 
	 * @param msg	the exception message.
	 */
	public SfcSystemException(String msg) {
		super(msg);
	}

	/**
	 * Create a instance of SfcSystemException.
	 * The input message will be used as the exception message.
	 * Also, the internal LicErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * @param msg	the exception message.
	 * @param ex	the throwable object.
	 */
	public SfcSystemException(String msg, Throwable ex) {
		super(msg, ex);
	}

	/**
	 * Create a instance of SfcSystemException.
	 * The internal LicErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * @param ex	the throwable object.
	 */
	public SfcSystemException(Throwable ex) {
		super(ex);
	}

}
