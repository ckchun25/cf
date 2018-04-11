package hk.sfc.base.validation;

import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcErrorMessageAvailable;

import org.springframework.validation.ObjectError;

/**
 *  Adpator class for ObjectError.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ObjectErrorAdapter extends ObjectError implements
		SfcErrorMessageAvailable {
	
	private static final long serialVersionUID = -4106238708058373739L;
	private SfcErrorMessage errMsg = null;
	
	/**
	 * Create a ObjectError instance with the given object name and SfcErrorMessage.
	 * @param objName
	 * @param err
	 */
	public ObjectErrorAdapter(String objName, SfcErrorMessage err) {
		super(objName, err.getCodes(), err.getArguments(), err
				.getDefaultMessage());
		errMsg = err;
	}

	/* (non-Javadoc) Interface Method */
	public SfcErrorMessage getErrorMessage() {
		return errMsg;
	}

}
