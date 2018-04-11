package hk.sfc.base.svc.message;

/**
 *  A representation of system error message.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcSystemErrorMessage extends SfcErrorMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2529557544237020827L;

	/**
	 * Create a instance with error type default to System Error and message Level to CRITICAL. 
	 * Besides, MessageAttributes is send operator only.
	 * The message number will be added up from the base number SfcErrorMessage.SYSTEM_ERROR.
	 * 
	 * @param msgNo
	 */
	public SfcSystemErrorMessage(int msgNo) {
		this(msgNo, SfcMessage.CRITICAL, SfcErrorMessage.SYSTEM_ERROR);
	}
	
	/**
	 * Create a instance with error type default to System Error and message Level to CRITICAL. 
	 * Besides, MessageAttributes is send operator only.
	 * The message number will be added up from the base number SfcErrorMessage.SYSTEM_ERROR.
	 * 
	 * @param msgNo
	 * @param msgLevel
	 */
	public SfcSystemErrorMessage(int msgNo, int msgLevel) {
		this(msgNo, msgLevel, SfcErrorMessage.SYSTEM_ERROR);
	}
	
	/**
	 * Create a instance with error type default to System Error and message Level to CRITICAL. 
	 * Besides, MessageAttributes is send operator only.
	 * The message number will be added up from the base number SfcErrorMessage.SYSTEM_ERROR.
	 * 
	 * @param msgNo
	 * @param msgLevel
	 * @param errType
	 */
	public SfcSystemErrorMessage(int msgNo, int msgLevel, int errType) {
		super(SfcErrorMessage.SYS_ERR_BASE + msgNo, msgLevel, SfcMessageAttributes.SEND_OPER_ONLY, null, errType);
	}

	// System Error definition start from here
	// Start from [8001]
	/** Database connection error message. */
	public static final SfcSystemErrorMessage DB_CONN_ERR = new SfcSystemErrorMessage(1);
	/** LDAP Server error. */
	public static final SfcSystemErrorMessage LDAP_SVR_ERR = new SfcSystemErrorMessage(2);
	/**LDAP Connection is not alive error message*/
	public static final SfcSystemErrorMessage LDAP_CONNECT_ERR = new SfcSystemErrorMessage(3);
	
}
