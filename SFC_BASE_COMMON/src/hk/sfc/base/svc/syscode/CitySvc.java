package hk.sfc.base.svc.syscode;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.domain.syscode.City;
import hk.sfc.base.exception.SvcException;

import java.util.Map;


/**
 * City entity service interface.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>26/05/2009</TD><TD>Karl Yeung</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>Karl Yeung</TD><TD>Adding Source Comment.</TD></TR>
 * </TABLE>
 *
 */
public interface CitySvc {

	/**
	 * Query cities.
	 * @param city criteria of this query
	 * @param paginationQuery pagination information
	 * @return the PageResult object with the list of city objects
	 * @throws SvcException Service exception
	 */
	public PageResult paginateCity(City city, PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Query cities' name map for display.
	 * @param locale current user locale
	 * @return the map of city name which cityCode is the key
	 * @throws SvcException Service exception
	 */
	public Map queryCityNameMap(String locale) throws SvcException;

}
