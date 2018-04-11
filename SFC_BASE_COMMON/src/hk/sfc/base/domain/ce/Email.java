package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Email domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class Email extends SfcDomainObject {

	private static final long serialVersionUID = -4555000557648526988L;

	/** Business email type. */
	public static final String BUSINESS_TYPE = "PLBUS";

	/** Personal email type. */
	public static final String PERSONAL_TYPE = "PLIND";
	
	/** Business email description. */
	public static final String BUSINESS_DESC = "(Office) ";

	/** Personal email description. */
	public static final String PERSONAL_DESC = "(Personal) ";	

	/** Email. */
	private String email;

	/** Email address type. */
	private String emailAddrType;

	/** Email description. */
	private String emailDesc;

	/** Effective date. */
	private Date effectiveDate;

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return the emailAddrType
	 */
	public String getEmailAddrType() {
		return emailAddrType;
	}

	
	/**
	 * @param emailAddrType the emailAddrType to set
	 */
	public void setEmailAddrType(String emailAddrType) {
		this.emailAddrType = emailAddrType;
	}

	
	/**
	 * @return the emailDesc
	 */
	public String getEmailDesc() {
		return emailDesc;
	}

	
	/**
	 * @param emailDesc the emailDesc to set
	 */
	public void setEmailDesc(String emailDesc) {
		this.emailDesc = emailDesc;
	}

	
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}