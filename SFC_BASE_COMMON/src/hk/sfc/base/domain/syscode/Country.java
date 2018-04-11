package hk.sfc.base.domain.syscode;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Country domain object.
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

public class Country extends SfcDomainObject {

	private static final long serialVersionUID = -6346317986220411560L;

	/** Country code of Hong Kong. */
	public static final String HONG_KONG = "HK";

	/** Country code of unspecified country. */
	public static final String OTHER_COUNTRY = "OT";

	/** Country Code. */
	private String countryCode;

	/** Country name. */
	private String countryName;

	/** Country name (Chinese). */
	private String countryNameChin;

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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryNameChin
	 */
	public String getCountryNameChin() {
		return countryNameChin;
	}

	/**
	 * @param countryNameChin the countryNameChin to set
	 */
	public void setCountryNameChin(String countryNameChin) {
		this.countryNameChin = countryNameChin;
	}

}