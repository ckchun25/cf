/**
 * 
 */
package hk.sfc.base.svc.core;

import hk.sfc.base.domain.ce.ActivityType;

import java.util.List;


/**
 * Regulated Activity Service
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR15816</TD><TD>16/12/2009</TD><TD>Cris Wong</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface RegulatedActivitySvc {

	/**
	 * Query all the activity types.
	 * queryRegulatedActivities
	 * @return list of regulated activities
	 * @throws Exception
	 */
	public List<ActivityType> queryAllActivityTypes() throws Exception;
}
