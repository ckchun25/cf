package hk.sfc.base.exception;


import hk.sfc.base.svc.message.MessageUtils;
import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;
import hk.sfc.base.validation.SfcErrors;
import hk.sfc.base.validation.SfcErrorsImpl;
import hk.sfc.base.validation.SfcErrorsUtils;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.core.NestedRuntimeException;

/**
 *  Runtime Exception.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR16449</TD><TD>24/08/2010</TD><TD>Suyee Li</TD><TD>Move the java source form LIC_BASE_COMMON to LIC_BASE_DOMAIN</TD></TR>
 * </TABLE>
 *
 */
public class SfcRuntimeException extends NestedRuntimeException implements SfcErrorsAvailable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2766131983789706092L;

	//****************************
	//* Member variables
	//****************************
	private SfcErrors errs;

	private String errorCode;

	// Constructor with LicErrorMessage

	/**
	 * Create a instance of SfcRuntimeException. 
	 * It will use the input MessageSource and Locale to resolve the code from LicErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param err	SfcErrorMessage object.
	 * @param msgSrc	MessageSource object.
	 * @param locale	Locale object.
	 */
	public SfcRuntimeException(SfcErrorMessage err, MessageSource msgSrc, Locale locale) {
		super(MessageUtils.getMessage(msgSrc, err, locale));
		errorCode = err.getCode();
		errs = new SfcErrorsImpl(null);
		errs.reject(err);
	}
	
	

	/**
	 * Create a instance of SfcRuntimeException. 
	 * It will use the default MessageSource and Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param err	SfcErrorMessage object.
	 * @param msgSrc	MessageSource object.
	 */
	public SfcRuntimeException(SfcErrorMessage err, MessageSource msgSrc) {
		this(err, msgSrc, null);
	}

	/**
	 * Create a instance of SfcRuntimeException. 
	 * It will use the default Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param err	SfcErrorMessage object.
	 */	
	public SfcRuntimeException(SfcErrorMessage err) {
		this(err, null, null);
	}

	// Constructor with LicErrors

	/**
	 * Create a instance of SfcRuntimeException.
	 * It will use the input MessageSource and Locale to resolve the code from the first LicErrorMessage in LicErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param sfcErrs	SfcErrorMessage object.
	 * @param msgSrc	MessageSource object.
	 * @param locale	Locale object.
	 */
	public SfcRuntimeException(SfcErrors sfcErrs, MessageSource msgSrc, Locale locale) {
		super(MessageUtils.getMessage(msgSrc, SfcErrorsUtils.getFirstErrorMessage(sfcErrs), locale));
		errorCode = SfcErrorsUtils.getFirstErrorMessage(sfcErrs).getCode();
		errs = sfcErrs;
	}

	/**
	 * Create a instance of SfcRuntimeException.
	 * It will use the default MessageSource and Locale to resolve the code from the first LicErrorMessage in LicErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param licErrs	LicErrorMessage object.
	 */
	public SfcRuntimeException(SfcErrors sfcErrs) {
		this(sfcErrs, null, null);
	}

	/**
	 * Create a instance of SfcRuntimeException.
	 * The input message will be used as the exception message.
	 * Also, the internal SfcErrors object will register a SfcInternalErrorMessage.MSG_ERR with the input message as the argument.
	 * 
	 * @param msg	the exception message.
	 */
	public SfcRuntimeException(String msg) {
		super(msg);
		errs = new SfcErrorsImpl(null);
		errs.reject(SfcInternalErrorMessage.MSG_ERR.withArg(msg));
		errorCode = SfcInternalErrorMessage.MSG_ERR.getCode();
	}

	/**
	 * Create a instance of SfcRuntimeException.
	 * The input message will be used as the exception message.
	 * Also, the internal SfcErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * @param msg	the exception message.
	 * @param ex	the throwable object.
	 */
	public SfcRuntimeException(String msg, Throwable ex) {
		super(msg, ex);
		errs = new SfcErrorsImpl(null);
		errs.reject(SfcInternalErrorMessage.EXCEPTION.withArg(msg).withEx(ex));
		errorCode = SfcInternalErrorMessage.EXCEPTION.getCode();
	}

	/**
	 * Create a instance of SfcRuntimeException.
	 * The internal SfcErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * @param ex	the throwable object.
	 */
	public SfcRuntimeException(Throwable ex) {
		this(ex.getMessage(), ex);
	}

	/**
	 * @see hk.sfc.base.exception.SfcErrorsAvailable#getErrors()
	 */
	public SfcErrors getErrors() {
		return errs;
	}

	/**
	 * getter method of errorCode
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * setter method of errorCode
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
