package hk.sfc.base.constant;


/**
 * Base Constants.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>19/03/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR15816</TD><TD>19/03/2009</TD><TD>Suyee Li</TD><TD>Add DECRYPT_LOCALE_URL</TD></TR>
 * <TR><TD>ASR15816</TD><TD>24/12/2009</TD><TD>Richard Shiu</TD><TD>Change Chinese label</TD></TR>
 * </TABLE>
 *
 */
public final class BaseConstant
{
	
	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
    private BaseConstant()
    {
    }
     
    // Encrypt Url parameter
    public static final String ENCRYPT_URL_PARAM="data";
    public static final String DECRYPT_LOCALE_URL="localeUrl";
    public static final String AJAX_URL_PARAM="_dc";
    public static final String SWF_URL_PARAM = "flowExecutionUrl";
    
    // LDAP Parameter used and values
    public static final String LDAP_LOCKED = "lockedByIntruder";
    public static final String LDAP_LOCKED_ATTEMPTS = "loginIntruderAttempts";
    public static final String LDAP_PASSWORD = "userPassword"; 
    public static final String LDAP_TRUE = "TRUE";   
    public static final String LDAP_FALSE = "FALSE";  
    public static final String LDAP_DISABLE = "loginDisabled";
    public static final String LDAP_PASSWORD_EXPIRED_TIME = "passwordExpirationTime";
    public static final String LDAP_LAST_LOGIN_TIME = "LastLoginTime";
    public static final String LDAP_OBJECT_CLASS = "objectclass";
    public static final String LDAP_ORG_PERSON = "inetOrgPerson";
    public static final String LDAP_CN = "cn";   
    public static final String LDAP_SN = "sn";  
    public static final String LDAP_UID = "uid";   
    public static final String LDAP_GIVEN_NAME = "givenName"; 
    public static final String LDAP_LOGIN_GRACE_REMAINING = "loginGraceRemaining"; 
    //LDAP Custom Attribute
    public static final String LDAP_OLD_USER_ID = "precedingID";
    public static final String LDAP_ID_USER = "iduser"; 
    public static final String LDAP_PASSWORD_LAST_REMINDER_TIME = "LastReminderTime";
    public static final String LDAP_AUDIT_STATUS = "P";
    public static final String LDAP_AUDIT_FAILURE_STATUS = "F";

    //LDAP Group
    public static final String LDAP_GROUP_MEMBERSHIP = "groupMembership";   
    public static final String LDAP_SECURITY_EQUALS = "securityEquals";   
    public static final String LDAP_UNIQUE_MEMBER = "uniqueMember";   
    public static final String LDAP_EQ_TO_ME = "equivalentToMe";   
    //LDAP Exception
    public static final String LDAP_LOCKED_EXCEPTION ="javax.naming.OperationNotSupportedException: [LDAP: error code 53 - NDS error: login lockout (-197)]";
    public static final String LDAP_DISABLE_EXCEPTION ="javax.naming.OperationNotSupportedException: [LDAP: error code 53 - NDS error: log account expired (-220)]";
    public static final String LDAP_FIRST_LOGIN_EXCEPTION="javax.naming.AuthenticationException: [LDAP: error code 49 - NDS error: bad password (-222)]";
    public static final String LDAP_LOGIN_PASSWORD_WRONG_EXCEPTION="javax.naming.AuthenticationException: [LDAP: error code 49 - NDS error: failed authentication (-669)]";
    public static final String LDAP_PASSWORD_HISTORY_EXCEPTION="NDS error: duplicate password or Q in service (-215)";
    public static final String LDAP_PASSWORD_TOO_SHORT="NDS error: password too short or Q not active (-216)";
    public static final String LDAP_PASSWORD_TOO_LONG="NDS error: no additional information available (-16000)";
    public static final String LDAP_PASSWORD_MISSING_SPECIAL_CHARACTER="NDS error: no additional information available (-16013)";
    public static final String LDAP_PASSWORD_MISSING_CAPITAL="NDS error: no additional information available (-16001)";
    public static final String LDAP_PASSWORD_MISSING_LOWER_CASE="NDS error: no additional information available (-16003)";
    public static final String LDAP_PASSWORD_MISSING_NUMBER="NDS error: no additional information available (-16008)"; 
    public static final String LDAP_PASSWORD_SAME_CN="NDS error: no additional information available (-16020)";
    public static final String LDAP_CONNECTION_ERROR="Connect Error";
    // LICPORTAL Application Mode
    public static final String APPLN_MODE_B = "B"; // LICPORTAL is offline , EOD is running
    public static final String APPLN_MODE_O = "O"; // LICPORTAL is online  , EOD is not running
    
    //LP_T_EMAIL_SPOOL status
    public static final String EMAIL_STATUS_SENT = "S"; // SENT EMAIL
    public static final String EMAIL_STATUS_SENT_FAIL = "F"; // NEW EMAIL
    public static final String EMAIL_STATUS_NEW = "N"; // NEW EMAIL
    
    public static final String LANG_EN = "en";
    public static final String LANG_ZH = "zh";
    
    // Jasper Report Type
    // A is AnnualReturn whereas N is notification
    public static final String ANNUAL_JASPER_TEMPLATE = "A";
    public static final String NOTIFICATION_JASPER_TEMPLATE = "N";
    
    // General variable for YES and NO.
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String NOT_APPLICABLE = "X";

    // General variable for <All> label
    public static final String ALL_LABEL = "All";
        
    // Payment
    public static final String PAYMENT_URL = "url";
    
	public static final String SYSTEM_INFO_BEAN_NAME = "systemInfo";
	public static final String AUDIT_LOG_SVC_BEAN_NAME = "auditLogSvc";
}