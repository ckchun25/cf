package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

import java.util.Date;

/**
 * Complaint Officer domain object.
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
public class ComplaintOfficer extends SfcDomainObject {

	private static final long serialVersionUID = 2075776115713518352L;

	/** sequence no. */
	private Long seqNo;

	/** central entity reference no */
	private String ceref;
	
	/** Application no. */
	private String applicationNo;
	
	/** central entity. */
	private CentralEntity centralEntity;

	/** name. */
	private String name;

	/** Chinese name. */
	private String nameChin;

	/** title. */
	private String title;

	/** Chinese title. */
	private String titleChin;

	/** telephone. */
	private String tel;

	/** telephone 2. */
	private String tel2;

	/** fax. */
	private String fax;

	/** email. */
	private String email;

	/** rm Building. */
	private String rmBuilding;

	/** street. */
	private String street;

	/** district. */
	private String district;

	/** countrycountryCodeCode. */
	private String countryCode;

	/** city Code. */
	private String cityCode;

	/** state. */
	private String state;

	/** postal Code. */
	private String postalCode;

	/** status. */
	private String status;

	/** effective Date. */
	private Date effDate;

	/** end Date. */
	private Date endDate;

	/** rm Building Chinese. */
	private String rmBuildingChin;

	/** street Chinese. */
	private String streetChin;

	/** district Chinese. */
	private String districtChin;

	/** state Chinese. */
	private String stateChin;

	/** postal Code Chinese. */
	private String postalCodeChin;

	/** full Address. */
	private String fullAddress;

	/** full Address Chinese. */
	private String fullAddressChin;
	
	/**
	 * @return the seqNo
	 */
	public Long getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the rmBuilding
	 */
	public String getRmBuilding() {
		return rmBuilding;
	}

	/**
	 * @param rmBuilding the rmBuilding to set
	 */
	public void setRmBuilding(String rmBuilding) {
		this.rmBuilding = rmBuilding;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	 * @return the rmBuildingChin
	 */
	public String getRmBuildingChin() {
		return rmBuildingChin;
	}

	/**
	 * @param rmBuildingChin the rmBuildingChin to set
	 */
	public void setRmBuildingChin(String rmBuildingChin) {
		this.rmBuildingChin = rmBuildingChin;
	}

	/**
	 * @return the streetChin
	 */
	public String getStreetChin() {
		return streetChin;
	}

	/**
	 * @param streetChin the streetChin to set
	 */
	public void setStreetChin(String streetChin) {
		this.streetChin = streetChin;
	}

	/**
	 * @return the districtChin
	 */
	public String getDistrictChin() {
		return districtChin;
	}

	/**
	 * @param districtChin the districtChin to set
	 */
	public void setDistrictChin(String districtChin) {
		this.districtChin = districtChin;
	}

	/**
	 * @return the stateChin
	 */
	public String getStateChin() {
		return stateChin;
	}

	/**
	 * @param stateChin the stateChin to set
	 */
	public void setStateChin(String stateChin) {
		this.stateChin = stateChin;
	}

	/**
	 * @return the postalCodeChin
	 */
	public String getPostalCodeChin() {
		return postalCodeChin;
	}

	/**
	 * @param postalCodeChin the postalCodeChin to set
	 */
	public void setPostalCodeChin(String postalCodeChin) {
		this.postalCodeChin = postalCodeChin;
	}

	/**
	 * @return the fullAddress
	 */
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * @param fullAddress the fullAddress to set
	 */
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * @return the fullAddressChin
	 */
	public String getFullAddressChin() {
		return fullAddressChin;
	}

	/**
	 * @param fullAddressChin the fullAddressChin to set
	 */
	public void setFullAddressChin(String fullAddressChin) {
		this.fullAddressChin = fullAddressChin;
	}

	/**
	 * @param nameChin the nameChin to set
	 */
	public void setNameChin(String nameChin) {
		this.nameChin = nameChin;
	}

	/**
	 * @return the nameChin
	 */
	public String getNameChin() {
		return nameChin;
	}

	/**
	 * Get the bilingual name.
	 * @return bilingual name
	 */
	public String getBilingualName() {
		StringBuffer _buf = new StringBuffer();
		if (name != null && !"".equals(name.trim())) {
			_buf.append(name.trim());
		}

		if (nameChin != null && !"".equals(nameChin.trim())) {
			_buf.append(" (").append(nameChin.trim()).append(")");
		}

		return _buf.toString();
	}

	/**
	 * @param titleChin the titleChin to set
	 */
	public void setTitleChin(String titleChin) {
		this.titleChin = titleChin;
	}

	/**
	 * @return the titleChin
	 */
	public String getTitleChin() {
		return titleChin;
	}

	/**
	 * Get the bilingual title.
	 * @return bilingual title
	 */
	public String getBilingualTitle() {
		StringBuffer _buf = new StringBuffer();
		if (title != null && !"".equals(title.trim())) {
			_buf.append(title.trim());
		}

		if (titleChin != null && !"".equals(titleChin.trim())) {
			_buf.append(" (").append(titleChin.trim()).append(")");
		}

		return _buf.toString();
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
	 * @return the applicationNo
	 */
	public String getApplicationNo() {
		return applicationNo;
	}

	/**
	 * @param applicationNo the applicationNo to set
	 */
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
}