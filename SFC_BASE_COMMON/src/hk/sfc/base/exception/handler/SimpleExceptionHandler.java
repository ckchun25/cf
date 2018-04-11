package hk.sfc.base.exception.handler;

import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.exception.SfcSystemException;
import hk.sfc.base.security.ContextUtils;
import hk.sfc.base.validation.SfcErrors;
import hk.sfc.base.validation.SfcErrorsUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 *  A class provide a simple exception handling.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SimpleExceptionHandler extends ExceptionHandlerSupport {

	/**
	 * Nothing to do with the application exception and just return the SfcErrors.
	 * @return SfcErrors
	 * @see hk.sfc.base.exception.handler.ExceptionHandlerSupport#handleApplicationException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleApplicationException(SfcErrors SfcErrors, Object obj) {
		// nothing to do, just return the SfcErrors object.
		return SfcErrors;
	}

	/**
	 * Log all the errors message with logging level error.<p>
	 * Wrap the SfcErrors in LicRuntimeException and throw it out. Hence, no object will be returned. 
	 * @see hk.sfc.base.exception.handler.ExceptionHandlerSupport#handleInternalException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleInternalException(SfcErrors sfcErrors, Object obj) {

		// Log the error and wrap the errors as runtimeException and throw it.
		logger.error("############# Internal Exception is found #############");
		logger.error("Login user ID & error code: "
				+ ContextUtils.getAppUserProfile().getUserUniqueKey() + "#"
				+ SfcErrorsUtils.getFirstErrorMessage(sfcErrors).getCode());
		logger.error(sfcErrors.showErrors());
		throw new SfcRuntimeException(sfcErrors);

	}

	/**
	 * Log all the errors message with logging level error.<p>
	 * Wrap the SfcErrors in LicSystemException and throw it out. Hence, no object will be returned.
	 * @see hk.sfc.base.exception.handler.ExceptionHandlerSupport#handleSystemException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleSystemException(SfcErrors sfcErrors, Object obj) {
		// Log the error and wrap the errors as runtimeException and throw it.
		logger.error("############# System Exception is found #############");
		logger.error("Login user ID & error code: "
				+ ContextUtils.getAppUserProfile().getUserUniqueKey() + "#"
				+ SfcErrorsUtils.getFirstErrorMessage(sfcErrors).getCode());
		logger.error(sfcErrors.showErrors());
		throw new SfcSystemException(sfcErrors);
	}

	/**
	 * Log the Throwable with error level. <p>
	 * Log the stackTrace as well for debug level. <p>
	 * Warp the exception with SfcSystemException and rethrown it.
	 * @see hk.sfc.base.exception.handler.ExceptionHandlerSupport#handleNonLicException(java.lang.Throwable, java.lang.Object)
	 */
	protected Object handleNonLicException(Throwable t, Object obj) {
		// By default, just log the exception and wrap it as LicRuntimeException and throw it.

		logger.error("############# Non Lic Exception is found #############");
		logger.error("Login user ID: "
				+ ContextUtils.getAppUserProfile().getUserUniqueKey());
		logger.error("Throwable = " + t);
		logger.error("Throwable.getMessage() = " + t.getMessage());

		StackTraceElement[] _stackTrace = t.getStackTrace();
		for (int i = 0; i < _stackTrace.length; i++) {
			logger.error(_stackTrace[i]);
		}

		// Handle different kind of exception.
		if (t instanceof SQLException) {
			return handleException((SQLException) t, obj);
		} else if (t instanceof IOException) {
			return handleException((IOException) t, obj);
		} else {
			logger.error("Unknown exception.", t);
			throw new SfcSystemException(t);
		}

	}

	/**
	 * Log the SQLException details and rethrown it as LicSystemException.
	 * @param sqlEx
	 * @param obj
	 * @return Object
	 * @throws SfcSystemException
	 */
	protected Object handleException(SQLException sqlEx, Object obj) throws SfcSystemException {
		logger.error("SQLException => SQLCODE: [" + sqlEx.getErrorCode() + "], SQLSTATE: "
				+ sqlEx.getSQLState() + "], msg: " + sqlEx.getMessage(), sqlEx);

		throw new SfcSystemException(sqlEx);
	}

	/**
	 * Log the IOException details and rethrown it as LicSystemException.
	 * @param ioEx
	 * @param obj
	 * @return Object
	 * @throws SfcSystemException
	 */
	protected Object handleException(IOException ioEx, Object obj) throws SfcSystemException {
		logger.error("IOException is found", ioEx);

		throw new SfcSystemException(ioEx);
	}

	/**
	 * Set the transaction status to roll back.
	 */
	protected void preHandleException(Throwable t, Object obj) {
		ContextUtils.setTransactionRollback();
	}

}
