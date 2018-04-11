package hk.sfc.base.svc.ce;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.domain.ce.Address;
import hk.sfc.base.domain.ce.CentralEntity;
import hk.sfc.base.domain.ce.ComplaintOfficer;
import hk.sfc.base.exception.SvcException;

import java.util.List;
import java.util.Map;

/**
 * Central entity business service interface.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>07/04/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface ProcessCentralEntitySvc {

	/**
	 * Query central entity for search CE function.
	 * @param centralEntity query parameters for central entity record
	 * @param paginationQuery pagination parameters
	 * @return PageResult list of matching central entity records
	 * @throws SvcException Service exception
	 */
	public PageResult paginateForSearchCentralEntity(CentralEntity ce,
			PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Retrieve central entity domain object.
	 * @param ceref central entity reference 
	 * @return central entity domain object
	 * @throws SvcException Service exception
	 */
	public CentralEntity retrieveCentralEntity(String ceref) throws SvcException;

	/**
	 * Query regulated activity type map.
	 * @param locale current user locale 
	 * @return map from activity type ID to activity type description
	 */
	public Map queryActivityTypeMap(String locale) throws SvcException;

	/**
	 * Query active responsible officers for a central entity.
	 * @param ceref central entity reference 
	 * @return list of responsible officers
	 * @throws SvcException Service exception
	 */
	public List queryActiveResponsibleOfficerByCeref(String ceref) throws SvcException;

	/**
	 * Query active licensed representatives for a central entity.
	 * @param ceref central entity reference 
	 * @return list of licensed representatives 
	 * @throws SvcException Service exception
	 */
	public List queryActiveLicensedRepresentativeByCeref(String ceref) throws SvcException;

	/**
	 * Query active licensed representatives for a central entity in page result.
	 * @param ce central entity info 
	 * @param paginationQuery pagination parameters
	 * @return paged list of licensed representatives 
	 * @throws SvcException Service exception
	 */
	public PageResult paginateForActiveLicensedRepresentativeByCeref(CentralEntity ce,
			PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Count active licensed representatives for a central entity in page result.
	 * @param ce central entity info 
	 * @return number of licensed representatives 
	 * @throws SvcException Service exception
	 */
	public int countActiveLicensedRepresentativeByCeref(CentralEntity ce) throws SvcException;
	
	/**
	 * Query active accredited principals for RO by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals for the responsible officer
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForRoByCeref(String ceref) throws SvcException;

	/**
	 * Query active accredited principals for LR by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals for the licensed representative
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForLrByCeref(String ceref) throws SvcException;

	/**
	 * Query active accredited principals for EO by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals for the executive officer
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForEoByCeref(String ceref) throws SvcException;

	/**
	 * Query active associated entities for a central entity.
	 * @param ceref central entity reference 
	 * @return list of relations of associated entities 
	 * @throws SvcException Service exception
	 */
	public List queryActiveAssociatedEntityByCeref(String ceref) throws SvcException;

	/**
	 * Query active intermediaries for a central entity.
	 * @param ceref central entity reference 
	 * @return list of relations of intermediaries 
	 * @throws SvcException Service exception
	 */
	public List queryActiveIntermediaryByCeref(String ceref) throws SvcException;

	/**
	 * Query executive officers for a central entity.
	 * @param ceref central entity reference
	 * @return list of executive officers 
	 * @throws SvcException Service exception
	 */
	public List queryRiExecutiveOfficerByCeref(String ceref) throws SvcException;

	/**
	 * Retrieve RI executive officer by ceref.
	 * @param ceref central entity reference of registered institution
	 * @param targetCeref central entity reference of executive officer 
	 * @return executive officer info
	 * @throws SvcException Service exception
	 */
	public CentralEntity retrieveRiExecutiveOfficerByCeref(String ceref, String targetCeref)
			throws SvcException;

	/**
	 * Query emergency contact persons for a central entity.
	 * @param ceref central entity reference 
	 * @return list of emergency contact persons 
	 * @throws SvcException Service exception
	 */
	public List queryEmergencyContactPersonByCeref(String ceref) throws SvcException;

	/**
	 * Retrieve emergency contact person information.
	 * @param ceref central entity reference 
	 * @return emergency contact person info 
	 * @throws SvcException Service exception
	 */
	public CentralEntity retrieveEmergencyContactPersonByCeref(String ceref) throws SvcException;

	/**
	 * Query active complaint officers for a central entity.
	 * @param ceref central entity reference 
	 * @return list of complaint officers 
	 * @throws SvcException Service exception
	 */
	public List queryActiveComplaintOfficerByCeref(String ceref) throws SvcException;

	/**
	 * Retrieve complaint officer information.
	 * @param ceref central entity reference 
	 * @param seqNo
	 * @return complaint officer info 
	 * @throws SvcException Service exception
	 */
//	public ComplaintOfficer retrieveComplaintOfficerBySeqNo(String ceref, Long seqNo)
//			throws SvcException;

	/**
	 * Query directors for a central entity.
	 * @param ceref central entity reference 
	 * @return list of relations of directors
	 * @throws SvcException Service exception
	 */
	public List queryDirectorByCeref(String ceref) throws SvcException;

	/**
	 * Query auditors for a central entity.
	 * @param ceref central entity reference 
	 * @return list of relations of auditors
	 * @throws SvcException Service exception
	 */
	public List queryAuditorByCeref(String ceref) throws SvcException;

	/**
	 * Query other directorships for a central entity.
	 * @param ceref central entity reference 
	 * @return list of other directorships
	 * @throws SvcException Service exception
	 */
	public List queryOtherDirectorshipByCeref(String ceref) throws SvcException;

	/**
	 * Query business interests for a central entity.
	 * @param ceref central entity reference 
	 * @return list of business interests
	 * @throws SvcException Service exception
	 */
	public List queryBusinessInterestByCeref(String ceref) throws SvcException;

	/**
	 * Query bank accounts for a central entity.
	 * @param ceref central entity reference 
	 * @return list of bank accounts
	 * @throws SvcException Service exception
	 */
	public List queryBankAccountByCeref(String ceref) throws SvcException;

	/**
	 * Query regulated activities of a central entity.
	 * @param ceref central entity reference
	 * @return list of regulated activities
	 * @throw SvcException service exception
	 */
	public List queryRegulatedActivityByCeref(String ceref) throws SvcException;

	/**
	 * Query banks.
	 * @return list of banks
	 * @throws SvcException service exception
	 */
	public List queryBank() throws SvcException;

	/**
	 * Query share capital record by ceref.
	 * @param ceref central entity reference
	 * @return share capital records
	 * @throws SvcException Service exception
	 */
	public List queryCapitalByCeref(String ceref) throws SvcException;

	/**
	 * Query address by ceref.
	 * @param ceref central entity reference
	 * @return address list
	 * @throws SvcException Service exception
	 */
	public List queryAddressByCeref(String ceref) throws SvcException;

	/**
	 * Query correspondence address by ceref.
	 * @param ceref central entity reference
	 * @return address list
	 * @throws SvcException Service exception
	 */
	public List queryCorrespondenceAddressByCeref(String ceref) throws SvcException;
	
	/**
	 * Retrieve address by address ID.
	 * @param ceref central entity reference
	 * @param addrId address ID
	 * @return address
	 * @throws SvcException Service exception
	 */
	public Address retrieveAddressById(String ceref, String addrId) throws SvcException;

	/**
	 * Query email by ceref.
	 * @param ceref central entity reference
	 * @return email list
	 * @throws SvcException Service exception
	 */
	public List queryEmailByCeref(String ceref) throws SvcException;

	/**
	 * Query website by ceref.
	 * @param ceref central entity reference
	 * @return website list
	 * @throws SvcException Service exception
	 */
	public List queryWebsiteByCeref(String ceref) throws SvcException;

	/**
	 * Query substantial shareholder relation
	 * @param ceref central entity reference 
	 * @return list of relations of substantial shareholders
	 * @throws SvcException Service exception
	 */
	public List querySubstantialShareholderRelations(String ceref) throws SvcException;

	/**
	 * Query ultimate holding company relations relation.
	 * @param ceref central entity reference 
	 * @return list of relations of ultimate holding companys
	 * @throws SvcException Service exception
	 */
	public List queryUltimateHoldingCompanyRelations(String ceref) throws SvcException;

	/**
	 * Retrieve CE type by ceref.
	 * @param ceref central entity reference
	 * @return CE type
	 * @throws SvcException Service exception
	 */
	public String retrieveCeTypeByCeref(String ceref) throws SvcException;
	
	/**
	 * Query team manager.
	 * @return list of team managers.
	 * @throws SvcException service exception
	 */
	public List queryTeamManager() throws SvcException;

	/**
	 * Query a page of Central Entities for Delegation Enquiry.
	 * @param CentralEntity
	 * @param paginationQuery
	 * @return list of CentralEntity
	 * @throws SvcException
	 */
	public PageResult queryCeForDelegationEnquiry(CentralEntity centralEntity, PaginationQuery paginationQuery) throws SvcException;
	
	/**
	 * Check if ceref is either active LC, RI or AE
	 * @param ceref
	 * @return check result
	 * @throws SvcException service exception
	 */
	public boolean isActiveLcRiAe(String ceref) throws SvcException;
	
	/**
	 * Query list of LRP regulated activities by central entity reference.
	 * @param ceref central entity reference 
	 * @return list of LRP regulated activities
	 * @throws SvcException Service exception
	 */
	public List queryLrpRaListByCeref(String ceref);
}