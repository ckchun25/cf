package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;
import hk.sfc.base.svc.message.MessageUtils;
import hk.sfc.base.validation.SfcErrors;
import hk.sfc.base.validation.SfcErrorsImpl;
import hk.sfc.base.validation.SfcErrorsUtils;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.core.NestedCheckedException;

/**
 *  Checked Exception.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcCheckedException extends NestedCheckedException implements SfcErrorsAvailable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5140775883468654959L;
	
	private SfcErrors errs;
	
	
	// Constructor with SfcErrorMessage.
	
	/**
	 * Create a instance of SfcCheckedException. 
	 * It will use the input MessageSource and Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 */
	public SfcCheckedException(SfcErrorMessage errMsg, MessageSource msgSrc, Locale locale) {
		super(MessageUtils.getMessage(msgSrc, errMsg, locale));
		errs = new SfcErrorsImpl(null);
		errs.reject(errMsg);
	}
	
	/**
	 * Create a instance of SfcCheckedException. 
	 * It will use the default MessageSource and Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param errMsg
	 */
	public SfcCheckedException(SfcErrorMessage errMsg) {
		this(errMsg, null, null);
	}
	
	/**
	 * Create a instance of SfcCheckedException. 
	 * It will use the default Locale to resolve the code from SfcErrorMessage.
	 * The resolved message will be used as exception message.
	 * @param errMsg
	 * @param msgSrc
	 */
	public SfcCheckedException(SfcErrorMessage errMsg, MessageSource msgSrc) {
		this(errMsg, msgSrc, null);
	}
	
	// Constructor with SfcErrors.
	/**
	 * Create a instance of SfcCheckedException.
	 * It will use the input MessageSource and Locale to resolve the code from the first SfcErrorMessage in SfcErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param sfcErrs
	 * @param msgSrc
	 * @param locale
	 */
	public SfcCheckedException(SfcErrors sfcErrs, MessageSource msgSrc, Locale locale)
	{
		super(MessageUtils.getMessage(msgSrc, SfcErrorsUtils.getFirstErrorMessage(sfcErrs), locale));
		errs = sfcErrs;
	}
	
	/**
	 * Create a instance of SfcCheckedException.
	 * It will use the default MessageSource and Locale to resolve the code from the first SfcErrorMessage in SfcErrors.
	 * The resolved message will be used as exception message.
	 * 
	 * @param errs
	 */
	public SfcCheckedException(SfcErrors errs)
	{
		this(errs, null, null);
	}
	
	
	/**
	 * Create a instance of SfcCheckedException.
	 * The input message will be used as the exception message.
	 * Also, the internal SfcErrors object will register a SfcInternalErrorMessage.MSG_ERR with the input message as the argument.  
	 * @param msg
	 */
	public SfcCheckedException(String msg) {
		super(msg);
		errs = new SfcErrorsImpl(null);
		errs.reject(SfcInternalErrorMessage.MSG_ERR.withArg(msg));
	}
	
	/**
	 * Create a instance of SfcCheckedException.
	 * The input message will be used as the exception message.
	 * Also, the internal SfcErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * 
	 * @param msg
	 * @param ex
	 */
	public SfcCheckedException(String msg, Throwable ex) {
		super(msg, ex);
		errs = new SfcErrorsImpl(null);
		errs.reject(SfcInternalErrorMessage.EXCEPTION.withArg(msg).withEx(ex));
	}
	
	/**
	 * Create a instance of SfcCheckedException.
	 * The internal SfcErrors object will register a SfcInternalErrorMessage.EXCEPTION with the input exception as the argument.
	 * 
	 * @param ex
	 */
	public SfcCheckedException(Throwable ex) {
		this(ex.getMessage(), ex);
	}

	/**
	 *
	 * @see hk.sfc.base.exception.SfcErrorsAvailable#getErrors()
	 */
	public SfcErrors getErrors() {
		return errs;
	}

}
