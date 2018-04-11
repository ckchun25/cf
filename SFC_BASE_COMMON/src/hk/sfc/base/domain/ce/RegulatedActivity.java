package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Regulated activity of a licensed entity.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>14/04/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>01/12/2009</TD><TD>Edmund Fong</TD><TD>Change to indicate in profile page if the LC/RO is a sponsor</TD></TR>
 * </TABLE>
 *
 */
public class RegulatedActivity extends SfcDomainObject {

	private static final long serialVersionUID = -6199490674378346284L;

	/** Running sequence number. */
	private Integer seqNo;

	/** Regulated activity type. */
	private Integer actType;

	/** applicatino date */
	private Date applDate;
	
	/** application result date */
	private Date applResultDate;
	
	/** application result user */
	private String applResultUser;
	
	/** smf ind */
	private String smfInd;
	
	/** Status. */
	private String status;

	/** primary business code */
	private String primBuscode;
	
	/** effective date */
	private Date effDate;
	
	/** end date */
	private Date endDate;
	
	/** commence date */
	private Date commenceDate;
	
	/** activity type */
	private ActivityType activityType;

	/** sponsor */
	private Boolean sponsor;
	

	/**
	 * @return the seqNo
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	
	/**
	 * @return the actType
	 */
	public Integer getActType() {
		return actType;
	}

	
	/**
	 * @param actType the actType to set
	 */
	public void setActType(Integer actType) {
		this.actType = actType;
	}

	
	/**
	 * @return the applDate
	 */
	public Date getApplDate() {
		return applDate;
	}

	
	/**
	 * @param applDate the applDate to set
	 */
	public void setApplDate(Date applDate) {
		this.applDate = applDate;
	}

	
	/**
	 * @return the applResultDate
	 */
	public Date getApplResultDate() {
		return applResultDate;
	}

	
	/**
	 * @param applResultDate the applResultDate to set
	 */
	public void setApplResultDate(Date applResultDate) {
		this.applResultDate = applResultDate;
	}

	
	/**
	 * @return the applResultUser
	 */
	public String getApplResultUser() {
		return applResultUser;
	}

	
	/**
	 * @param applResultUser the applResultUser to set
	 */
	public void setApplResultUser(String applResultUser) {
		this.applResultUser = applResultUser;
	}

	
	/**
	 * @return the smfInd
	 */
	public String getSmfInd() {
		return smfInd;
	}

	
	/**
	 * @param smfInd the smfInd to set
	 */
	public void setSmfInd(String smfInd) {
		this.smfInd = smfInd;
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
	 * @return the primBuscode
	 */
	public String getPrimBuscode() {
		return primBuscode;
	}

	
	/**
	 * @param primBuscode the primBuscode to set
	 */
	public void setPrimBuscode(String primBuscode) {
		this.primBuscode = primBuscode;
	}

	
	/**
	 * @return the effDate
	 */
	public Date getEffDate() {
		return effDate;
	}

	
	/**
	 * @param effDate the effDate to set
	 */
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	/**
	 * @return the commenceDate
	 */
	public Date getCommenceDate() {
		return commenceDate;
	}

	
	/**
	 * @param commenceDate the commenceDate to set
	 */
	public void setCommenceDate(Date commenceDate) {
		this.commenceDate = commenceDate;
	}

	
	/**
	 * @return the activityType
	 */
	public ActivityType getActivityType() {
		return activityType;
	}

	
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}


	/**
	 * @return the sponsor
	 */
	public Boolean getSponsor() {
		return sponsor;
	}


	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(Boolean sponsor) {
		this.sponsor = sponsor;
	}

	
}