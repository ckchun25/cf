package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Regulated activity type.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>21/04/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ActivityType extends SfcDomainObject {

	private static final long serialVersionUID = -9084777710907113298L;

	/** Activity type ID. */
	private Integer actType;
	
	/** English description. */
	private String actDesc;
	
	/** Chinese description. */
	private String cactDesc;
	
	/**
	 * Active flag.
	 * Y: active
	 * N: inactive
	 */
	private String activeFlag;

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
	 * setter method of actDesc
	 * @param actDesc
	 */
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}

	/**
	 * getter method of actDesc
	 * @return String
	 */
	public String getActDesc() {
		return actDesc;
	}

	/**
	 * setter method of cactDesc
	 * @param cactDesc
	 */
	public void setCactDesc(String cactDesc) {
		this.cactDesc = cactDesc;
	}

	/**
	 * getter method of cactDesc
	 * @return String
	 */
	public String getCactDesc() {
		return cactDesc;
	}

	/**
	 * setter method of activeFlag
	 * @param activeFlag
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * getter method of activeFlag
	 * @return String
	 */
	public String getActiveFlag() {
		return activeFlag;
	}
}
