package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Bank domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>03/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class Bank extends SfcDomainObject {

	private static final long serialVersionUID = -7306210029964824770L;
	
	/** Bank code for "other banks. */
	public static final String OTHER_BANK_CODE = "OTH";

	/** Bank code. */
	private String bankCode;

	/** Bank name. */
	private String bankName;

	/** Bank short name. */
	private String bankShortName;

	
	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	
	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	/**
	 * @return the bankShortName
	 */
	public String getBankShortName() {
		return bankShortName;
	}

	
	/**
	 * @param bankShortName the bankShortName to set
	 */
	public void setBankShortName(String bankShortName) {
		this.bankShortName = bankShortName;
	}

}