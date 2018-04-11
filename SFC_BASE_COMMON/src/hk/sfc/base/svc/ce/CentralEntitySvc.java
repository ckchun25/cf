package hk.sfc.base.svc.ce;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.domain.ce.Address;
import hk.sfc.base.domain.ce.Bank;
import hk.sfc.base.domain.ce.BankAccount;
import hk.sfc.base.domain.ce.Capital;
import hk.sfc.base.domain.ce.CentralEntity;
import hk.sfc.base.domain.ce.ComplaintOfficer;
import hk.sfc.base.domain.ce.ContactInfo;
import hk.sfc.base.domain.ce.Relation;
import hk.sfc.base.exception.SvcException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Central entity entity service interface. 
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
public interface CentralEntitySvc {

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
	public Map queryActivityTypeMap(String locale);

	/**
	 * Query active responsible officers & licensed representatives for a central entity.
	 * @param ceref central entity reference 
	 * @return list of responsible officers & licensed representatives
	 * @throws SvcException Service exception
	 */
	public List queryActiveRoLrByCeref(String ceref);

	/**
	 * Query active responsible officers for a central entity.
	 * @param ceref central entity reference 
	 * @return list of responsible officers
	 * @throws SvcException Service exception
	 */
	public List queryActiveResponsibleOfficerByCeref(String ceref);

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
	 * Query active accredited principals for RO by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals of the responsible officer
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForRoByCeref(String ceref) throws SvcException;

	/**
	 * Query active accredited principals for LR by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals of the licensed representative
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForLrByCeref(String ceref) throws SvcException;

	/**
	 * Query active accredited principals for EO by ceref.
	 * @param ceref central entity reference 
	 * @return list of accredited principals of the executive officers
	 * @throws SvcException Service exception
	 */
	public List queryActiveAccreditedPrincipalForEoByCeref(String ceref) throws SvcException;

	/**
	 * Query active intermediaries for a central entity. (with active licence only)
	 * @param ceref central entity reference 
	 * @return list of relations of intermediaries 
	 * @throws SvcException Service exception
	 */
	public List queryActiveIntermediaryByCeref(String ceref) throws SvcException;

	/**
	 * Query executive officers for a central entity.
	 * @param ceref central entity reference 
	 * @return list of ExecutiveOfficer
	 * @throws SvcException
	 */
	public List queryExecutiveOfficerByCeref(String ceref) throws SvcException;

	/**
	 * Query RI executive officers for a central entity.
	 * @param ceref central entity reference 
	 * @return list of RiExecutiveOfficer
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
	 * Retrieve individual information.
	 * @param ceref central entity reference
	 * @return individual information.
	 * @throws SvcException Service exception
	 */
	public CentralEntity retrieveIndividualByCeref(String ceref) throws SvcException;

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
	 * Query ultimate holding company relations relation.
	 * @param ceref central entity reference 
	 * @return list of relations of ultimate holding companys
	 * @throws SvcException Service exception
	 */
	public List queryUltimateHoldingCompanyRelations(String ceref) throws SvcException;

	/**
	 * Query substantial shareholder relation
	 * @param ceref central entity reference 
	 * @return list of relations of substantial shareholders
	 * @throws SvcException Service exception
	 */
	public List querySubstantialShareholderRelations(String ceref) throws SvcException;

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
	 * @return list of relations
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
	 * Retrieve bank accounts for a central entity.
	 * @param ceref central entity reference 
	 * @param bankCode
	 * @param bankAccNumber
	 * @return list of bank accounts
	 * @throws SvcException Service exception
	 */
	public BankAccount retrieveBankAccount(String ceref, String bankCode, String bankAccNumber)
			throws SvcException;

	/**
	 * Retrieve LHS Relation object.
	 * @param lhsCeref left-hand side central entity reference
	 * @param rhsCeref right-hand side central entity reference
	 * @param relCode relation code
	 * @return relation object
	 * @throws SvcException service exception
	 */
	public Relation retrieveLhsRelation(String lhsCeref, String rhsCeref, String relCode)
			throws SvcException;

	/**
	 * Query a list of Relation objects of a central entity as the LHS relation by 
	 * a list of relation codes and reference date, with rhsCe filled.
	 * @param rhsCeref right-hand side central entity reference
	 * @param relCodes relation codes
	 * @param refDate reference date
	 * @return list of relations
	 * @throws SvcException
	 */
	public List queryLhsRelationsByRelCodes(String rhsCeref, List relCodes, Date refDate)
			throws SvcException;

	/**
	 * Query a list of Relation objects of a central entity as the RHS relation by 
	 * a list of relation codes and reference date, with lhsCe filled.
	 * @param rhsCeref right-hand side central entity reference
	 * @param relCodes relation codes
	 * @param refDate reference date
	 * @return list of relations
	 * @throws SvcException
	 */
	public List queryRhsRelationsByRelCodes(String rhsCeref, List relCodes, Date refDate)
			throws SvcException;

	/**
	 * Query active associated entities for a central entity.
	 * @param ceref central entity reference 
	 * @return list of relations of associated entities 
	 * @throws SvcException Service exception
	 */
	public List queryActiveAssociatedEntityByCeref(String ceref) throws SvcException;

	/**
	 * Query regulated activities of a central entity.
	 * @param ceref central entity reference
	 * @return list of regulated activities
	 * @throw SvcException service exception
	 */
	public List queryRegulatedActivityByCeref(String ceref) throws SvcException;

	/**
	 * Query conditions attached to the licence
	 * @param ceref central entity reference
	 * @return list of conditions
	 * @throws SvcException
	 */
	public List queryConditionsAttachedToLicenceByCeref(String ceref) throws SvcException;

	/**
	 * Query conditions attached to the regulated activities
	 * @param ceref central entity reference
	 * @return list of conditions
	 * @throws SvcException
	 */
	public List queryConditionsAttachedToRaByCeref(String ceref) throws SvcException;

	/**
	 * Query Accredited Principal(s) and Role(s)
	 * @param ceref central entity reference
	 * @return list of accredited principal(s) and role(s)
	 * @throws SvcException
	 */
	public List queryRegulatedActivityAndRoleByCeref(String ceref) throws SvcException;

	/**
	 * Query banks.
	 * @return list of banks
	 * @throws SvcException service exception
	 */
	public List queryBank() throws SvcException;

	/**
	 * Query bank map.
	 * @return map of banks
	 * @throws SvcException service exception
	 */
	public Map queryBankMap() throws SvcException;

	/**
	 * Retrieve bank info by bank code.
	 * @param bankCode 
	 * @return bank object
	 * @throws SvcException Service exception
	 */
	public Bank retrieveBankByBankCode(String bankCode) throws SvcException;

	/**
	 * Retrieve share capital record.
	 * @param ceref central entity reference
	 * @param clsClass share class
	 * @return share capital record
	 * @throws SvcException Service exception
	 */
	public Capital retrieveCapital(String ceref, String clsClass) throws SvcException;

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
	 * Query share capital record by address ID.
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
	 * Retrieve the last update date of profile information.
	 * @return last update date
	 * @throws SvcException
	 */
	public Date retrieveLastUpdateDate() throws SvcException;

	/**
	 * Query a list of Central Entities for Delegation Enquiry.
	 * @param centralEntity
	 * @param paginationQuery
	 * @return list of CentralEntity
	 * @throws SvcException
	 */
	public PageResult queryCeForDelegationEnquiry(CentralEntity centralEntity,
			PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Retrieve user code of team manger for login admin user.
	 * @return user code of team manager
	 * @throws SvcException service exception
	 */
	public String retrieveTeamManagerCode() throws SvcException;

	/**
	 * Check if ceref is either active LC, RI or AE
	 * @param ceref
	 * @return check result
	 * @throws SvcException service exception
	 */
	public boolean isActiveLcRiAe(String ceref) throws SvcException;

	/**
	 * Retrieve contact info by central entity reference.
	 * @param ceref central entity reference
	 * @return contact info
	 * @throws SvcException service exception
	 */
	public ContactInfo retrieveContactInfoByCeref(String ceref);

	/**
	 * Count active licensed representatives for a central entity in page result.
	 * @param ce central entity info 
	 * @return number of licensed representatives 
	 * @throws SvcException Service exception
	 */
	public int countActiveLicensedRepresentativeByCeref(CentralEntity ce) throws SvcException;
	
	/**
	 * Query list of LRP regulated activities by central entity reference.
	 * @param ceref central entity reference 
	 * @return list of LRP regulated activities
	 * @throws SvcException Service exception
	 */
	public List queryLrpRaListByCeref(String ceref);
}