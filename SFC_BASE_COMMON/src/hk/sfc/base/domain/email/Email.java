package hk.sfc.base.domain.email;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * 
 * Email POJO - lp_t_email_spools
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>08/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class Email extends SfcDomainObject {

	/**
	 *  Generated Serial Version ID
	 */
	private static final long serialVersionUID = 6080129187393009061L;

	/**
	 * Email_ID
	 */
	private Long emailID;

	/**
	 * USER_ID
	 */
	private long userID;

	/**
	 * FORM_ADDRESS
	 */
	private String fromAddress;

	/**
	 * BCC_ADDRESS
	 */
	private String bccAddress;
	
	/**
	 * TO_ADDRESS
	 */
	private String toAddress;

	/**
	 * SUBJECT
	 */
	private String subject;

	/**
	 * Status
	 */
	private String status;

	/**
	 * CLOB Content
	 */
	private String content;

	/**
	 * Email Attachment 
	 */
	private EmailAttachment emailAttachment;

	
	/**
	 * @return the emailID
	 */
	public Long getEmailID() {
		return emailID;
	}

	
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(Long emailID) {
		this.emailID = emailID;
	}

	
	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	
	/**
	 * @return the fromAddress
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	
	/**
	 * @param fromAddress the fromAddress to set
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	
	/**
	 * @return the toAddress
	 */
	public String getToAddress() {
		return toAddress;
	}

	
	/**
	 * @param toAddress the toAddress to set
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	
	/**
	 * @return the emailAttachment
	 */
	public EmailAttachment getEmailAttachment() {
		return emailAttachment;
	}

	
	/**
	 * @param emailAttachment the emailAttachment to set
	 */
	public void setEmailAttachment(EmailAttachment emailAttachment) {
		this.emailAttachment = emailAttachment;
	}


	
	/**
	 * @return the bccAddress
	 */
	public String getBccAddress() {
		return bccAddress;
	}


	
	/**
	 * @param bccAddress the bccAddress to set
	 */
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}



}