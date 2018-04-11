package hk.sfc.base.svc.core;

import hk.sfc.base.exception.SvcException;

/**
 * Provide service related to EOD;
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/04/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface EODUtilSvc {

	/**
	 * Test whether EOD is running
	 * @return boolean
	 * @throws SvcException
	 */
	public boolean isEODRunning() throws SvcException;

	/**
	 * Test whether LICPORTAL is running
	 * @return boolean
	 * @throws SvcException
	 */
	public boolean isPortalRunning() throws SvcException;

}
