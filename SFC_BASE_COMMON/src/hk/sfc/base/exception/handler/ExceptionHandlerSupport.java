package hk.sfc.base.exception.handler;

import hk.sfc.base.exception.SfcErrorsAvailable;
import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;
import hk.sfc.base.utils.ExceptionUtils;
import hk.sfc.base.validation.SfcErrors;
import hk.sfc.base.validation.SfcErrorsUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
/**
 *  A support class for the exception handling. It categorize the exception into 2 categories.<br>
 *  <li>exception implements LicErrorsAvailable</li>
 *  <li>exception NOT implements LicErrorAvailable</li>
 *  <p>
 *  For the exception implements LicErrorsAvailable, it will further categorized the exception into 3 categories<br>
 *  <li>Application Exception</li>
 *  <li>Internal Exception</li>
 *  <li>System Exception</li>
 *  <p>
 *  The logic of those exception handling is left for the extended class to implement.
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>04/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public abstract class ExceptionHandlerSupport implements ExceptionHandler, InitializingBean {

	protected final Log logger = LogFactory.getLog(getClass());

	/** The exception that should be rethrown, it is the class name only not the real class. */
	protected Set rethrownException;

	/** Set that stores the rethrown class */
	private Set rethrownExceptionClass = new HashSet();

	/**
	 * getter method of rethrownException
	 * @return the rethrownException
	 */
	public Set getRethrownException() {
		return rethrownException;
	}

	/**
	 * setter method of rethrownException
	 * @param rethrownException the rethrownException to set
	 */
	public void setRethrownException(Set rethrownException) {
		this.rethrownException = rethrownException;
	}

	/**
	 * Set up the rethrownException from String to Class object for later use.
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("Set up rethrown exception for exception handler.");
		}

		if (rethrownException != null) {
			String _className;

			Iterator _it = rethrownException.iterator();
			while (_it.hasNext()) {
				_className = (String) _it.next();
				if (logger.isDebugEnabled()) {
					logger.debug("Adding exception (" + _className + ") to rethrown set");
				}
				rethrownExceptionClass.add(Class.forName(_className));
			}

		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("No rethrown exception is specified in xml.");
			}
		}

	}

	/* (non-Javadoc) Interface Method */
	public boolean canHandle(Throwable t) {
		if (isExceptionRethrown(t)) {
			return false;
		}

		return true;
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * It define the flow of the exception categorization where the real handling will be implemented by the abstract method provided by this class.
	 */
	public final Object handleException(Throwable t, Object obj) {

		Throwable _cause = t.getCause();
		Object _handledObject = null;

		if (_cause == null) {
			preHandleException(t, obj);
			if (t instanceof SfcErrorsAvailable) {
				_handledObject = handleSfcErrors(((SfcErrorsAvailable) t).getErrors(), obj);
			} else {
				_handledObject = handleNonLicException(t, obj);
			}
			postHandleException(t, obj);
			return _handledObject;

		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Not yet a root exception, The cause of the exception is " + _cause);
			}

			return handleException(_cause, obj);
		}

	}

	/**
	 * Further categorize LicErrors into Application/Internal/System exception.
	 * @param licErrors
	 * @param obj
	 * @return Object
	 */
	protected final Object handleSfcErrors(SfcErrors licErrors, Object obj) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start to handle LicErrors:" + licErrors.toString());
		}

		SfcErrorMessage _errorMessage = SfcErrorsUtils.getFirstErrorMessage(licErrors);

		if (_errorMessage.getErrorType() == SfcErrorMessage.APP_ERROR) {
			return handleApplicationException(licErrors, obj);
		} else if (_errorMessage.getErrorType() == SfcErrorMessage.INTERNAL_ERROR) {
			return handleInternalException(licErrors, obj);
		} else if (_errorMessage.getErrorType() == SfcErrorMessage.SYSTEM_ERROR) {
			return handleSystemException(licErrors, obj);
		} else {
			logger.error("Invalid error type in SfcErrorMessage:" + _errorMessage.getErrorType());
			throw new SfcRuntimeException(SfcInternalErrorMessage.INVALID_TYPE
					.withArg("Error type in SfcErrorMessage is not valid; error type="
							+ _errorMessage.getErrorType()));
		}

	}

	/**
	 * Handle exception that is not a instance of SfcErrorAvailable.
	 * 
	 * @param t	throwable object.
	 * @param obj	object.
	 * @return	handled object.
	 */
	protected abstract Object handleNonLicException(Throwable t, Object obj);

	/**
	 * Handle application exception.
	 * @param sfcErrors	SfcErrors object.
	 * @param obj	object.
	 * @return	handled object.
	 */
	protected abstract Object handleApplicationException(SfcErrors sfcErrors, Object obj);

	/**
	 * Handle internal exception.
	 * @param sfcErrors	SfcErrors object.
	 * @param obj	object.
	 * @return	handled object.
	 */
	protected abstract Object handleInternalException(SfcErrors sfcErrors, Object obj);

	/**
	 * Handle system exception.
	 * @param licErrors	LicErrors object.
	 * @param obj	object.
	 * @return	handled object.
	 */
	protected abstract Object handleSystemException(SfcErrors sfcErrors, Object obj);

	/**
	 * Template method that provide pre-handling for processing Throwable.
	 * @param licErrors
	 * @param obj
	 */
	protected void preHandleException(Throwable t, Object obj) {

	}

	/**
	 * Template method that provide post-handing for processing Throwable.
	 * @param t
	 * @param obj
	 */
	protected void postHandleException(Throwable t, Object obj) {

	}

	/**
	 * Check if the Throwable is a Exception. Continue to process if it is a Exception, otherwise return false.<p>
	 * Then check if the input Throwable need to rethrown by compare with rethrownExceptionClass set. Return true if need to rethrown, otherwise false.
	 * 
	 * @param t
	 * @return	true if the Throwable need to rethrown, otherwise false.
	 */
	protected boolean isExceptionRethrown(Throwable t) {

		if (!(t instanceof Exception)) {
			return false;
		}

		// Re-thrown the exception without any handling.
		Iterator _it;
		Class _clazz;

		if (rethrownExceptionClass != null) {

			_it = rethrownExceptionClass.iterator();

			while (_it.hasNext()) {
				_clazz = (Class) _it.next();
				if (ExceptionUtils.isExist(t, _clazz)) {
					if (logger.isDebugEnabled()) {
						logger.debug("Throwable (" + t
								+ ") is rethrown. By the specified rethrown class "
								+ _clazz.getName());
					}
					return true;
				}
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger
						.debug("RethrownExceptionClass is null and hence no exception will be rethrown.");
			}
		}

		return false;

	}

}
