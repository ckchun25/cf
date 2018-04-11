package hk.sfc.base.svc.message;

import org.springframework.util.StringUtils;

/**
 * It represents the message attributes. There are 2 attributes: <br>
 * <li>End user message</li> <li>Operator user message</li> <br>
 * You can pass the string as follow to the constructor to create the object:
 * "+ENDUSR_MSG,-OPER_MSG" --> set end user message to true and set operator
 * message to false.
 * 
 * 
 * <br>
 * &copy; The Securities And Futures Commission of Hong Kong. All rights reserved. <br>
 * Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 * 
 */
public class SfcMessageAttributes {

	/** Message text for easy configuration */
	public static final String OPER_MSG = "OPER_MSG";
	public static final String ENDUSR_MSG = "ENDUSR_MSG";

	// Pre-created SfcMessageAttributes object
	public static final SfcMessageAttributes SEND_ALL =
			new SfcMessageAttributes("+" + ENDUSR_MSG + ",+" + OPER_MSG);
	public static final SfcMessageAttributes SEND_NONE =
			new SfcMessageAttributes("-" + ENDUSR_MSG + ",-" + OPER_MSG);
	public static final SfcMessageAttributes SEND_ENDUSR_ONLY =
			new SfcMessageAttributes("+" + ENDUSR_MSG + ",-" + OPER_MSG);
	public static final SfcMessageAttributes SEND_OPER_ONLY =
			new SfcMessageAttributes("-" + ENDUSR_MSG + ",+" + OPER_MSG);

	/** member variables */
	protected boolean endUserMessage = true;
	protected boolean operatorMessage = false;

	/**
	 * Constructor with end user message set to true and operator message set to
	 * false.
	 */
	public SfcMessageAttributes() {

	}

	/**
	 * Constructor for SfcMessageAttributes.java
	 * 
	 * @param msgAttrsStr	Message attribute string.
	 */
	public SfcMessageAttributes(String msgAttrsStr) {
		setMsgAttrs(msgAttrsStr);
	}

	/**
	 * It will based on the message attribute values to set up whether send message to end user and operator. 
	 * @param msgAttrsStr
	 *            The String should conform to this format
	 *            "+ENDUSR_MSG,-OPER_MSG"
	 */
	public void setMsgAttrs(String msgAttrsStr) {
		if (msgAttrsStr == null || "".equals(msgAttrsStr.trim())) return;

		// tokenize it with ","
		String[] _tokens = StringUtils.commaDelimitedListToStringArray(msgAttrsStr);
		for (int i = 0; i < _tokens.length; i++) {
			// Trim leading and trailing whitespace.
			String _token = _tokens[i].trim();

			// Check token type.
			boolean _enabled = true;
			switch (_token.charAt(0)) {
				case '+':
					_enabled = true;
					_token = _token.substring(1);
					break;
				case '-':
					_enabled = false;
					_token = _token.substring(1);
					break;
				default:
					break;
			}
			if (_token.equals(ENDUSR_MSG)) {
				setEndUserMessage(_enabled);
			} else if (_token.equals(OPER_MSG)) {
				setOperatorMessage(_enabled);
			}
		}
	}

	/**
	 * @return Returns the endUserMessage.
	 */
	public boolean isEndUserMessage() {
		return endUserMessage;
	}

	/**
	 * @param isEndUserMessage
	 *            The endUserMessage to set.
	 */
	public void setEndUserMessage(boolean isEndUserMessage) {
		endUserMessage = isEndUserMessage;
	}

	/**
	 * @return Returns the operatorMessage.
	 */
	public boolean isOperatorMessage() {
		return operatorMessage;
	}

	/**
	 * setter method of operatorMessage
	 * @param isOperatorMessage
	 *            The operatorMessage to set.
	 */
	public void setOperatorMessage(boolean isOperatorMessage) {
		operatorMessage = isOperatorMessage;
	}

	/**
	 * Return a string in a format as follows: <br>
	 * ENDUSR_MSG=true|OPER_MSG=false<br>
	 * where it represents whether it is the message for enduser or operator.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer _sb = new StringBuffer();
		_sb.append(ENDUSR_MSG).append("=").append(isEndUserMessage()).append("|");
		_sb.append(OPER_MSG).append("=").append(isOperatorMessage());
		return _sb.toString();
	}

	/**
	 * Return true if both endUserMessage property and endUserMessage property are the same. Otherwise false. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o instanceof SfcMessageAttributes) {
			SfcMessageAttributes _obj = (SfcMessageAttributes) o;
			return ((endUserMessage == _obj.endUserMessage) && (operatorMessage == _obj.operatorMessage));
		} else {
			return false;
		}

	}
}
