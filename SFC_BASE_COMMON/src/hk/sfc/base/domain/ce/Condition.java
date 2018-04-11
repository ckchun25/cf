package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Condition domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 */
public class Condition extends SfcDomainObject {

	private static final long serialVersionUID = -3155591124902284210L;

	/** sequence no. */
	private int seqNo;

	/** source type */
	private String sourceType;

	/** ra sequence no. */
	private int raSeqNo;

	/** cnd Code */
	private String cndCode;

	/** detail */
	private String detail;

	/** cdetail */
	private String cdetail;

	/** effective Date */
	private Date effDate;

	/** end Date */
	private Date endDate;

	/** regulated Activity */
	private RegulatedActivity regulatedActivity;

	/**
	 * @return the seqNo
	 */
	public int getSeqNo() {
		return seqNo;
	}

	
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	
	/**
	 * @return the sourceType
	 */
	public String getSourceType() {
		return sourceType;
	}

	
	/**
	 * @param sourceType the sourceType to set
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	
	/**
	 * @return the raSeqNo
	 */
	public int getRaSeqNo() {
		return raSeqNo;
	}

	
	/**
	 * @param raSeqNo the raSeqNo to set
	 */
	public void setRaSeqNo(int raSeqNo) {
		this.raSeqNo = raSeqNo;
	}

	
	/**
	 * @return the cndCode
	 */
	public String getCndCode() {
		return cndCode;
	}

	
	/**
	 * @param cndCode the cndCode to set
	 */
	public void setCndCode(String cndCode) {
		this.cndCode = cndCode;
	}

	
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	/**
	 * @return the cdetail
	 */
	public String getCdetail() {
		return cdetail;
	}

	
	/**
	 * @param cdetail the cdetail to set
	 */
	public void setCdetail(String cdetail) {
		this.cdetail = cdetail;
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
	 * @return the regulatedActivity
	 */
	public RegulatedActivity getRegulatedActivity() {
		return regulatedActivity;
	}

	
	/**
	 * @param regulatedActivity the regulatedActivity to set
	 */
	public void setRegulatedActivity(RegulatedActivity regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}

}