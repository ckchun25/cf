package hk.sfc.base.svc;

import hk.sfc.base.security.ContextUtils;
import hk.sfc.base.security.SfcAppUserProfile;
import hk.sfc.base.svc.transaction.SfcTranSvc;

/**
 *  Service support class which provide SecurityProfile for usage.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcSvcSupport implements SfcTranSvc {
	
	/**
	 * Get a SecurityProfile.
	 * @return	a SecurityProfile.
	 */
	protected SfcAppUserProfile getSfcAppProfile() {
		
		return ContextUtils.getAppUserProfile();
	}

}
