package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

import java.util.Date;

/**
 * RI Executive Officer domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>05/11/2009</TD><TD>Richard Shiu</TD><TD>Make it comparable by activity type.</TD></TR>
 * <TR><TD>ASR14171</TD><TD>11/12/2009</TD><TD>Edmund Fong</TD><TD>R4-UAT#204: Not indicate in Profile page if RI/EO is a sponsor</TD></TR>
 * </TABLE>
 *
 */
public class RiExecutiveOfficer extends SfcDomainObject implements Comparable {

	private static final long serialVersionUID = -6110506678623296156L;

	/** ceref */
	private String ceref;

	/** effective date */
	private Date effDate;

	/** end date */
	private Date endDate;

	/** act Type */
	private int actType;

	/** status */
	private String status;

	/** central entity */
	private CentralEntity centralEntity;

	/** sponsor */
	private Boolean sponsor;

	/**
	 * @return the ceref
	 */
	public String getCeref() {
		return ceref;
	}

	/**
	 * @param ceref the ceref to set
	 */
	public void setCeref(String ceref) {
		this.ceref = ceref;
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
	 * @return the actType
	 */
	public int getActType() {
		return actType;
	}

	/**
	 * @param actType the actType to set
	 */
	public void setActType(int actType) {
		this.actType = actType;
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
	 * @return the centralEntity
	 */
	public CentralEntity getCentralEntity() {
		return centralEntity;
	}

	/**
	 * @param centralEntity the centralEntity to set
	 */
	public void setCentralEntity(CentralEntity centralEntity) {
		this.centralEntity = centralEntity;
	}

	/* (non-Javadoc) Interface Method */
	public int compareTo(Object obj) {
		RiExecutiveOfficer _other = (RiExecutiveOfficer) obj;

		if (_other == null) {
			return -1;
		} else {
			return (actType - _other.getActType());
		}
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