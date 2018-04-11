package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

import java.util.Date;

/**
 *  Relation domain object.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR> 
 * <TR><TD>ASR14171</TD><TD>26/05/2009</TD>Richard shiu <TD></TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class Relation extends SfcDomainObject {

	private static final long serialVersionUID = 3253024202603843674L;

	/** Associated entity relation. */
	public static final String REL_ASSOCIATED_ENTITY = "AEB";

	/** Intermediary relation. */
	public static final String REL_INTERMEDIARY = "AEA";

	/** Director relation. */
	public static final String REL_DIRECTOR = "DIB";

	/** Auditor relation. */
	public static final String REL_AUDITOR = "AUB";

	/** Ultimate holding company relation. */
	public static final String REL_ULTIMATE_HOLDING_COMPANY = "UHB";

	/** Substantial share holder relation. */
	public static final String REL_SUBSTANTIAL_SHAREHOLDER = "SSB";

	/** Executive officer relation. */
	public static final String REL_EXECUTIVE_OFFICER = "EOB";
	
	/** Emergency contact person relation. */
	public static final String REL_EMERGENCY_CONTACT_PERSON = "ECB";

	/** Unique sequence number of relation. */
	private Long relSeqNo;

	/** lhs ceref */
	private String lhsCeref;

	/** rhs ceref */
	private String rhsCeref;

	/** Effective date of relation. */
	private Date relEffDate;

	/** Expiry date of relation. */
	private Date relEndDate;

	/** Relation code of the relation. */
	private String relCode;

	/** Entity in the LHS of the relation. */
	private CentralEntity lhsCe;

	/** Entity in the RHS of the relation. */
	private CentralEntity rhsCe;

	/** Relation Type */
	private RelationType relationType;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
	/**
	 * @return the relSeqNo
	 */
	public Long getRelSeqNo() {
		return relSeqNo;
	}

	
	/**
	 * @param relSeqNo the relSeqNo to set
	 */
	public void setRelSeqNo(Long relSeqNo) {
		this.relSeqNo = relSeqNo;
	}

	
	/**
	 * @return the lhsCeref
	 */
	public String getLhsCeref() {
		return lhsCeref;
	}

	
	/**
	 * @param lhsCeref the lhsCeref to set
	 */
	public void setLhsCeref(String lhsCeref) {
		this.lhsCeref = lhsCeref;
	}

	
	/**
	 * @return the rhsCeref
	 */
	public String getRhsCeref() {
		return rhsCeref;
	}

	
	/**
	 * @param rhsCeref the rhsCeref to set
	 */
	public void setRhsCeref(String rhsCeref) {
		this.rhsCeref = rhsCeref;
	}

	
	/**
	 * @return the relEffDate
	 */
	public Date getRelEffDate() {
		return relEffDate;
	}

	
	/**
	 * @param relEffDate the relEffDate to set
	 */
	public void setRelEffDate(Date relEffDate) {
		this.relEffDate = relEffDate;
	}

	
	/**
	 * @return the relEndDate
	 */
	public Date getRelEndDate() {
		return relEndDate;
	}

	
	/**
	 * @param relEndDate the relEndDate to set
	 */
	public void setRelEndDate(Date relEndDate) {
		this.relEndDate = relEndDate;
	}

	
	/**
	 * @return the relCode
	 */
	public String getRelCode() {
		return relCode;
	}

	
	/**
	 * @param relCode the relCode to set
	 */
	public void setRelCode(String relCode) {
		this.relCode = relCode;
	}

	
	/**
	 * @return the lhsCe
	 */
	public CentralEntity getLhsCe() {
		return lhsCe;
	}

	
	/**
	 * @param lhsCe the lhsCe to set
	 */
	public void setLhsCe(CentralEntity lhsCe) {
		this.lhsCe = lhsCe;
	}

	
	/**
	 * @return the rhsCe
	 */
	public CentralEntity getRhsCe() {
		return rhsCe;
	}

	
	/**
	 * @param rhsCe the rhsCe to set
	 */
	public void setRhsCe(CentralEntity rhsCe) {
		this.rhsCe = rhsCe;
	}

	
	/**
	 * @return the relationType
	 */
	public RelationType getRelationType() {
		return relationType;
	}

	
	/**
	 * @param relationType the relationType to set
	 */
	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}

}