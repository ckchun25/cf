package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

import java.util.Date;

/**
 * Address domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>23/11/2009</TD><TD>Richard Shiu</TD><TD>Add full address type for PDF.</TD></TR>
 * </TABLE>
 *
 */
public class Address extends SfcDomainObject implements Comparable {

	private static final long serialVersionUID = -8496537576208861372L;

	/** Address descriptions. */
	public static final String ADDR_PRINCIPAL_DESC = "Principal Place of Business";
	public static final String ADDR_PRINCIPAL_BUSINESS_DESC = "Other Places of Business";
	public static final String ADDR_REGISTRATION_DESC = "Registered Office";
	public static final String ADDR_CORRESPONDENCE_DESC = "Correspondence";
	public static final String ADDR_RECORDS_KEPT_DESC = "Record Keeping Premises";
	public static final String ADDR_RESIDENTIAL_DESC = "Residential";
	
	/** Central entity reference. */
	private String ceref;

	/** address ID */
	private String addrId;

	/** address effective date */
	private Date addrEffDate;

	/** address end date */
	private Date addrEndDate;

	/** correspondence address */
	private String addrCorrespondence;

	/** residential address */
	private String addrResidential;

	/** registration address */
	private String addrRegistration;

	/** record keeping address */
	private String addrRecordKept;

	/** business address */
	private String addrPrincipalBusiness;

	/** principal address */
	private String addrPrincipal;

	/** section 67 address */
	private String addrSection67;

	/** branch address */
	private String addrBranch;

	/** address S31 */
	private String addrS31;

	/** address other ind */
	private String addrOtherInd;

	/** address postal code */
	private String addrPostalCode;

	/** address telephone */
	private String addrTelephone;

	/** address telephone 2 */
	private String addrTelephone2;

	/** address business telephone */
	private String addrBusTelephone;

	/** address fax */
	private String addrFax;

	/** address residential fax */
	private String addrResFax;

	/** address telex */
	private String addrTelex;

	/** address cable */
	private String addrCable;

	/** address header */
	private String addrHeader;

	/** address street lot */
	private String addrStreetLot;

	/** address district */
	private String addrDistrict;

	/** address state */
	private String addrState;

	/** city Code */
	private String cityCode;

	/** country Code */
	private String countryCode;

	/** address Header Chinese */
	private String addrHeaderChin;

	/** address Street Lot Chinese */
	private String addrStreetLotChin;

	/** address District Chinese */
	private String addrDistrictChin;

	/** address City Chinese */
	private String addrCityChin;

	/** address State Chinese */
	private String addrStateChin;

	/** address Postal Code Chinese */
	private String addrPostalCodeChin;

	/** address S181 Disk End */
	private String addrS181DiskEnd;

	/** full address */
	private String fullAddress;

	/** full address chinese */
	private String fullAddressChin;

	/** full address type. */
	private String fullAddressType;

	/**
	 * getter method of ceref
	 * @return String
	 */
	public String getCeref() {
		return ceref;
	}

	/**
	 * setter method of ceref
	 * @param ceref
	 */
	public void setCeref(String ceref) {
		this.ceref = ceref;
	}

	/**
	 * getter method of addrId
	 * @return String
	 */
	public String getAddrId() {
		return addrId;
	}

	/**
	 * setter method of addrId
	 * @param addrId
	 */
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	/**
	 * getter method of addrEffDate
	 * @return Date
	 */
	public Date getAddrEffDate() {
		return addrEffDate;
	}

	/**
	 * setter method of addrEffDate
	 * @param addrEffDate
	 */
	public void setAddrEffDate(Date addrEffDate) {
		this.addrEffDate = addrEffDate;
	}

	/**
	 * getter method of addrEndDate
	 * @return Date
	 */
	public Date getAddrEndDate() {
		return addrEndDate;
	}

	/**
	 * setter method of addrEndDate
	 * @param addrEndDate
	 */
	public void setAddrEndDate(Date addrEndDate) {
		this.addrEndDate = addrEndDate;
	}

	/**
	 * getter method of addrCorrespondence
	 * @return String
	 */
	public String getAddrCorrespondence() {
		return addrCorrespondence;
	}

	/**
	 * setter method of addrCorrespondence
	 * @param addrCorrespondence
	 */
	public void setAddrCorrespondence(String addrCorrespondence) {
		this.addrCorrespondence = addrCorrespondence;
	}

	/**
	 * getter method of addrResidential
	 * @return String
	 */
	public String getAddrResidential() {
		return addrResidential;
	}

	/**
	 * setter method of addrResidential
	 * @param addrResidential
	 */
	public void setAddrResidential(String addrResidential) {
		this.addrResidential = addrResidential;
	}

	/**
	 * getter method of addrRegistration
	 * @return String
	 */
	public String getAddrRegistration() {
		return addrRegistration;
	}

	/**
	 * setter method of addrRegistration
	 * @param addrRegistration
	 */
	public void setAddrRegistration(String addrRegistration) {
		this.addrRegistration = addrRegistration;
	}

	/**
	 * getter method of addrRecordKept
	 * @return String
	 */
	public String getAddrRecordKept() {
		return addrRecordKept;
	}

	/**
	 * setter method of addrRecordKept
	 * @param addrRecordKept
	 */
	public void setAddrRecordKept(String addrRecordKept) {
		this.addrRecordKept = addrRecordKept;
	}

	/**
	 * getter method of addrPrincipalBusiness
	 * @return String
	 */
	public String getAddrPrincipalBusiness() {
		return addrPrincipalBusiness;
	}

	/**
	 * setter method of addrPrincipalBusiness
	 * @param addrPrincipalBusiness
	 */
	public void setAddrPrincipalBusiness(String addrPrincipalBusiness) {
		this.addrPrincipalBusiness = addrPrincipalBusiness;
	}

	/**
	 * getter method of addrSection67
	 * @return String
	 */
	public String getAddrSection67() {
		return addrSection67;
	}

	/**
	 * setter method of addrSection67
	 * @param addrSection67
	 */
	public void setAddrSection67(String addrSection67) {
		this.addrSection67 = addrSection67;
	}

	/**
	 * getter method of addrBranch
	 * @return String
	 */
	public String getAddrBranch() {
		return addrBranch;
	}

	/**
	 * setter method of addrBranch
	 * @param addrBranch
	 */
	public void setAddrBranch(String addrBranch) {
		this.addrBranch = addrBranch;
	}

	/**
	 * getter method of addrS31
	 * @return String
	 */
	public String getAddrS31() {
		return addrS31;
	}

	/**
	 * setter method of addrS31
	 * @param addrS31
	 */
	public void setAddrS31(String addrS31) {
		this.addrS31 = addrS31;
	}

	/**
	 * getter method of addrOtherInd
	 * @return String
	 */
	public String getAddrOtherInd() {
		return addrOtherInd;
	}

	/**
	 * setter method of addrOtherInd
	 * @param addrOtherInd
	 */
	public void setAddrOtherInd(String addrOtherInd) {
		this.addrOtherInd = addrOtherInd;
	}

	/**
	 * getter method of addrPostalCode
	 * @return String
	 */
	public String getAddrPostalCode() {
		return addrPostalCode;
	}

	/**
	 * setter method of addrPostalCode
	 * @param addrPostalCode
	 */
	public void setAddrPostalCode(String addrPostalCode) {
		this.addrPostalCode = addrPostalCode;
	}

	/**
	 * getter method of addrTelephone
	 * @return String
	 */
	public String getAddrTelephone() {
		return addrTelephone;
	}

	/**
	 * setter method of addrTelephone
	 * @param addrTelephone
	 */
	public void setAddrTelephone(String addrTelephone) {
		this.addrTelephone = addrTelephone;
	}

	/**
	 * getter method of addrTelephone2
	 * @return String
	 */
	public String getAddrTelephone2() {
		return addrTelephone2;
	}

	/**
	 * setter method of addrTelephone2
	 * @param addrTelephone2
	 */
	public void setAddrTelephone2(String addrTelephone2) {
		this.addrTelephone2 = addrTelephone2;
	}

	/**
	 * getter method of addrFax
	 * @return String
	 */
	public String getAddrFax() {
		return addrFax;
	}

	/**
	 * setter method of addrFax
	 * @param addrFax
	 */
	public void setAddrFax(String addrFax) {
		this.addrFax = addrFax;
	}

	/**
	 * getter method of addrTelex
	 * @return String
	 */
	public String getAddrTelex() {
		return addrTelex;
	}

	/**
	 * setter method of addrTelex
	 * @param addrTelex
	 */
	public void setAddrTelex(String addrTelex) {
		this.addrTelex = addrTelex;
	}

	/**
	 * getter method of addrCable
	 * @return String
	 */
	public String getAddrCable() {
		return addrCable;
	}

	/**
	 * setter method of addrCable
	 * @param addrCable
	 */
	public void setAddrCable(String addrCable) {
		this.addrCable = addrCable;
	}

	/**
	 * getter method of addrHeader
	 * @return String
	 */
	public String getAddrHeader() {
		return addrHeader;
	}

	/**
	 * setter method of addrHeader
	 * @param addrHeader
	 */
	public void setAddrHeader(String addrHeader) {
		this.addrHeader = addrHeader;
	}

	/**
	 * getter method of addrStreetLot
	 * @return String
	 */
	public String getAddrStreetLot() {
		return addrStreetLot;
	}

	/**
	 * setter method of addrStreetLot
	 * @param addrStreetLot
	 */
	public void setAddrStreetLot(String addrStreetLot) {
		this.addrStreetLot = addrStreetLot;
	}

	/**
	 * getter method of addrDistrict
	 * @return String
	 */
	public String getAddrDistrict() {
		return addrDistrict;
	}

	/**
	 * setter method of addrDistrict
	 * @param addrDistrict
	 */
	public void setAddrDistrict(String addrDistrict) {
		this.addrDistrict = addrDistrict;
	}

	/**
	 * getter method of addrState
	 * @return String
	 */
	public String getAddrState() {
		return addrState;
	}

	/**
	 * setter method of addrState
	 * @param addrState
	 */
	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	/**
	 * getter method of cityCode
	 * @return String
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * setter method of cityCode
	 * @param cityCode
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * getter method of countryCode
	 * @return String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * setter method of countryCode
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * getter method of addrHeaderChin
	 * @return String
	 */
	public String getAddrHeaderChin() {
		return addrHeaderChin;
	}

	/**
	 * setter method of addrHeaderChin
	 * @param addrHeaderChin
	 */
	public void setAddrHeaderChin(String addrHeaderChin) {
		this.addrHeaderChin = addrHeaderChin;
	}

	/**
	 * getter method of addrStreetLotChin
	 * @return String
	 */
	public String getAddrStreetLotChin() {
		return addrStreetLotChin;
	}

	/**
	 * setter method of addrStreetLotChin
	 * @param addrStreetLotChin
	 */
	public void setAddrStreetLotChin(String addrStreetLotChin) {
		this.addrStreetLotChin = addrStreetLotChin;
	}

	/**
	 * getter method of addrDistrictChin
	 * @return String
	 */
	public String getAddrDistrictChin() {
		return addrDistrictChin;
	}

	/**
	 * setter method of addrDistrictChin
	 * @param addrDistrictChin
	 */
	public void setAddrDistrictChin(String addrDistrictChin) {
		this.addrDistrictChin = addrDistrictChin;
	}

	/**
	 * getter method of addrCityChin
	 * @return String
	 */
	public String getAddrCityChin() {
		return addrCityChin;
	}

	/**
	 * setter method of addrCityChin
	 * @param addrCityChin
	 */
	public void setAddrCityChin(String addrCityChin) {
		this.addrCityChin = addrCityChin;
	}

	/**
	 * getter method of addrStateChin
	 * @return String
	 */
	public String getAddrStateChin() {
		return addrStateChin;
	}

	/**
	 * setter method of addrStateChin
	 * @param addrStateChin
	 */
	public void setAddrStateChin(String addrStateChin) {
		this.addrStateChin = addrStateChin;
	}

	/**
	 * getter method of addrPostalCodeChin
	 * @return String
	 */
	public String getAddrPostalCodeChin() {
		return addrPostalCodeChin;
	}

	/**
	 * setter method of addrPostalCodeChin
	 * @param addrPostalCodeChin
	 */
	public void setAddrPostalCodeChin(String addrPostalCodeChin) {
		this.addrPostalCodeChin = addrPostalCodeChin;
	}

	/**
	 * getter method of addrS181DiskEnd
	 * @return String
	 */
	public String getAddrS181DiskEnd() {
		return addrS181DiskEnd;
	}

	/**
	 * setter method of addrS181DiskEnd
	 * @param addrS181DiskEnd
	 */
	public void setAddrS181DiskEnd(String addrS181DiskEnd) {
		this.addrS181DiskEnd = addrS181DiskEnd;
	}

	/**
	 * setter method of addrBusTelephone
	 * @param addrBusTelephone
	 */
	public void setAddrBusTelephone(String addrBusTelephone) {
		this.addrBusTelephone = addrBusTelephone;
	}

	/**
	 * getter method of addrBusTelephone
	 * @return String
	 */
	public String getAddrBusTelephone() {
		return addrBusTelephone;
	}

	/**
	 * setter method of addrResFax
	 * @param addrResFax
	 */
	public void setAddrResFax(String addrResFax) {
		this.addrResFax = addrResFax;
	}

	/**
	 * getter method of addrResFax
	 * @return String
	 */
	public String getAddrResFax() {
		return addrResFax;
	}

	/**
	 * getter method of fullAddress
	 * @return String
	 */
	public String getFullAddress() {
		return fullAddress;
	}

	/**
	 * setter method of fullAddress
	 * @param fullAddress
	 */
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	/**
	 * getter method of fullAddressChin
	 * @return String
	 */
	public String getFullAddressChin() {
		return fullAddressChin;
	}

	/**
	 * setter method of fullAddressChin
	 * @param fullAddressChin
	 */
	public void setFullAddressChin(String fullAddressChin) {
		this.fullAddressChin = fullAddressChin;
	}

	/**
	 * Compares this object with the specified object for order.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		Address _other = (Address) obj;

		if (_other == null)
			return -1;
		else if (addrId == null && _other.getAddrId() == null)
			return 0;
		else if (addrId == null)
			return 1;
		else if (_other.getAddrId() == null)
			return -1;
		else return _other.getAddrId().compareTo(addrId);
	}

	/**
	 * setter method of addrPrincipal
	 * @param addrPrincipal
	 */
	public void setAddrPrincipal(String addrPrincipal) {
		this.addrPrincipal = addrPrincipal;
	}

	/**
	 * getter method of addrPrincipal
	 * @return String
	 */
	public String getAddrPrincipal() {
		return addrPrincipal;
	}

	/**
	 * @param fullAddressType the fullAddressType to set
	 */
	public void setFullAddressType(String fullAddressType) {
		this.fullAddressType = fullAddressType;
	}

	/**
	 * @return the fullAddressType
	 */
	public String getFullAddressType() {
		return fullAddressType;
	}
}