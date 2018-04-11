package hk.sfc.base.svc.message;

/**
 *  A representation of internal error message.
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>16/02/2009</TD><TD>tchan1 (ICO Limited)</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcInternalErrorMessage extends SfcErrorMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4167578981639414092L;
	
	/**
	 * Create a instance with error type default to Internal Error and message Level to WARNING. 
	 * Besides, MessageAttributes is send none.
	 * The message number will be added up from the base number SfcErrorMessage.INT_ERR_BASE.
	 * 
	 * @param msgNo
	 */
	public SfcInternalErrorMessage(int msgNo) {
		this (msgNo, SfcMessage.WARNING, SfcErrorMessage.INTERNAL_ERROR);
	}

	/**
	 * Create a instance with error type default to Internal Error and message Level to WARNING. 
	 * Besides, MessageAttributes is send none.
	 * The message number will be added up from the base number SfcErrorMessage.INT_ERR_BASE.
	 * 
	 * @param msgNo
	 * @param msgLevel
	 */
	public SfcInternalErrorMessage(int msgNo, int msgLevel) {
		this(msgNo, msgLevel, SfcErrorMessage.INTERNAL_ERROR);
	}
	
	/**
	 * Create a instance with error type default to Internal Error and message Level to WARNING. 
	 * Besides, MessageAttributes is send none.
	 * The message number will be added up from the base number SfcErrorMessage.INT_ERR_BASE.
	 * 
	 * @param msgNo
	 * @param msgLevel
	 * @param errType
	 */
	private SfcInternalErrorMessage(int msgNo, int msgLevel, int errType) {
		super(SfcErrorMessage.INT_ERR_BASE + msgNo, msgLevel, SfcMessageAttributes.SEND_NONE, null, errType);
	}
	
	
	// Internal Error definition start from here
	// Start from [9001]
	/** Invalid parameter is used in the method */
	public static final SfcInternalErrorMessage INVALID_PARAM = new SfcInternalErrorMessage(1);
	/** The class is not the one expected */
	public static final SfcInternalErrorMessage INVALID_CLASS = new SfcInternalErrorMessage(2);
	/** Generic internal error message */
	public static final SfcInternalErrorMessage MSG_ERR = new SfcInternalErrorMessage(3);
	/** Generic exception message */ 
	public static final SfcInternalErrorMessage EXCEPTION = new SfcInternalErrorMessage(4);
	/** The object is not the one expected */
	public static final SfcInternalErrorMessage INVALID_TYPE = new SfcInternalErrorMessage(5);
	/** Unsupported encoding */
	public static final SfcInternalErrorMessage UNSUPPORTED_ENCODING = new SfcInternalErrorMessage(6);
	/** A error message that represents the code should not reach to there. */
	public static final SfcInternalErrorMessage	SHOULD_NOT_REACH = new SfcInternalErrorMessage(7);
	/** A error message that represents lookup object failure */
	public static final SfcInternalErrorMessage LOOKUP_OBJECT_FAILURE = new SfcInternalErrorMessage(8);
	/** A error message that represents security checking failure */
	public static final SfcInternalErrorMessage SECURITY_CHECK_FAILURE = new SfcInternalErrorMessage(9);
	/** A error message that represents Jasper Report */
	public static final SfcInternalErrorMessage JASPER_REPORT_FAILURE = new SfcInternalErrorMessage(10);
	/** A error message that represents invalid configuration is found */
	public static final SfcInternalErrorMessage	INVALID_CONFIG = new SfcInternalErrorMessage(11);
	/** A error message that represents the transaction cannot set to rollback only */
	public static final SfcInternalErrorMessage CANNOT_SET_TRANSACTION_ROLLBACK = new SfcInternalErrorMessage(12);

}
