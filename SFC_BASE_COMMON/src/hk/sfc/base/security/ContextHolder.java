package hk.sfc.base.security;

import hk.sfc.base.svc.transaction.TransactionHolder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  Implementation of the ContextHolder.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ContextHolder  {

	private static final Log logger = LogFactory.getLog(ContextHolder.class);

	private SfcAppUserProfile appUserProfile;
	private TransactionHolder transactionHolder;

	/* (non-Javadoc) Interface Method */
	public SfcAppUserProfile getAppUserProfile() {
		return appUserProfile;
	}

	/* (non-Javadoc) Interface Method */
	public void setAppUserProfile(SfcAppUserProfile appUsrProf) {
		appUserProfile = appUsrProf;
	}

	/* (non-Javadoc) Interface Method */
	public TransactionHolder getTransactionHolder() {
		return transactionHolder;
	}

	/* (non-Javadoc) Interface Method */
	public void setTransactionHolder(TransactionHolder holder) {
		transactionHolder = holder;
	}

}
