package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Regulated activity for accredited principal.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>11/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 */
public class AccreditedPrincipalAccRa extends SfcDomainObject {

	private static final long serialVersionUID = -8983354424463222599L;

	/** Cease accreditation. */
	public static final String ROLE_CEASE_ACCREDITATION = "XX";

	/** Type of regulated activity. */
	private Integer actType;

	/**
	 * New role for the accredited activity.
	 * RO: responsible officer
	 * RE: licensed representative
	 * EO: executive officer
	 * XX: accreditation ceased
	 */
	private String lcRole;

	/**
	 * Original role for the accredited activity.
	 * RO: responsible officer
	 * RE: licensed representative
	 * EO: executive officer
	 */
	private String originalLcRole;

	/** Effective date of notification section. */
	private Date effectiveDate;

	/** Effective date of accredited activity. */
	private Date activityEffectiveDate;

	/** Principal of the accredited activity. */
	private AccreditedPrincipal principal;

	/**
	 * setter method of actType
	 * @param actType
	 */
	public void setActType(Integer actType) {
		this.actType = actType;
	}

	/**
	 * getter method of actType
	 * @return Integer
	 */
	public Integer getActType() {
		return actType;
	}

	/**
	 * setter method of lcRole
	 * @param lcRole
	 */
	public void setLcRole(String lcRole) {
		this.lcRole = lcRole;
	}

	/**
	 * getter method of lcRole
	 * @return String
	 */
	public String getLcRole() {
		return lcRole;
	}

	/**
	 * setter method of effectiveDate
	 * @param effectiveDate
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * getter method of effectiveDate
	 * @return Date
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * setter method of activityEffectiveDate
	 * @param activityEffectiveDate
	 */
	public void setActivityEffectiveDate(Date activityEffectiveDate) {
		this.activityEffectiveDate = activityEffectiveDate;
	}

	/**
	 * getter method of activityEffectiveDate
	 * @return Date
	 */
	public Date getActivityEffectiveDate() {
		return activityEffectiveDate;
	}

	/**
	 * setter method of originalLcRole
	 * @param originalLcRole
	 */
	public void setOriginalLcRole(String originalLcRole) {
		this.originalLcRole = originalLcRole;
	}

	/**
	 * getter method of originalLcRole
	 * @return String
	 */
	public String getOriginalLcRole() {
		return originalLcRole;
	}

	/**
	 * setter method of principal
	 * @param principal
	 */
	public void setPrincipal(AccreditedPrincipal principal) {
		this.principal = principal;
	}

	/**
	 * getter method of principal
	 * @return AccreditedPrincipal
	 */
	public AccreditedPrincipal getPrincipal() {
		return principal;
	}
}