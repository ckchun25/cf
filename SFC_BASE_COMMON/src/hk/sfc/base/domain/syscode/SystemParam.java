package hk.sfc.base.domain.syscode;

import hk.sfc.base.domain.SfcDomainObject;

/**
 *  System Parameter domain object.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR15816</TD><TD>07/12/2009</TD><TD>Suyee Li</TD><TD>Add Payment TYPE and CODE</TD></TR>
 * <TR><TD>ASR15816</TD><TD>08/12/2009</TD><TD>Suyee Li</TD><TD>Add code OUT_INVOICE_REMINDER</TD></TR>
 * <TR><TD>ASR16468</TD><TD>13/05/2010</TD><TD>Tony Chan</TD><TD>Add new parameter type for PPS NF grace day.</TD></TR>
 * <TR><TD>ASR16468</TD><TD>19/05/2010</TD><TD>Anthony Wong</TD><TD>ITUAT-1137</TD></TR>
 * <TR><TD>ASR16449</TD><TD>07/07/2010</TD><TD>Froster Lau</TD><TD>for P2B</TD></TR>
 * <TR><TD>ASR16826</TD><TD>21/07/2010</TD><TD>Herbert Leung</TD><TD>Helpdesk temp ldap accounts should be excluded</TD></TR>
 * <TR><TD>ASR16449</TD><TD>28/07/2010</TD><TD>Richard Shiu</TD><TD>Add SYSTEM_CODE_LIC as system code for Licensing workflow system.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>31/08/2010</TD><TD>Froster Lau</TD><TD>For P2B - the maximum number of invalid form key input attempt</TD></TR>
 * <TR><TD>ASR16449</TD><TD>14/12/2010</TD><TD>Froster Lau</TD><TD>For P2B - add new parameter UPLOAD_QUOTA_ALERT, FORM_PATH and EDIT_FORM_URL_PARAM</TD></TR>
 * </TABLE>
 *
 */
public class SystemParam extends SfcDomainObject {

	// ####################### [TYPE_TYPE] #######################
	/*
	 * TYPE_[TYPE] constant can be generated by the following SQL.
		select distinct * from 
			(select 'public static final String TYPE_' || type ||
			' = "' || type || '";' 
			from lp_t_sys_params order by type )
	 */
	public static final String TYPE_ADMIN = "ADMIN";
	public static final String TYPE_BATCH = "BATCH";
	public static final String TYPE_COMMON = "COMMON";
	public static final String TYPE_EMAIL = "EMAIL";
	public static final String TYPE_EOD = "EOD";
	public static final String TYPE_HISTORY = "HISTORY";
	public static final String TYPE_MESSAGEBOX = "MESSAGEBOX";
	public static final String TYPE_USER = "USER";
	public static final String TYPE_NOTI = "NOTI";
	public static final String TYPE_AR = "AR";
	public static final String TYPE_LDAP = "LDAP";
	public static final String TYPE_PAYMENT = "PYMT";
	public static final String TYPE_SRA = "SRA";
	public static final String TYPE_HOUSEKEEP = "HK";
	public static final String TYPE_SECURITY = "SEC";
	public static final String TYPE_NEWFORM = "NEWFORM";


	// ####################### [TYPE]_[CODE] #######################
	/*
	 * [TYPE]_[CODE] constant can be generated by the following SQL.
		select 'public static final String ' || type 
			|| '_' || code || ' = "' || code || '";' 
		from lp_t_sys_params order by type 
	 */
	public static final String ADMIN_AR_NOTI_CONSOLID_RPT_TITLE = "AR_NOTI_CONSOLID_RPT_TITLE";
	public static final String ADMIN_AR_NOTI_EXCEPTION_RPT_TITLE = "AR_NOTI_EXCEPTION_RPT_TITLE";
	public static final String ADMIN_AR_NOTI_OUTSTAND_RPT_TITLE = "AR_NOTI_OUTSTAND_RPT_TITLE";
	public static final String AR_SUBMISSION_DETAIL_URL = "SUBMISSION_DETAIL_URL";
	public static final String AR_SUBMISSION_DETAIL_URL_ADMIN = "SUBMISSION_DETAIL_URL_ADMIN";
	public static final String AR_SUBMISSION_URL_PARAM = "SUBMISSION_URL_PARAM";
	public static final String BATCH_CUT_OFF_TIME = "CUT_OFF_TIME";
	public static final String COMMON_AR_PATH = "AR_PATH";
	public static final String EMAIL_EXTERNAL_EMAIL_FROM = "EXTERNAL_EMAIL_FROM";
	public static final String EMAIL_INTERNAL_EMAIL_BCC = "INTERNAL_EMAIL_BCC";
	public static final String EMAIL_INTERNAL_EMAIL_FROM = "INTERNAL_EMAIL_FROM";
	public static final String EOD_URL = "URL";
	public static final String EOD_USER = "USER";
	public static final String HISTORY_HISTPERIOD = "HISTPERIOD";
	public static final String HISTORY_MAXREC = "MAXREC";
	public static final String HISTORY_PAGEREC = "PAGEREC";
	public static final String LDAP_KEEP_DAYS = "KEEP_DAYS";
	public static final String MESSAGEBOX_DEFAULT_SENDER = "DEFAULT_SENDER";
	public static final String MESSAGEBOX_PAYMENT_SENDER = "PAYMENT_SENDER";
	public static final String MESSAGEBOX_MAXREC = "MAXREC";
	public static final String MESSAGEBOX_MSG_BOX_PATH = "MSG_BOX_PATH";
	public static final String MESSAGEBOX_PAGEREC = "PAGEREC";
	public static final String NOTI_SUBMISSION_DETAIL_URL = "SUBMISSION_DETAIL_URL";
	public static final String NOTI_SUBMISSION_DETAIL_URL_ADMIN = "SUBMISSION_DETAIL_URL_ADMIN";
	public static final String NOTI_SUBMISSION_URL_PARAM = "SUBMISSION_URL_PARAM";
	public static final String USER_DELE_EXPIRY_DAYS = "DELE_EXPIRY_DAYS";
	public static final String USER_MAX_DELEGATIONS = "MAX_DELEGATIONS";
	public static final String ENABLE_REG_USER_DATE = "ENABLE_REG_USER_DATE";
	public static final String LDAP_DEACTIVATE_DAYS = "DEACTIVATE_DAYS";
	public static final String PK_INV_EXP = "PK_INV_EXP";
	public static final String PAYMENT_PATH = "PYMT_PATH";
	public static final String OUT_INVOICE_REMINDER = "OUT_INVOICE_REMINDER";
	public static final String INVITATION_APPROVAL_URL_PARAM = "INVITATION_APPROVAL_URL_PARAM";
	public static final String PAYMENT_PAGEREC = "PAGEREC";
	public static final String PAYMENT_BASKET_URL_PARAM = "PAYMENT_BASKET_URL_PARAM";
	// P2B - Add parameter used to access application basket - Start 
	public static final String APP_PAYMENT_BASKET_URL_PARAM = "APP_PAYMENT_BASKET_URL_PARAM";
	// P2B - Add parameter used to access application basket - End
	public static final String PAYMENT_STATUS_URL_PARAM = "PAYMENT_STATUS_URL_PARAM";
	public static final String CHARGE_STATUS_URL_PARAM = "CHARGE_STATUS_URL_PARAM";
	// Added for grace minute for PPS NF status can be updated to invoice.
	public static final String PYMT_PPSNFGRACEMINUTE = "PPSNFGRACEMINUTE";
    //Helpdesk temp account (stored in lp_t_sys_params)
    public static final String LDAP_SYS_PARM_TYPE = "LDAP"; //LDAP temp accounts used by helpdesk, seperated by ','. e.g. SFCPL001,SFCPL002
    public static final String TEMP_ACCT_CODE = "TEMP_ACCT";
	
	/** P2B **/
	public static final String SRA_URL = "SRA_URL";
	public static final String SRA_URL_PARAM = "SRA_URL_PARAM";
	public static final String SRA_EXPIRY_DAY = "SRA_EXPIRY_DAY";
	
	/** House Keeping EOD */
	public static final String ATTACHMENT_EXPIRY_DAY = "ATTACHMENT_EXPIRY_DAY";
	public static final String FORM_PENDING_ALERT_DAY = "FORM_PENDING_ALERT_DAY";
	public static final String FORM_PENDING_EXPIRY_DAY = "FORM_PENDING_EXPIRY_DAY";
	public static final String FORM_KEY_EXPIRY_DAY = "FORM_KEY_EXPIRY_DAY";
	public static final String DMS_DOC_EXPIRY_DAY = "DMS_DOC_EXPIRY_DAY";
	
	public static final String UPLOAD_FILE_LIMIT = "FILE_LIMIT";
		
	/** System code of the Licensing workflow system. */
	public static final String SYSTEM_CODE_LIC = "LIC";
	
	/** Code used to retrieve the maximum number of invalid form key input attempt **/
	public static final String MAX_ATTEMPT_FAILURE = "MAX_ATTEMPT_FAILURE";
	
	/** Email Address which will be received the upload quota exceeded alert email **/
	public static final String UPLOAD_QUOTA_ALERT = "UPLOAD_QUOTA_ALERT";
	
	/** Application Form Access Path **/
	public static final String FORM_PATH = "FORM_PATH";
	
	/** Direct Link to edit an draft form **/
	public static final String EDIT_FORM_URL_PARAM = "EDIT_FORM_URL_PARAM";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112621184382745627L;

	//* Application Code */
	private String applnCode;

	//* System Parameter type */
	private String type;

	//* System Parameter code */
	private String code;

	//* System Parameter value */
	private String value;

	//* System Parameter description */
	private String description;

	public String getApplnCode() {
		return applnCode;
	}

	public void setApplnCode(String applnCode) {
		this.applnCode = applnCode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
