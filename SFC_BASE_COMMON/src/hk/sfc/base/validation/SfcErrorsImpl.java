package hk.sfc.base.validation;

import hk.sfc.base.svc.message.SfcErrorMessage;
import hk.sfc.base.svc.message.SfcErrorMessageAvailable;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

/**
 *  Implementation of LicErrors.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcErrorsImpl extends BindException implements SfcErrors {

	private static final long serialVersionUID = -1964462201792714406L;

	private static final String DEFAULT_OBJECT_NAME = "command";

	/**
	 * Create a instance of SfcErrorsImpl. It will change the obj and name to empty string and defaultObjectName correspondingly if they are null.
	 * @param obj	target bean to bind on to.
	 * @param name	the name of the target object.
	 */
	public SfcErrorsImpl(Object obj, String name) {
		super(obj == null ? "" : obj, name == null ? DEFAULT_OBJECT_NAME : name);

	}

	/**
	 * Create a instance of SfcErrorsImpl. It will change the obj and name to empty string and defaultObjectName correspondingly if obj is null.
	 * Otherwise, the object class name will be used as the name of the target object.
	 * @param obj	target bean to bind on to.
	 */
	public SfcErrorsImpl(Object obj) {
		super(obj == null ? "" : obj, obj == null ? DEFAULT_OBJECT_NAME : obj.getClass().getName());
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * It will adapt the SfcErrorMessage to a ObjectError class and delegate to super.addError method.
	 */
	public void reject(SfcErrorMessage err) {
		super.addError(new ObjectErrorAdapter(getObjectName(), err));
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * Show the error details.<p>
	 * It will print out the total count of errors record. 
	 * For each ObjectError, if it is SfcErrorMessageAvailable, it will call print out getErrorMessage().showContent().
	 * Otherwise, it will print out the ObjectError by reflection.  
	 * @return the error details.
	 */
	public String showErrors() {
		StringBuffer _sb = new StringBuffer();
		_sb.append("Errors detail: ").append("\n");
		List _list = getAllErrors();
		_sb.append("Total count of errors: ").append(_list.size()).append("\n");
		ObjectError _objErr;
		for (int i = 0, _size = _list.size(); i < _size; i++) {
			_objErr = (ObjectError) _list.get(i);
			if (_objErr instanceof SfcErrorMessageAvailable)
				_sb.append(((SfcErrorMessageAvailable) _objErr).getErrorMessage().showContent())
						.append("\n");
			else _sb.append(ToStringBuilder.reflectionToString(_objErr)).append("\n");
		}
		return _sb.toString();
	}

}
