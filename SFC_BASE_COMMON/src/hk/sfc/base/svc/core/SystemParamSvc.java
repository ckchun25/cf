package hk.sfc.base.svc.core;

import hk.sfc.base.domain.syscode.SystemParam;
import hk.sfc.base.exception.SvcException;

import java.util.List;

/**
 *  System param entity service interface.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>12/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */

public interface SystemParamSvc {

	/**
	 * Get the system parameter value by type and code
	 * @param type system parameter type
	 * @param code system parameter code
	 * @return system parameter value
	 * @throws SvcException Service exception
	 */
	public String retrieve(String applnCode, String type, String code) throws SvcException;

	/**
	 * Get list of system parameter value by type
	 * @param type system parameter type
	 * @return list of system parameter value
	 * @throws SvcException Service exception
	 */
	public List queryByType(String applnCode, String type) throws SvcException;

	/**
	 * Insert system parameter
	 * @param systemParam system parameter to be inserted
	 * @throws SvcException Service exception
	 */
	public void insert(SystemParam systemParam) throws SvcException;

	/**
	 * Update system parameter
	 * @param systemParam system parameter to be updated
	 * @throws SvcException Service exception
	 */
	public int update(SystemParam systemParam) throws SvcException;

	/**
	 * Delete system parameter
	 * @param type system parameter type
	 * @param code system parameter code
	 * @throws SvcException Service exception
	 */
	public int delete(String applnCode, String type, String code) throws SvcException;
}
