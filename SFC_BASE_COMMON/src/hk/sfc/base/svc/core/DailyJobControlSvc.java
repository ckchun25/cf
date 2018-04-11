package hk.sfc.base.svc.core;

import hk.sfc.base.exception.SvcException;

import java.util.Date;

/**
 *  Daily job control entity service interface.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/04/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */

public interface DailyJobControlSvc {

	/**
	 * Query application mode
	 * 
	 * @return application mode
	 * @throws SvcException
	 */
	public String queryApplnMode() throws SvcException;

	/**
	 * Query application date

	 * @return application date
	 * @throws SvcException
	 */
	public Date queryApplnDate() throws SvcException;

	/**
	 * Query next process date
	 * 
	 * @return next process date
	 * @throws SvcException
	 */
	public Date queryNextProcessDate() throws SvcException;
	
}
