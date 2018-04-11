package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Individual Detail domain object.
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
public class IndividualDetail extends SfcDomainObject {

	private static final long serialVersionUID = 7335834693970646939L;

	/** individual's gender. */
	private String indSex;

	/** individual's title. */
	private String indTitle;

	/** ind Ccc. */
	private String indCcc;

	/** individual's hkid. */
	private String hkid;

	/** individual's passportNo. */
	private String passportNo;

	/** ind Add Passport No. */
	private String indAddPassportNo;

	/** Other identification number. */
	private String otherIdInfo;

	/** ind Period Hk Resin Month. */
	private Long indPeriodHkResinMonth;

	/** individual's date of birth. */
	private Date indDob;

	/** individual's place of birth. */
	private String indPob;

	/** individual's occupation. */
	private String indOccupation;

	/** individual's Chinese occupation. */
	private String indOccupationChin;

	/** individual's educational level. */
	private String indEducLevel;

	/** source Of Info. */
	private String sourceOfInfo;

	/** limited info ind. */
	private String limitedInfoInd;

	/** individual's nationality code. */
	private String nationalityCode;

	/** individual's country code. */
	private String countryCode;

	/** country code add passport. */
	private String countryCodeAddPassport;

	/** creation Date. */
	private Date creationDate;

	/** individual's mobile number. */
	private String mobileNo;

	/** individual's pager number. */
	private String pagerNo;

	/** circular means. */
	private String circularMeans;

	/** expiry date ppt. */
	private Date expiryDatePpt;

	/** issuing agency ppt. */
	private String issuingAgencyPpt;

	/** expiry date add ppt. */
	private Date expiryDateAddPpt;

	/** issuing agency add ppt. */
	private String issuingAgencyAddPpt;

	/**
	 * @return the indSex
	 */
	public String getIndSex() {
		return indSex;
	}

	/**
	 * @param indSex the indSex to set
	 */
	public void setIndSex(String indSex) {
		this.indSex = indSex;
	}

	/**
	 * @return the indTitle
	 */
	public String getIndTitle() {
		return indTitle;
	}

	/**
	 * @param indTitle the indTitle to set
	 */
	public void setIndTitle(String indTitle) {
		this.indTitle = indTitle;
	}

	/**
	 * @return the indCcc
	 */
	public String getIndCcc() {
		return indCcc;
	}

	/**
	 * @param indCcc the indCcc to set
	 */
	public void setIndCcc(String indCcc) {
		this.indCcc = indCcc;
	}

	/**
	 * @return the hkid
	 */
	public String getHkid() {
		return hkid;
	}

	/**
	 * @param hkid the hkid to set
	 */
	public void setHkid(String hkid) {
		this.hkid = hkid;
	}

	/**
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * @param passportNo the passportNo to set
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * @return the indAddPassportNo
	 */
	public String getIndAddPassportNo() {
		return indAddPassportNo;
	}

	/**
	 * @param indAddPassportNo the indAddPassportNo to set
	 */
	public void setIndAddPassportNo(String indAddPassportNo) {
		this.indAddPassportNo = indAddPassportNo;
	}

	/**
	 * @return the otherIdInfo
	 */
	public String getOtherIdInfo() {
		return otherIdInfo;
	}

	/**
	 * @param otherIdInfo the otherIdInfo to set
	 */
	public void setOtherIdInfo(String otherIdInfo) {
		this.otherIdInfo = otherIdInfo;
	}

	/**
	 * @return the indPeriodHkResinMonth
	 */
	public Long getIndPeriodHkResinMonth() {
		return indPeriodHkResinMonth;
	}

	/**
	 * @param indPeriodHkResinMonth the indPeriodHkResinMonth to set
	 */
	public void setIndPeriodHkResinMonth(Long indPeriodHkResinMonth) {
		this.indPeriodHkResinMonth = indPeriodHkResinMonth;
	}

	/**
	 * @return the indDob
	 */
	public Date getIndDob() {
		return indDob;
	}

	/**
	 * @param indDob the indDob to set
	 */
	public void setIndDob(Date indDob) {
		this.indDob = indDob;
	}

	/**
	 * @return the indPob
	 */
	public String getIndPob() {
		return indPob;
	}

	/**
	 * @param indPob the indPob to set
	 */
	public void setIndPob(String indPob) {
		this.indPob = indPob;
	}

	/**
	 * @return the indOccupation
	 */
	public String getIndOccupation() {
		return indOccupation;
	}

	/**
	 * @param indOccupation the indOccupation to set
	 */
	public void setIndOccupation(String indOccupation) {
		this.indOccupation = indOccupation;
	}

	/**
	 * @return the indEducLevel
	 */
	public String getIndEducLevel() {
		return indEducLevel;
	}

	/**
	 * @param indEducLevel the indEducLevel to set
	 */
	public void setIndEducLevel(String indEducLevel) {
		this.indEducLevel = indEducLevel;
	}

	/**
	 * @return the sourceOfInfo
	 */
	public String getSourceOfInfo() {
		return sourceOfInfo;
	}

	/**
	 * @param sourceOfInfo the sourceOfInfo to set
	 */
	public void setSourceOfInfo(String sourceOfInfo) {
		this.sourceOfInfo = sourceOfInfo;
	}

	/**
	 * @return the limitedInfoInd
	 */
	public String getLimitedInfoInd() {
		return limitedInfoInd;
	}

	/**
	 * @param limitedInfoInd the limitedInfoInd to set
	 */
	public void setLimitedInfoInd(String limitedInfoInd) {
		this.limitedInfoInd = limitedInfoInd;
	}

	/**
	 * @return the nationalityCode
	 */
	public String getNationalityCode() {
		return nationalityCode;
	}

	/**
	 * @param nationalityCode the nationalityCode to set
	 */
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
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
	 * @return the countryCodeAddPassport
	 */
	public String getCountryCodeAddPassport() {
		return countryCodeAddPassport;
	}

	/**
	 * @param countryCodeAddPassport the countryCodeAddPassport to set
	 */
	public void setCountryCodeAddPassport(String countryCodeAddPassport) {
		this.countryCodeAddPassport = countryCodeAddPassport;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the pagerNo
	 */
	public String getPagerNo() {
		return pagerNo;
	}

	/**
	 * @param pagerNo the pagerNo to set
	 */
	public void setPagerNo(String pagerNo) {
		this.pagerNo = pagerNo;
	}

	/**
	 * @return the circularMeans
	 */
	public String getCircularMeans() {
		return circularMeans;
	}

	/**
	 * @param circularMeans the circularMeans to set
	 */
	public void setCircularMeans(String circularMeans) {
		this.circularMeans = circularMeans;
	}

	/**
	 * @return the expiryDatePpt
	 */
	public Date getExpiryDatePpt() {
		return expiryDatePpt;
	}

	/**
	 * @param expiryDatePpt the expiryDatePpt to set
	 */
	public void setExpiryDatePpt(Date expiryDatePpt) {
		this.expiryDatePpt = expiryDatePpt;
	}

	/**
	 * @return the issuingAgencyPpt
	 */
	public String getIssuingAgencyPpt() {
		return issuingAgencyPpt;
	}

	/**
	 * @param issuingAgencyPpt the issuingAgencyPpt to set
	 */
	public void setIssuingAgencyPpt(String issuingAgencyPpt) {
		this.issuingAgencyPpt = issuingAgencyPpt;
	}

	/**
	 * @return the expiryDateAddPpt
	 */
	public Date getExpiryDateAddPpt() {
		return expiryDateAddPpt;
	}

	/**
	 * @param expiryDateAddPpt the expiryDateAddPpt to set
	 */
	public void setExpiryDateAddPpt(Date expiryDateAddPpt) {
		this.expiryDateAddPpt = expiryDateAddPpt;
	}

	/**
	 * @return the issuingAgencyAddPpt
	 */
	public String getIssuingAgencyAddPpt() {
		return issuingAgencyAddPpt;
	}

	/**
	 * @param issuingAgencyAddPpt the issuingAgencyAddPpt to set
	 */
	public void setIssuingAgencyAddPpt(String issuingAgencyAddPpt) {
		this.issuingAgencyAddPpt = issuingAgencyAddPpt;
	}

	/**
	 * @param indOccupationChin the indOccupationChin to set
	 */
	public void setIndOccupationChin(String indOccupationChin) {
		this.indOccupationChin = indOccupationChin;
	}

	/**
	 * @return the indOccupationChin
	 */
	public String getIndOccupationChin() {
		return indOccupationChin;
	}

	/**
	 * Get the bilingual occupation.
	 * @return bilingual occupation
	 */
	public String getBilingualIndOccupation() {
		StringBuffer _buf = new StringBuffer();
		if (indOccupation != null && !"".equals(indOccupation.trim())) {
			_buf.append(indOccupation.trim());
		}

		if (indOccupationChin != null && !"".equals(indOccupationChin.trim())) {
			_buf.append(" (").append(indOccupationChin.trim()).append(")");
		}

		return _buf.toString();
	}
}