package hk.sfc.base.svc.message;

import hk.sfc.base.exception.SfcRuntimeException;

/**
 *  A base message class which is for general message registration. 
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>18/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcGeneralMessage extends SfcMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310455063487861296L;

	private boolean isClone = false;

	/**	general message base number */
	public static final int GENERAL_MSG_BASE = 1000;

	/**
	 * Construct a instance where the message level is set to INFO and LicMessageAttributes set to send none.
	 * @param msgNo
	 */
	public SfcGeneralMessage(int msgNo) {
		super(msgNo, SfcMessage.INFO, SfcMessageAttributes.SEND_NONE, null, null);
	}

	/**
	 * Set the message argument for the message and create a new instance of it.
	 * This make sure each same  message can have different arguments.
	 * 
	 * @param arg
	 *            The message argument.
	 * @return A cloned LicErrorMessage instance.
	 */
	public SfcGeneralMessage withArg(Object arg) {
		return withArgs(new Object[] { arg });
	}

	/**
	 * Set the message argument for the message and create a new instance of it.
	 * This make sure each same  message can have different arguments.
	 * 
	 * @param objects
	 *            A array of argument.
	 * @return A cloned SfcErrorMessage
	 */
	public SfcGeneralMessage withArgs(Object[] objects) {
		SfcGeneralMessage _message = this;
		if (!isClone) {
			try {
				_message = (SfcGeneralMessage) clone();
			} catch (CloneNotSupportedException e) {
				logger.error("SfcGeneralMessage =>", e);
				throw new SfcRuntimeException(e);
			}
		}
		_message.setArguments(objects);
		return _message;
	}

	/**
	 * Clone LicGeneralMessage object.
	 * 
	 * @return cloned LicErrorMessage
	 */
	protected Object clone() throws CloneNotSupportedException {
		if (logger.isDebugEnabled()) {
			logger.debug("Clone LicGeneralMessage object");
		}

		SfcGeneralMessage _clonedMessage = new SfcGeneralMessage(messageNo);
		_clonedMessage.setClone(true);
		return _clonedMessage;
	}

	/**
	 * Set the clone status.
	 * @param b true if the clone is completed, otherwise false.
	 */
	private void setClone(boolean b) {

		isClone = b;
	}

}
