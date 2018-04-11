package hk.sfc.base.domain.syscode;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Holiday domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>05/08/2009</TD><TD>hywong1</TD><TD>check comment</TD></TR>
 * </TABLE>
 *
 */
public class Holiday extends SfcDomainObject {

	private static final long serialVersionUID = -4528792083714228846L;

	/** Holiday date. */
	private Date holidayDate;

	/** Country Code. */
	private String countryCode;

	/** Holiday Remark. */
	private String holidayRemark;

	
	/**
	 * @return the holidayDate
	 */
	public Date getHolidayDate() {
		return holidayDate;
	}

	
	/**
	 * @param holidayDate the holidayDate to set
	 */
	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	/**
	 * @return the holidayRemark
	 */
	public String getHolidayRemark() {
		return holidayRemark;
	}

	
	/**
	 * @param holidayRemark the holidayRemark to set
	 */
	public void setHolidayRemark(String holidayRemark) {
		this.holidayRemark = holidayRemark;
	}

	

}
