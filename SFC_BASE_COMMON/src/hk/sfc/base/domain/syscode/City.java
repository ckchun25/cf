package hk.sfc.base.domain.syscode;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * City domain object.
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

public class City extends SfcDomainObject {

	private static final long serialVersionUID = 7022792740430555599L;

	/** City code of other city. */
	public static final String OTHER_CITY = "OTH";

	/** City code. */
	private String cityCode;

	/** Country code. */
	private String countryCode;

	/** City name. */
	private String cityName;

	/** City name (chinese). */
	private String cityNameChin;

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
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
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the cityNameChin
	 */
	public String getCityNameChin() {
		return cityNameChin;
	}

	/**
	 * @param cityNameChin the cityNameChin to set
	 */
	public void setCityNameChin(String cityNameChin) {
		this.cityNameChin = cityNameChin;
	}

}