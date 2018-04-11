package hk.sfc.base.exception.handler;

import hk.sfc.base.exception.DwrSvcException;
import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.exception.SfcSystemException;
import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;
import hk.sfc.base.validation.SfcErrors;
import hk.sfc.base.validation.SfcErrorsUtils;

import org.directwebremoting.extend.Reply;

/**
 * Exception handler that is used in DWR calling.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>27/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class DwrExceptionHandler extends SimpleExceptionHandler {

	/**
	 * Create a new Reply object and set DwrSvcException as the throwable property.<p>
	 * @see hk.sfc.base.exception.handler.SimpleExceptionHandler#handleApplicationException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleApplicationException(SfcErrors SfcErrors, Object obj) {

		String _callId = obj.toString();

		SfcErrorMessage _errorMessage = SfcErrorsUtils.getFirstErrorMessage(SfcErrors);
		DwrSvcException _dwrSvcException = new DwrSvcException(_errorMessage);
		Reply _reply = new Reply(_callId, null, _dwrSvcException);

		return _reply;
	}

	/**
	 * Create a new Reply object set SfcRuntimeException as the throwable property.<p>
	 * The DWR config can convert the erroCode property in SfcRuntimeException.
	 * @see hk.sfc.base.exception.handler.SimpleExceptionHandler#handleInternalException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleInternalException(SfcErrors sfcErrors, Object obj) {

		String _callId = obj.toString();

		try {
			super.handleInternalException(sfcErrors, obj);
		} catch (SfcRuntimeException e) {
			return new Reply(_callId, null, e);
		}

		return new Reply(_callId, null, new SfcRuntimeException(
				SfcInternalErrorMessage.SHOULD_NOT_REACH.withArgs(new Object[] {
						this.getClass().getName(), "handleInternalException" })));
	}

	/**
	 * Create a new Reply object set SfcSystemException as the throwable property.<p>
	 * The DWR config can convert the erroCode property in SfcSystemException.
	 * @see hk.sfc.base.exception.handler.SimpleExceptionHandler#handleNonLicException(java.lang.Throwable, java.lang.Object)
	 */
	protected Object handleNonLicException(Throwable t, Object obj) {
		String _callId = obj.toString();

		try {
			super.handleNonLicException(t, obj);
		} catch (SfcSystemException e) {
			return new Reply(_callId, null, e);
		}

		return new Reply(_callId, null, new SfcRuntimeException(
				SfcInternalErrorMessage.SHOULD_NOT_REACH.withArgs(new Object[] {
						this.getClass().getName(), "handleNonLicException" })));
	}

	/**
	 * Create a new Reply object set SfcSystemException as the throwable property.<p>
	 * The DWR config can convert the erroCode property in SfcSystemException.
	 * @see hk.sfc.base.exception.handler.SimpleExceptionHandler#handleSystemException(hk.sfc.base.validation.SfcErrors, java.lang.Object)
	 */
	protected Object handleSystemException(SfcErrors sfcErrors, Object obj) {

		String _callId = obj.toString();
		try {
			super.handleSystemException(sfcErrors, obj);
		} catch (SfcSystemException e) {
			return new Reply(_callId, null, e);
		}

		return new Reply(_callId, null, new SfcRuntimeException(
				SfcInternalErrorMessage.SHOULD_NOT_REACH.withArgs(new Object[] {
						this.getClass().getName(), "handleSystemException" })));
	}

}
