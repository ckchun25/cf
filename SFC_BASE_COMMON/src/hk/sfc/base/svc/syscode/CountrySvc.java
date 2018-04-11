package hk.sfc.base.svc.syscode;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.domain.syscode.Country;
import hk.sfc.base.exception.SvcException;

import java.util.Map;


/**
 * Country entity service interface.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>26/05/2009</TD><TD>Karl Yeung</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>Karl Yeung</TD><TD>Adding Source Comment.</TD></TR>
 * <TR><TD>ASR14171</TD><TD>23/07/2009</TD><TD>Karl Yeung</TD><TD>log #618 Add passport country list with other country and remove other country in general usage.</TD></TR>
 * </TABLE>
 *
 */
public interface CountrySvc {

	/**
	 * Query countries without other country.
	 * @param country criteria of this query
	 * @param paginationQuery pagination information
	 * @return the PageResult object with the list of country objects
	 * @throws SvcException Service exception
	 */
	public PageResult paginateCountry(Country country, PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Query countries' name map for display.
	 * @param locale current user locale
	 * @return the map of country name which countryCode is the key
	 * @throws SvcException Service exception
	 */
	public Map queryCountryNameMap(String locale) throws SvcException;

	/**
	 * Query countries with other country for passport usage.
	 * @param country criteria of this query
	 * @param paginationQuery pagination information
	 * @return the PageResult object with the list of country objects
	 * @throws SvcException Service exception
	 */
	public PageResult paginateCountryForPassport(Country country, PaginationQuery paginationQuery) throws SvcException;

}
