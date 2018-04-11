package hk.sfc.base.validation;

import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcInternalErrorMessage;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.ObjectError;

/**
 *  Utility class to manipulate the SfcErrors.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public final class SfcErrorsUtils {

	private final static Log logger = LogFactory.getLog((SfcErrorsUtils.class));

	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private SfcErrorsUtils() {
	}

	/**
	 * Get the first SfcErrorMessage from the given LicErrors object. If the first SfcErrorMessage is a not a ObjectErrorAdaptor, it will throw exception.
	 * @param	errs LicErrors object.
	 * @return	the first SfcErrorMessage in the LicErrors object. Null if no error message found in LicErrors or the first return object is null.
	 * @throws	SfcRuntimeException if the first error message is not a ObjectErrorAdaptor.
	 */
	public static SfcErrorMessage getFirstErrorMessage(SfcErrors errs) {
		List _errList = errs.getAllErrors();
		if (_errList == null || _errList.size() == 0) return null;

		Object _err = _errList.get(0);

		if (_err == null) return null;

		if (_err instanceof ObjectErrorAdapter)
			return ((ObjectErrorAdapter) _err).getErrorMessage();

		throw new SfcRuntimeException(SfcInternalErrorMessage.INVALID_CLASS.withArgs(new String[] {
				"Sfc error adapter class", _err.getClass().getName() }));

	}

	/**
	 * Check whether the ObjectError is a SfcErrors.
	 * @param objErr
	 * @return true if the objErr is a SfcErrors.
	 */
	public static boolean isSfcErrors(ObjectError objErr) {
		if (objErr instanceof ObjectErrorAdapter) return true;

		return false;
	}

	/**
	 * Get the SfcErrorMessage which is stored in the ObjectError. If the ObjectError is not a LicErrors, it will throw exception.
	 * The function will check whether the ObjectError is a LicErrors. If not, a LicRuntimeException will be thrown.
	 * @param errs ObjectError
	 * @return the SfcErrorMessage
	 * @throws	SfcRuntimeException if the first error message is not a ObjectErrorAdaptor.
	 */
	public static SfcErrorMessage getErr(ObjectError err) {
		if (err == null) return null;

		if (isSfcErrors(err)) return ((ObjectErrorAdapter) err).getErrorMessage();

		throw new SfcRuntimeException(SfcInternalErrorMessage.INVALID_CLASS.withArgs(new String[] {
				"sfc error adapter class", err.getClass().getName() }));
	}

}
