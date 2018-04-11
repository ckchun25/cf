package hk.sfc.base.svc.core;

import hk.sfc.base.exception.SfcRuntimeException;

/**
 *  Provide service to manipulate the Global Temp Table.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>khyip1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface GlobalTempTableSvc {

	/**
	 * Get the anonymous user name. It would be used when loginName is not available.
	 * @return	the anonymous user name.
	 */
	public String getAnonymousUserName();

	/**
	 * Insert record in the global temp table with the login name.
	 * @param loginName	the login name of the user.
	 * @return	number of record inserted.
	 * @throws LicRuntimeException
	 */
	public void insert(String loginName) throws SfcRuntimeException;

	/**
	 * Delete all record in global temp table.
	 * @return	number of record deleted.
	 * @throws LicRuntimeException
	 */
	public int delete() throws SfcRuntimeException;

	/**
	 * Check whether the input login name exist in the global temp table.
	 * @param loginName	the login name of the user.
	 * @return true if the login name exist in the global temp table, otherwise false.
	 * @throws LicRuntimeException
	 */
	//public boolean isExist(String loginName) throws SfcRuntimeException;
}
