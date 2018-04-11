package hk.sfc.base.domain.message;

import hk.sfc.base.domain.SfcDomainObject;

/**
 *  Message Code domain object.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>28/07/2009</TD><TD>Karl Yeung</TD><TD>Add static variables for application.</TD></TR>
 * <TR><TD>ASR14171</TD><TD>06/08/2009</TD><TD>Karl Yeung</TD><TD>Add static variables for application.</TD></TR>
 * <TR><TD>ASR15816</TD><TD>24/12/2009</TD><TD>Richard Shiu</TD><TD>Charge status enquiry.</TD></TR>
 * </TABLE>
 *
 */
public class MessageCode extends SfcDomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6112621184382745627L;

	//** Message code with english locale*/
	public static final String LOCALE_EN = "en";

	//** Message code with chinese locale*/
	public static final String LOCALE_ZH = "zh";

	/** Message code's type - Annual return. */
	public static final String TYPE_AR = "AR";

	/** Message code's type - Notification. */
	public static final String TYPE_NOTI = "NOTI";

	/** Message code's type - Payment Key. */
	public static final String TYPE_PAYMENT_KEY = "PAYMENT_KEY";

	/** Message code's type - Invoice. */
	public static final String TYPE_INVOICE = "INVOICE";

	/** Message code's type - Payment Group. */
	public static final String TYPE_PAYMENT_GROUP = "PAYMENT_GROUP";
	
	/** Message code's type - Charge record. */
	public static final String TYPE_CHARGE = "TYPE_CHARGE";

	/** Message code's type - Common. */
	public static final String TYPE_COMMON = "COMMON";
	
	/** Message code's type - Payment */
	public static final String TYPE_PAYMENT = "PAYMENT";

	/** Message code - Annual return overall status. */
	public static final String AR_OVERALL_STATUS = "OVERALL_STATUS";

	/** Message code - Annual return status. */
	public static final String AR_STATUS = "STATUS";

	/** Message code - Annual return CAD status. */
	public static final String AR_CAD_STATUS = "CAD_STATUS";

	/** Message code - Annual return submit later's indicator. */
	public static final String AR_SUBMIT_LATER_IND = "SUBMIT_LATER_IND";

	/** Message code - Notification overall status. */
	public static final String NOTI_OVERALL_STATUS = "OVERALL_STATUS";

	/** Message code - Invoice Status. */
	public static final String INVOICE_STATUS = "INVOICE_STATUS";

	/** Message code - Payment Group Status. */
	public static final String PAYMENT_GROUP_STATUS = "PAYMENT_GROUP_STATUS";

	/** Message code - Group Member Status. */
	public static final String MEMBER_STATUS = "MEMBER_STATUS";
	
	/** Message code - Charge Record Status. */
	public static final String CHARGE_STATUS = "CHARGE_STATUS";

	/** Message code - Payment Key status. */
	public static final String PAYMENT_KEY_STATUS = "PAYMENT_KEY_STATUS";

	/** Message code - Notification's bank account type. */
	public static final String NOTI_BANK_ACC_TYPE = "BANK_ACC_TYPE";

	/** Message code - Notification's bank account cessation reason. */
	public static final String NOTI_CEASE_BANK_ACCOUNT_REASON = "CEASE_BANK_ACCOUNT_REASON";

	/** Message code - Notification's business cessation reason. */
	public static final String NOTI_CEASE_BUSINESS_REASON = "CEASE_BUSINESS_REASON";

	/** Message code - Notification's business cessation reason. */
	public static final String NOTI_CEASE_BUSINESS_REASON_OTHERS = "OTHERS";

	/** Message code - Notification's other directorship role. */
	public static final String NOTI_OTHER_DIRECTORSHIP_ROLE = "OTHER_DIRECTORSHIP_ROLE";

	/** Message code - Notification's other business interest role. */
	public static final String NOTI_OTHER_BUSINESS_INTEREST_ROLE = "OTHER_BUSINESS_INTEREST_ROLE";

	/** Message code - Notification's cessation accreditation reason. */
	public static final String NOTI_CEASE_ACCREDITATION_REASON = "CEASE_ACCREDITATION_REASON";

	/** Message code - Notification's cessation accreditation reason - DISMISSAL. */
	public static final String NOTI_CEASE_ACCREDITATION_REASON_DISMISSAL = "DISMISSAL";

	/** Message code - Notification's cessation accreditation reason - OTHERS. */
	public static final String NOTI_CEASE_ACCREDITATION_REASON_OTHERS = "OTHERS";

	/** Message code - Common code - Lic role. */
	public static final String COMMON_LC_LICROLE = "LC_LICROLE";

	/** Message code - Common code - Activity type. */
	public static final String COMMON_ACTIVITY_TYPE = "ACTIVITY_TYPE";

	/** Message code - Common code - capital class. */
	public static final String COMMON_CE_CLS_SHR = "CE_CLS_SHR";

	/** Message code - Common code - currency. */
	public static final String COMMON_CE_CURRENCY = "CE_CURRENCY";
	
	/** Message code - Common code - basket status */
	public static final String BASKET_STATUS = "BASKET_STATUS";
	
	/** Message code - Common code - fee type */
	public static final String FEE_TYPE = "FEE_TYPE";

	/** Message code - Common code - payment method */
	public static final String PAYMENT_METHOD = "PAYMENT_METHOD";


	/** Message code type */
	private String type;

	/** Message code code */
	private String code;

	/** Message code subcode */
	private String subcode;

	/** Message code description */
	private String description;

	/** Message code chinese description */
	private String chineseDescription;

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
	 * @return the subCode
	 */
	public String getSubcode() {
		return subcode;
	}

	/**
	 * @param subCode the subCode to set
	 */
	public void setSubcode(String subcode) {
		this.subcode = subcode;
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

	/**
	 * @return the chineseDescription
	 */
	public String getChineseDescription() {
		return chineseDescription;
	}

	/**
	 * @param chineseDescription the chineseDescription to set
	 */
	public void setChineseDescription(String chineseDescription) {
		this.chineseDescription = chineseDescription;
	}

}
