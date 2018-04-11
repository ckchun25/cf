package hk.sfc.base.svc.message;

/**
 *  A representation of application error message.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR15816</TD><TD>28/01/2010</TD><TD>Cris Wong</TD><TD>Added P2A error messages</TD></TR>
 * <TR><TD>ASR15816</TD><TD>16/03/2010</TD><TD>Froster Lau</TD><TD>Added P2A error messages</TD></TR>
 * <TR><TD>ASR16468</TD><TD>01/04/2010</TD><TD>Froster Lau</TD><TD>P2A R2 Enhancement</TD></TR>
 * <TR><TD>ASR16449</TD><TD>20/07/2010</TD><TD>Richard Shiu</TD><TD>Virus scan integration</TD></TR>
 * <TR><TD>ASR16449</TD><TD>23/07/2010</TD><TD>Richard Shiu</TD><TD>Document generation integration</TD></TR>
 * <TR><TD>ASR16449</TD><TD>03/08/2010</TD><TD>Richard Shiu</TD><TD>Add database concurrent update error.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>28/09/2010</TD><TD>Richard Shiu</TD><TD>Add DMS web services error.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>04/10/2010</TD><TD>Froster Lau</TD><TD>P2B - new error message for form submission validation</TD></TR>
 * <TR><TD>ASR16449</TD><TD>25/10/2010</TD><TD>Richard Shiu</TD><TD>Add print web services error.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>12/11/2010</TD><TD>Richard Shiu</TD><TD>Add DMS web service offline message.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>15/11/2010</TD><TD>Froster Lau</TD><TD>P2B - new error message for form key attachment validation</TD></TR>
 * <TR><TD>ASR16449</TD><TD>28/12/2010</TD><TD>Tony Leung</TD><TD>P2B - new error message for proposed RAs validation and not enough sponsor principal</TD></TR>
 * <TR><TD>ASR16449</TD><TD>21/01/2011</TD><TD>Tony Leung</TD><TD>[SIT #1738]P2B - new error message for not enough representative of RI</TD></TR>
 * <TR><TD>ASR16449</TD><TD>17/02/2011</TD><TD>Tony Leung</TD><TD>[SIT #2298]P2B - new error message for not enough ae executive officer</TD></TR>
 * </TABLE>
 */
public class SfcAppErrorMessage extends SfcErrorMessage {

	private static final long serialVersionUID = -4233478379572909852L;

	private static final int COMMON_BASE = -1000;

	/**
	 * Create a instance with error type default to Application Error and message Level to ERROR. 
	 * Besides, MessageAttributes is send end user only.
	 * The message number will be added up from the base number LicErrorMessage.APP_ERR_BASE.
	 * @param msgNo
	 */
	public SfcAppErrorMessage(int msgNo) {
		this(msgNo, SfcMessage.ERROR, SfcErrorMessage.APP_ERROR);
	}

	/**
	 * Create a instance with error type default to Application Error and message Level to ERROR. 
	 * Besides, MessageAttributes is send end user only.
	 * The message number will be added up from the base number SfcErrorMessage.APP_ERR_BASE.
	 * @param msgNo
	 * @param msgLevel message level for this instance. Refer to the message level defined in SfcMessage.
	 */
	public SfcAppErrorMessage(int msgNo, int msgLevel) {
		this(msgNo, msgLevel, SfcErrorMessage.APP_ERROR);
	}

	/**
	 * Create a instance with error type default to Application Error and message Level to ERROR. 
	 * Besides, MessageAttributes is send end user only. 
	 * The message number will be added up from the base number SfcErrorMessage.APP_ERR_BASE.
	 * @param msgNo
	 * @param msgLevel
	 * @param errType
	 */
	private SfcAppErrorMessage(int msgNo, int msgLevel, int errType) {
		super(SfcErrorMessage.APP_ERR_BASE + msgNo, msgLevel,
				SfcMessageAttributes.SEND_ENDUSR_ONLY, null, errType);
	}

	// Application Error definition start from here
	// Start from [1001]
	/** Unauthorized access message */
	public static final SfcAppErrorMessage UNAUTHORIZED_ACCESS =
			new SfcAppErrorMessage(COMMON_BASE + 1);
	/** LDAP password policy exception message */
	public static final SfcAppErrorMessage LDAP_PASSWORD_POLICY_EXCEPTION =
			new SfcAppErrorMessage(COMMON_BASE + 2);
	/** Entity authorization failure message */
	public static final SfcAppErrorMessage ENTITY_AUTHORIZATION_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 4);
	/** Group entity authorization failure message */
	public static final SfcAppErrorMessage GROUP_ENTITY_AUTHORIZATION_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 5);
	/** Database update failure message */
	public static final SfcAppErrorMessage DATABASE_UPDATE_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 6);
	/** Section authorization failure message */
	public static final SfcAppErrorMessage SECTION_AUTHORIZATION_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 7);
	/** Authentication failure message */
	public static final SfcAppErrorMessage AUTHENTICATION_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 8);
	/** Delegation entity authorization failure message */
	public static final SfcAppErrorMessage DELG_ENTITY_AUTHORIZATION_FAILURE =
			new SfcAppErrorMessage(COMMON_BASE + 9);
	/** CBS failure message */
	public static final SfcAppErrorMessage CBS_PROCEDURE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 10);
	/** CBS cancel invoice failure message */
	public static final SfcAppErrorMessage CBS_CANCEL_INVOICE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 11);
	/** CBS Generic Error */
	public static final SfcAppErrorMessage CBS_GENERIC_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 12);
	/** CBS Generic Error for portal */
	public static final SfcAppErrorMessage CBS_GENERIC_ERROR_PORTAL =
			new SfcAppErrorMessage(COMMON_BASE + 13);
	/** CBS Generic Error for portal */
	public static final SfcAppErrorMessage UPDATE_PAYMENT_METHOD_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 14);
	/** Virus scan size limit error. */
	public static final SfcAppErrorMessage VIRUS_SCAN_SIZE_LIMIT_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 15);
	/** Virus scan encrypted zip file error. */
	public static final SfcAppErrorMessage VIRUS_SCAN_ENCRYPTED_CONTAINER_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 16);
	/** Virus scan init internal error. */
	public static final SfcAppErrorMessage VIRUS_SCAN_INIT_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 17);
	/** Virus scan scan internal error. */
	public static final SfcAppErrorMessage VIRUS_SCAN_SCAN_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 18);
	/** Document generation task service error. */
	public static final SfcAppErrorMessage DOC_GENERATION_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 19);
	/** DMS staging task service error. */
	public static final SfcAppErrorMessage DMS_STAGING_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 20);
	/** Email distribution task service error. */
	public static final SfcAppErrorMessage EMAIL_DISTRIBUTION_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 21);
	/** DMS import task service error. */
	public static final SfcAppErrorMessage DMS_IMPORT_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 22);
	/** Print queue task service error. */
	public static final SfcAppErrorMessage PRINT_QUEUE_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 23);
	/** DMS storage task service error. */
	public static final SfcAppErrorMessage DMS_STORAGE_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 24);
	/** Database concurrent update error. */
	public static final SfcAppErrorMessage DB_CONCURRENT_UPDATE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 25);
	/** Not Authorized to Access specified function **/
	public static final SfcAppErrorMessage NOT_AUTHORIZED_FUNCTION =
			new SfcAppErrorMessage(COMMON_BASE + 26);
	/** DMS import task service error. */
	public static final SfcAppErrorMessage DMS_WS_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 27);

	/** When the application form is not completely filled */
	public static final SfcAppErrorMessage FORM_NOT_COMPLETE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 28);

	/** When the corresponding supplementary form is not valid */
	public static final SfcAppErrorMessage INVALID_SUPPLEMENTARY_FORM_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 29);

	/** When there is not enough representative */
	public static final SfcAppErrorMessage NOT_ENOUGH_REPRESENTATIVE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 30);

	/** When there is no signing director */
	public static final SfcAppErrorMessage NO_SIGNING_DIRECTOR_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 31);

	/** Error for print web services. */
	public static final SfcAppErrorMessage PRINT_WS_INTERNAL_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 32);
	/** Error for print web services. */

	public static final SfcAppErrorMessage DMS_WS_OFFLINE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 33);
	
	/** When the form key is not found */
	public static final SfcAppErrorMessage FORM_KEY_INVALID_FORM_KEY =
		new SfcAppErrorMessage(COMMON_BASE + 34);
	
	/** When the form key is already being used */
	public static final SfcAppErrorMessage FORM_KEY_ALREADY_USED =
		new SfcAppErrorMessage(COMMON_BASE + 35);
	
	/** When the passcode is incorrect */
	public static final SfcAppErrorMessage FORM_KEY_INVALID_PASSCODE =
		new SfcAppErrorMessage(COMMON_BASE + 36);
	
	/** When the supplement form is not allowed */
	public static final SfcAppErrorMessage FORM_KEY_INVALID_SUPPLEMENT =
		new SfcAppErrorMessage(COMMON_BASE + 37);

	/** When the name of the proposed principal stored in the Supplemental Form Key matches that in the Main Application Form */
	public static final SfcAppErrorMessage FORM_KEY_INVALID_NAME =
		new SfcAppErrorMessage(COMMON_BASE + 38);

	/** When the proposed ras is not valid */
	public static final SfcAppErrorMessage PROPOSED_RAS_NOT_IN_LC_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 39);

	/** When the number of sponsor principal is not valid */
	public static final SfcAppErrorMessage NOT_ENOUGH_SPONSOR_PRINCIPAL_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 40);

	/** When the proposed ras is not valid */
	public static final SfcAppErrorMessage PROPOSED_RAS_NOT_IN_RI_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 41);
	
	/** When the number of ro executive director is not valid */
	public static final SfcAppErrorMessage NOT_ENOUGH_RO_EXECUTIVE_DIRECTOR_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 42);	
	
	/** When the number of ro executive director is not valid */
	public static final SfcAppErrorMessage NOT_ENOUGH_SUPERVISE_RO_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 43);	
	
	/** When the number of ro executive director is not valid */
	public static final SfcAppErrorMessage NOT_ENOUGH_SIGNING_INDIVIDUAL_DIRECTOR_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 44);
	
	/** When the number of principal business address */
	public static final SfcAppErrorMessage NOT_ENOUGH_PRINCIPAL_BUSINESS_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 45);	

	/** When the number of registered office address */
	public static final SfcAppErrorMessage NOT_ENOUGH_REGISTERED_OFFICE_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 46);
	
	/** When the number of correspondence address */
	public static final SfcAppErrorMessage NOT_ENOUGH_CORRESPONDENCE_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 47);
	
	/** When the number of record keeping address */
	public static final SfcAppErrorMessage NOT_ENOUGH_RECORD_KEEPING_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 48);	

	/** When the number of residential address */
	public static final SfcAppErrorMessage NOT_ENOUGH_RESIDENTIAL_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 49);
	
	/** When the number of business address */
	public static final SfcAppErrorMessage NOT_ENOUGH_BUSINESS_ADDRESS_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 50);
	
	/** When the registration information error */
	public static final SfcAppErrorMessage REGISTRATION_INFORMATION_DECLARATION_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 51);

	/** When the number of frr declaration */
	public static final SfcAppErrorMessage FRR_SIGNATORY_DECLARATION_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 52);
	
	/** When the number of primary principal */
	public static final SfcAppErrorMessage PRIMARY_PRINCIPAL_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 53);
	
	/** When the proposed date of accreditation of full lc */
	public static final SfcAppErrorMessage FLC_PROPOSED_DATE_OF_ACCREDITATION_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 54);	

	/** When the proposed date of accreditation of temp lc */
	public static final SfcAppErrorMessage TLC_PROPOSED_DATE_OF_ACCREDITATION_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 55);

	/** When the appointment date of eo */
	public static final SfcAppErrorMessage RI_APPOINTMENT_DATE_OF_EO_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 56);
	
	/** When the supplemental form mode */
	public static final SfcAppErrorMessage SUPPLEMENTAL_FORM_MODE_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 57);
	
	/** When there is not enough representative */
	public static final SfcAppErrorMessage RI_NOT_ENOUGH_REPRESENTATIVE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 58);
	
	/** When there is not enough representative */
	public static final SfcAppErrorMessage TLC_NOT_ENOUGH_REPRESENTATIVE_ERROR =
			new SfcAppErrorMessage(COMMON_BASE + 59);
	
	/** When there is not enough shareholder */
	public static final SfcAppErrorMessage NOT_ENOUGH_SHAREHOLDING_ERROR =
		new SfcAppErrorMessage(COMMON_BASE + 60);
	
	/** When RO wanted to be the shadow director */
	public static final SfcAppErrorMessage NOT_ALLOW_RO_SHADOW_DIRECTOR =
		new SfcAppErrorMessage(COMMON_BASE + 61);
	
	/** When RO wanted to be the shadow director */
	public static final SfcAppErrorMessage NOT_ENOUGH_AE_EXECUTIVE_OFFICIER =
		new SfcAppErrorMessage(COMMON_BASE + 62);
	
	/** Concurrent access db record */
	public static final SfcAppErrorMessage RECORD_CONCURRENT_ACCESS =
		new SfcAppErrorMessage(COMMON_BASE + 63);
	
}