package hk.sfc.base.svc.syscode;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.domain.syscode.Holiday;
import hk.sfc.base.exception.SvcException;

import java.util.Date;
import java.util.List;


/**
 * Holiday entity service interface.
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
public interface HolidaySvc {

	/**
	 * Query public holidays.
	 * @param holiday criteria of this query
	 * @param paginationQuery pagination information
	 * @return the PageResult with list of holiday objects
	 * @throws SvcException Service exception
	 */
	public PageResult paginatePublicHoliday(Holiday holiday, PaginationQuery paginationQuery) throws SvcException;

	/**
	 * Count number of holidays within the date range.
	 * @param startDate the start date of the range
	 * @param endDate the end date of the range
	 * @return the count of holidays within the date range.
	 * @throws SvcException Service exception
	 */
	public Integer retrieveHolidayCount(Date startDate, Date endDate) throws SvcException;

	/**
	 * Query holidays before and after 30 days of the reference date.
	 * @param refDate reference date
	 * @return the list of holidays before and after 30 days of the reference date.
	 * @throws SvcException Service exception
	 */
	public List retrieveHolidayDate(Date refDate) throws SvcException;

}
