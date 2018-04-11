package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Regulated activity and role
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>26/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR> 
 * <TR><TD>ASR14171</TD><TD>01/12/2009</TD><TD>Edmund Fong</TD><TD>Change to indicate in profile page if the LC/RO is a sponsor</TD></TR>
 * </TABLE>
 *
 */

public class RegulatedActivityAndRole extends SfcDomainObject {

	private static final long serialVersionUID = -463023140319340081L;

	/** Principal Entity Name */
	private String entityName;

	/** Principal center entity reference */
	private String ceref;

	/** Account type */
	private String actType;

	/** Role */
	private String lcRole;

	/** Principal Entity Other Name */
	private String entityOtherName;

	/** Principal Full Name */
	private String fullName;

	/** Principal Entity Name Chin */
	private String entityNameChin;

	/** sponsor */
	private Boolean sponsor;
	
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

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

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
	 * @return the actType
	 */
	public String getActType() {
		return actType;
	}

	/**
	 * @param actType the actType to set
	 */
	public void setActType(String actType) {
		this.actType = actType;
	}

	/**
	 * @return the lcRole
	 */
	public String getLcRole() {
		return lcRole;
	}

	/**
	 * @param lcRole the lcRole to set
	 */
	public void setLcRole(String lcRole) {
		this.lcRole = lcRole;
	}

	/**
	 * @return the entityOtherName
	 */
	public String getEntityOtherName() {
		return entityOtherName;
	}

	/**
	 * @param entityOtherName the entityOtherName to set
	 */
	public void setEntityOtherName(String entityOtherName) {
		this.entityOtherName = entityOtherName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the entityNameChin
	 */
	public String getEntityNameChin() {
		return entityNameChin;
	}

	/**
	 * @param entityNameChin the entityNameChin to set
	 */
	public void setEntityNameChin(String entityNameChin) {
		this.entityNameChin = entityNameChin;
	}

}
