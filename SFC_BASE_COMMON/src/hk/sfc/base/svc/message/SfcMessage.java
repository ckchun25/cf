package hk.sfc.base.svc.message;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSourceResolvable;

/**
 * It represents a message that contains message number and message attributes.
 * It is used to store the information that can be used to build up a message
 * from resource bundle.
 * 
 * <br>
 * &copy; The Securities And Futures Commission of Hong Kong. All rights reserved. <br>
 * Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>04/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR16449</TD><TD>24/08/2010</TD><TD>Suyee Li</TD><TD>Move the java source form LIC_BASE_COMMON to LIC_BASE_DOMAIN</TD></TR>
 * </TABLE>
 * 
 */
public class SfcMessage implements MessageSourceResolvable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893873842883222497L;
	/** Message Level: Info */
	public static final int INFO = 1;
	/** Message Level: Error */
	public static final int ERROR = 2;
	/** Message Level: Warning */
	public static final int WARNING = 3;
	/** Message Level: Critical */
	public static final int CRITICAL = 4;


	private static DecimalFormat decFormat = new DecimalFormat("0000");

	/**
	 * Message number
	 */
	protected int messageNo;

	/**
	 * Message Level (INFO, ERROR, WARNING, CRITICAL) 
	 */
	protected int messageLevel = WARNING;

	/**
	 * Prefix for the message code
	 */
	protected String prefix = "Lic";

	/**
	 * Message Attributes.
	 */
	protected SfcMessageAttributes sfcMessageAttrs;

	/**
	 * Variables for the message.
	 */
	protected Object[] arguments;

	/**
	 * Message codes that exist in the resource bundle.
	 */
	protected String[] codes;

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Create a new instance.
	 * 
	 * @param msgNo
	 *            The message number.
	 * @param msgLevel
	 *            The message level.
	 * @param licMsgAttrs
	 *            Message Attributes.
	 * @param msgCodes
	 *            Message Codes where those code will be used to retrieve
	 *            message from message source.
	 * @param msgArguments
	 *            value that will be used as the argument in the message.
	 */
	public SfcMessage(int msgNo, int msgLevel, SfcMessageAttributes sfcMsgAttrs, String[] msgCodes,
			Object[] msgArguments) {
		messageNo = msgNo;
		messageLevel = msgLevel;
		sfcMessageAttrs = sfcMsgAttrs;
		codes = msgCodes;
		arguments = msgArguments;
	}

	/**
	 * Create a LicMessage with WARNING as the default message level.
	 * @param msgNo
	 */
	public SfcMessage(int msgNo) {
		this(msgNo, WARNING, null, null, null);
	}

	/**
	 * Return the message number.
	 * @return	a message number.
	 */
	public int getMessageNo() {
		return messageNo;
	}

	/**
	 * Return the message level.
	 * @return	a message level.
	 */
	public int getMessageLevel() {
		return messageLevel;
	}

	/**
	 * Set the message level.
	 * @param msgLevel	the message level to be set.
	 */
	protected void setMessageLevel(int msgLevel) {
		messageLevel = msgLevel;
	}

	/* (non-Javadoc) Interface Method */
	public Object[] getArguments() {
		return arguments;
	}

	/**
	 * Set the message arguments
	 * @param arguments	the arugments to be set.
	 */
	protected void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * Get the codes to retrieve the message from message source. 
	 * If the codes is null, it will return a single String array which is prefix+message number. 
	 * The message number will be format as a fixed of 4. 
	 * e.g. if the message number is 123, the return will be "Lic0123". 
	 * 
	 * @return A array of message code.
	 */
	public String[] getCodes() {
		if (codes == null) {
			String[] _str = { prefix + decFormat.format(messageNo) };
			return _str;
		} else {
			return codes;
		}

	}

	/**
	 * Get the first message code.
	 * 
	 * @return the message code.
	 */
	public String getCode() {
		return getCodes()[0];
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * Return the message number, message level and the details of message attributes.
 	 */
	public String getDefaultMessage() {
		StringBuffer _sb = new StringBuffer();
		_sb.append("message No=" + messageNo);
		_sb.append("; message Level=" + messageLevel);
		_sb.append("; messge Attributes=" + sfcMessageAttrs);
		return _sb.toString();
	}

	/**
	 * Get the SfcMessageAttributes.
	 * @return	the SfcMessageAttributes.
	 */
	public SfcMessageAttributes getLicMessageAttrs() {
		return sfcMessageAttrs;
	}

	/**
	 * Set the SfcMessageAttributes.
	 * @param sfcMessageAttrs	the SfcMessageAttributes to be set.
	 */
	public void setLicMessageAttrs(SfcMessageAttributes sfcMessageAttrs) {
		this.sfcMessageAttrs = sfcMessageAttrs;
	}

	/**
	 * Override the toString method to return customized message.
	 * @return a customized message.
	 */
	public String toString() {

		return new ToStringBuilder(this).append("message No", getMessageNo()).append(
				"message Attribute", getLicMessageAttrs()).append("message code", getCodes(), true)
				.append("message arguments", getArguments(), true).toString();
	}

}
