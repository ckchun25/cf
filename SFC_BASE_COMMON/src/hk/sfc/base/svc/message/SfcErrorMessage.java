package hk.sfc.base.svc.message;



import hk.sfc.base.exception.SfcRuntimeException;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Represents a error message. It contains error type and also store exception
 * object.
 * 
 * 
 * <br>
 * &copy; The Securities And Futures Commission of Hong Kong. All rights reserved. <br>
 * Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>16/02/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR16449</TD><TD>24/08/2010</TD><TD>Suyee Li</TD><TD>Move the java source form LIC_BASE_COMMON to LIC_BASE_DOMAIN</TD></TR>
 * </TABLE>
 * 
 */
public class SfcErrorMessage extends SfcMessage {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7474725682808625147L;

	/**
	 * Error type: Unknown
	 */
	public static final int UNKNOWN_ERROR = 0;

	/**
	 * Error type: Application error
	 */
	public static final int APP_ERROR = 1;

	/**
	 * Error type: System Error
	 */
	public static final int SYSTEM_ERROR = 2;

	/**
	 * Error type: Internal Error
	 */
	public static final int INTERNAL_ERROR = 3;

	//	application error base message number
	public static final int APP_ERR_BASE = 2000;

	// system error base message number
	public static final int SYS_ERR_BASE = 8000;

	// internal error base message number
	public static final int INT_ERR_BASE = 9000;

	private Throwable exception;

	private int errorType = UNKNOWN_ERROR;

	private boolean isClone = false;

	/**
	 * Create a LicErrorMessage instance with message number, message level, message attribute,
	 * error type and exception.
	 * 
	 * @param msgNo
	 * @param msgLevel
	 * @param licMsgAttrs
	 * @param codes
	 * @param errType	It should be one of the error type defined in LicErrorMessage.
	 */
	public SfcErrorMessage(int msgNo, int msgLevel, SfcMessageAttributes licMsgAttrs,
			String[] codes, int errType) {
		super(msgNo, msgLevel, licMsgAttrs, codes, null);
		errorType = errType;

	}

	/**
	 * Get the throwable that associated to this Error Message.
	 * @return	the throwable associated. 
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * Associate the throwable to this Error Message.
	 * @param exception
	 */
	private void setException(Throwable exception) {
		this.exception = exception;
	}

	/**
	 * Get the error type of this error message.
	 * @return	the error type.
	 */
	public int getErrorType() {
		return errorType;
	}

	/**
	 * Set the error type for this error message.
	 * @param errorType
	 */
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	/**
	 * Set the message argument for the message and create a new instance of it.
	 * This make sure each same error message can have different arguments.
	 * 
	 * @param arg
	 *            The message argument.
	 * @return A cloned LicErrorMessage instance.
	 */
	public SfcErrorMessage withArg(Object arg) {
		return withArgs(new Object[] { arg });
	}

	/**
	 * Set the message argument for the message and create a new instance of it.
	 * This make sure each same error message can have different arguments.
	 * 
	 * @param objects
	 *            A array of argument.
	 * @return A cloned LicErrorMessage
	 */
	public SfcErrorMessage withArgs(Object[] objects) {
		SfcErrorMessage _message = this;
		if (!isClone) {
			try {
				_message = (SfcErrorMessage) clone();
			} catch (CloneNotSupportedException e) {
				logger.error("Cannot close the LicMessage =>", e);
				throw new SfcRuntimeException(e);
			}
		}
		_message.setArguments(objects);
		return _message;
	}

	/**
	 * Set the exception for the message and create a new instance of it. This make sure each same error message can have different
	 * exception. Also, the exception message within the exception will be set as the argument of
	 * the message if the message argument is null. 
	 * 
	 * @param ex
	 * @return A cloned LicErrorMessage
	 */
	public SfcErrorMessage withEx(Throwable ex) {
		SfcErrorMessage _message = this;
		if (!isClone) {
			try {
				_message = (SfcErrorMessage) clone();
			} catch (CloneNotSupportedException e) {
				logger.error("Cannot clone the LicMessage =>", e);
				throw new SfcRuntimeException(e);
			}
		}

		_message.setException(ex);
		if (_message.getArguments() == null)
			_message.setArguments(new Object[] { ex.getMessage() });

		return _message;
	}

	/**
	 * Return the toString() of super class and also the error type and exception in this instance.
	 * @return the content of the error message.
	 */
	public String showContent() {
		return toString();
	}

	/** 
	 * Call the super.toString and also provided custom error message.
	 * @see hk.sfc.licportal.base.message.LicMessage#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append("Error type",
				errorType).append("ex", getException()).toString();
	}

	/**
	 * Clone LicErrorMessage object.
	 * 
	 * @return cloned LicErrorMessage
	 */
	protected Object clone() throws CloneNotSupportedException {
		if (logger.isDebugEnabled()) {
			logger.debug("Clone LicErrorMessage object");
		}

		SfcErrorMessage _clonedErrorMessage =
				new SfcErrorMessage(messageNo, messageLevel, sfcMessageAttrs, codes, errorType);
		_clonedErrorMessage.setClone(true);
		return _clonedErrorMessage;
	}

	/**
	 * Set the clone status.
	 * @param b true if the clone is completed, otherwise false.
	 */
	private void setClone(boolean b) {

		isClone = b;
	}

}
