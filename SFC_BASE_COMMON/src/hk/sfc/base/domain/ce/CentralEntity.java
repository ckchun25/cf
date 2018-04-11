package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;
import hk.sfc.base.utils.EncodeHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *  Central entity domain object.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>26/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>28/08/2009</TD><TD>Karl Yeung</TD><TD>Add static variables of entity type.</TD></TR>
 * <TR><TD>ASR14171</TD><TD>12/11/2009</TD><TD>Richard Shiu</TD><TD>P1R3 R3-UAT#126: Fix other business address display bug.</TD></TR>
 * </TABLE>
 *
 */
public class CentralEntity extends SfcDomainObject {

	private static final long serialVersionUID = 4910885256098243106L;

	/** The length of ceref */
	public static final int CEREF_LENGTH = 6;

	/** EntityType - Individual. */
	public static final String ENTITY_TYPE_INDIVIDUAL = "I";

	/** EntityType - Corporate. */
	public static final String ENTITY_TYPE_CORPORATE = "B";

	/** Central entity reference. */
	private String ceref;

	/**	Company name / surname of the central entity. */
	private String entityName;

	/** First name of the central entity. */
	private String entityOtherName;

	/** English full name of the central entity. */
	private String fullName;

	/** Chinese full name of the central entity. */
	private String entityNameChin;

	/** Entity type. */
	private String entityType;

	/** Entity subtype code. */
	private String entitySubtypeCode;

	/** Owner Unit. */
	private String ownerUnit;

	/** Creation Date. */
	private Date creationDate;

	/**	Common Anniversary Date Group. */
	//private CadGroup cadGroup;

	/** List of licence applications. */
	private List licenceApplications;

	/** List of address. */
	private List addresses;

	/** Principal address of entity. */
	private Address principalAddress;

	/** Address cache. */
	private Map addressesCache = new HashMap();

	/** List of EO activities for an RI EO. */
	private List eoActivities;

	/** Individual details. */
	private IndividualDetail individualDetail;

	/** Business details. */
	private BusinessDetail businessDetail;

	/** Licence Applications details. */
	//private LicenceApplication licenceApplication;

	/** List of emails. */
	private List emails;

	/** List of website */
	private List websites;

	/** Business email. */
	private String businessEmail;

	/** Personal email. */
	private String personalEmail;

	public String getEncodedCeref() {
		return EncodeHelper.encode(ceref);
	}

	/**
	 * Get list of Other Business Addresses
	 * @return list of Other Business Addresses
	 */
	public List getPrimaryBusinessAddresses() {

		String _key = "primaryBusinessAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrPrincipalBusiness())) {
						_list.add(_address);
					}
				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Correspondence Addresses
	 * @return list of Correspondence Addresses
	 */
	public List getCorrespondenceAddresses() {

		String _key = "correspondenceAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrCorrespondence())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Correspondence Addresses
	 * @return list of Correspondence Addresses
	 */
	public List getPrimaryCorrespondenceAddresses() {

		String _key = "primaryCorrespondenceAddresses";

		if (!addressesCache.containsKey(_key)) {

			Set _addrSet = new TreeSet();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrCorrespondence())) {
						_addrSet.add(_address);
					}
				}
			}

			List _list = new ArrayList();
			Iterator _it = _addrSet.iterator();
			if (_it.hasNext()) {
				_list.add(_it.next());
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Registered Office Addresses
	 * @return list of Registered Office Addresses
	 */
	public List getRegisteredOfficeAddresses() {
		String _key = "registeredOfficeAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrRegistration())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Record Keeping Addresses
	 * @return list of Record Keeping Addresses
	 */
	public List getRecordKeepingAddresses() {
		String _key = "recordKeepingAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrRecordKept())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Residential and Overseas Addresses
	 * @return list of Residential and Overseas Addresses
	 */
	public List getResidentialAndOverseasAddresses() {
		String _key = "residentialAndOverseasAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrResidential())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Residential Addresses
	 * @return list of Residential Addresses
	 */
	public List getResidentialAddresses() {
		String _key = "residentialAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrResidential())
							&& "HK".equals(_address.getCountryCode())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get list of Overseas Addresses
	 * @return list of Overseas Addresses
	 */
	public List getOverseasAddresses() {
		String _key = "overseasAddresses";

		if (!addressesCache.containsKey(_key)) {

			List _list = new ArrayList();

			if (getAddresses() != null) {
				for (int i = 0; i < getAddresses().size(); i++) {
					Address _address = (Address) getAddresses().get(i);

					if ("Y".equals(_address.getAddrResidential())
							&& !"HK".equals(_address.getCountryCode())) {
						_list.add(_address);
					}

				}
			}

			addressesCache.put(_key, _list);
		}

		return (List) addressesCache.get(_key);
	}

	/**
	 * Get the bilingual name.
	 * @return bilingual name
	 */
	public String getBilingualName() {
		StringBuffer _buf = new StringBuffer();
		if (fullName != null && !"".equals(fullName.trim())) {
			_buf.append(fullName.trim());
		}

		if (entityNameChin != null && !"".equals(entityNameChin.trim())) {
			_buf.append(" (").append(entityNameChin.trim()).append(")");
		}

		return _buf.toString();
	}

	/**
	 * Get the bilingual name and central entity reference number.
	 * @return the bilingual name and central entity reference number
	 */
	public String getBilingualNameAndCeref() {
		StringBuffer _buf = new StringBuffer();
		if (fullName != null && !"".equals(fullName.trim())) {
			_buf.append(fullName.trim());
		}

		if (entityNameChin != null && !"".equals(entityNameChin.trim())) {
			_buf.append(" (").append(entityNameChin.trim()).append(")");
		}

		if (ceref != null && !"".equals(ceref.trim())) {
			_buf.append(" (").append(ceref.trim()).append(")");
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

	/**
	 * @return the entityType
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * @return the entitySubtypeCode
	 */
	public String getEntitySubtypeCode() {
		return entitySubtypeCode;
	}

	/**
	 * @param entitySubtypeCode the entitySubtypeCode to set
	 */
	public void setEntitySubtypeCode(String entitySubtypeCode) {
		this.entitySubtypeCode = entitySubtypeCode;
	}

	/**
	 * @return the ownerUnit
	 */
	public String getOwnerUnit() {
		return ownerUnit;
	}

	/**
	 * @param ownerUnit the ownerUnit to set
	 */
	public void setOwnerUnit(String ownerUnit) {
		this.ownerUnit = ownerUnit;
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
	 * @return the cadGroup
	 */
//	public CadGroup getCadGroup() {
//		return cadGroup;
//	}

	/**
	 * @param cadGroup the cadGroup to set
	 */
//	public void setCadGroup(CadGroup cadGroup) {
//		this.cadGroup = cadGroup;
//	}

	/**
	 * @return the licenceApplications
	 */
	public List getLicenceApplications() {
		return licenceApplications;
	}

	/**
	 * @param licenceApplications the licenceApplications to set
	 */
	public void setLicenceApplications(List licenceApplications) {
		this.licenceApplications = licenceApplications;
	}

	/**
	 * @return the addresses
	 */
	public List getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the principalAddress
	 */
	public Address getPrincipalAddress() {
		return principalAddress;
	}

	/**
	 * @param principalAddress the principalAddress to set
	 */
	public void setPrincipalAddress(Address principalAddress) {
		this.principalAddress = principalAddress;
	}

	/**
	 * @return the addressesCache
	 */
	public Map getAddressesCache() {
		return addressesCache;
	}

	/**
	 * @param addressesCache the addressesCache to set
	 */
	public void setAddressesCache(Map addressesCache) {
		this.addressesCache = addressesCache;
	}

	/**
	 * @return the eoActivities
	 */
	public List getEoActivities() {
		return eoActivities;
	}

	/**
	 * @param eoActivities the eoActivities to set
	 */
	public void setEoActivities(List eoActivities) {
		this.eoActivities = eoActivities;
	}

	/**
	 * @return the individualDetail
	 */
	public IndividualDetail getIndividualDetail() {
		return individualDetail;
	}

	/**
	 * @param individualDetail the individualDetail to set
	 */
	public void setIndividualDetail(IndividualDetail individualDetail) {
		this.individualDetail = individualDetail;
	}

	/**
	 * @return the businessDetail
	 */
	public BusinessDetail getBusinessDetail() {
		return businessDetail;
	}

	/**
	 * @param businessDetail the businessDetail to set
	 */
	public void setBusinessDetail(BusinessDetail businessDetail) {
		this.businessDetail = businessDetail;
	}

	/**
	 * @return the emails
	 */
	public List getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List emails) {
		this.emails = emails;
	}

	/**
	 * @return the websites
	 */
	public List getWebsites() {
		return websites;
	}

	/**
	 * @param websites the websites to set
	 */
	public void setWebsites(List websites) {
		this.websites = websites;
	}

	/**
	 * @return the businessEmail
	 */
	public String getBusinessEmail() {
		return businessEmail;
	}

	/**
	 * @param businessEmail the businessEmail to set
	 */
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	/**
	 * @return the personalEmail
	 */
	public String getPersonalEmail() {
		return personalEmail;
	}

	/**
	 * @param personalEmail the personalEmail to set
	 */
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	/**
	 * Convenient method to retrieve the applNo from licenceApplication. 
	 */
//	public String getApplNo() {
//		if (licenceApplications != null && licenceApplications.size() > 0) {
//			LicenceApplication _la = (LicenceApplication) licenceApplications.get(0);
//			return _la.getApplNo();
//		} else {
//			return null;
//		}
//	}

	/**
	 * Convenient method to retrieve the lcType from licenceApplication. 
	 */
//	public String getLcType() {
//		if (licenceApplications != null && licenceApplications.size() > 0) {
//			LicenceApplication _la = (LicenceApplication) licenceApplications.get(0);
//			return _la.getLcType();
//		} else {
//			return null;
//		}
//	}

	/**
	 * @return the licenceApplication
	 */
//	public LicenceApplication getLicenceApplication() {
//		return licenceApplication;
//	}

	/**
	 * @param licenceApplication the licenceApplication to set
	 */
//	public void setLicenceApplication(LicenceApplication licenceApplication) {
//		this.licenceApplication = licenceApplication;
//	}
}