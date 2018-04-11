package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Regulated Activity Accreditations domain object.
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
public class AccRa extends SfcDomainObject {

	private static final long serialVersionUID = 5712222863750904817L;

	/** sequence no. */
	private int seqNo;

	/** ra sequence no. */
	private int raSeqNo;

	/** account sequence no. */
	private int accSeqNo;

	/** lc role */
	private String lcRole;

	/** application date */
	private Date applDate;

	/** application result date */
	private Date applResultDate;

	/** application result user */
	private String applResultUser;

	/** status */
	private String status;

	/** effective date */
	private Date effDate;

	/** end date */
	private Date endDate;

	/** accreditation */
	//private Accreditation accreditation;

	/** regulated Activity */
	private RegulatedActivity regulatedActivity;

	/**
	 * getter method of seqNo
	 * @return int
	 */
	public int getSeqNo() {
		return seqNo;
	}

	/**
	 * setter method of seqNo
	 * @param seqNo
	 */
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * getter method of raSeqNo
	 * @return int
	 */
	public int getRaSeqNo() {
		return raSeqNo;
	}

	/**
	 * setter method of raSeqNo
	 * @param raSeqNo
	 */
	public void setRaSeqNo(int raSeqNo) {
		this.raSeqNo = raSeqNo;
	}

	/**
	 * getter method of accSeqNo
	 * @return int
	 */
	public int getAccSeqNo() {
		return accSeqNo;
	}

	/**
	 * setter method of accSeqNo
	 * @param accSeqNo
	 */
	public void setAccSeqNo(int accSeqNo) {
		this.accSeqNo = accSeqNo;
	}

	/**
	 * getter method of lcRole
	 * @return String
	 */
	public String getLcRole() {
		return lcRole;
	}

	/**
	 * setter method of lcRole
	 * @param lcRole
	 */
	public void setLcRole(String lcRole) {
		this.lcRole = lcRole;
	}

	/**
	 * getter method of applDate
	 * @return Date
	 */
	public Date getApplDate() {
		return applDate;
	}

	/**
	 * setter method of applDate
	 * @param applDate
	 */
	public void setApplDate(Date applDate) {
		this.applDate = applDate;
	}

	/**
	 * getter method of applResultDate
	 * @return Date
	 */
	public Date getApplResultDate() {
		return applResultDate;
	}

	/**
	 * setter method of applResultDate
	 * @param applResultDate
	 */
	public void setApplResultDate(Date applResultDate) {
		this.applResultDate = applResultDate;
	}

	/**
	 * getter method of applResultUser
	 * @return String
	 */
	public String getApplResultUser() {
		return applResultUser;
	}
	
	/**
	 * setter method of applResultUser
	 * @param applResultUser
	 */
	public void setApplResultUser(String applResultUser) {
		this.applResultUser = applResultUser;
	}

	/**
	 * getter method of status
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * getter method of status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * getter method of effDate
	 * @return Date
	 */
	public Date getEffDate() {
		return effDate;
	}

	/**
	 * setter method of effDate
	 * @param effDate
	 */
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	/**
	 * getter method of endDate
	 * @return Date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * setter method of endDate
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * setter method of accreditation
	 * @param accreditation
	 */
//	public void setAccreditation(Accreditation accreditation) {
//		this.accreditation = accreditation;
//	}

	/**
	 * getter method of accreditation
	 * @return Accreditation
	 */
//	public Accreditation getAccreditation() {
//		return accreditation;
//	}

	/**
	 * setter method of regulatedActivity
	 * @param regulatedActivity
	 */
	public void setRegulatedActivity(RegulatedActivity regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}

	/**
	 * getter method of regulatedActivity
	 * @return RegulatedActivity
	 */
	public RegulatedActivity getRegulatedActivity() {
		return regulatedActivity;
	}
}