package hk.sfc.base.security;

import hk.sfc.base.svc.transaction.TransactionHolder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.TransactionStatus;

/**
 * Utility class that manipulate the ContextHolder.
 *  
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ContextUtils implements ApplicationContextAware {
	
	private static final String CONTEXT_HOLDER_ID = "contextHolder";
	private static final Log logger = LogFactory.getLog(ContextUtils.class);

	private static ApplicationContext appCtx;

	/* (non-Javadoc) Interface Method */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}
	
	/**
	 * Get the ContextHolder.
	 * @return	a ContextHolder object
	 */
	public static ContextHolder getContextHolder() {
		return (ContextHolder)appCtx.getBean(CONTEXT_HOLDER_ID);
	}
	
	public static SfcAppUserProfile getAppUserProfile() {
		return getContextHolder().getAppUserProfile();
	}

	/**
	 * Set the SecurityProfile into ContextHolder.
	 * @param secProf
	 */
	public static void setAppUserProfile(SfcAppUserProfile appUsrProf) {
		getContextHolder().setAppUserProfile(appUsrProf);
	}
	
	public static TransactionHolder getTransactionHolder() {
		return getContextHolder().getTransactionHolder();
	}

	public static void setTransactionHolder(TransactionHolder tranHolder) {
		getContextHolder().setTransactionHolder(tranHolder);
	}
	
	public static void resetContextHolder() {
		resetContextHolder(true);
	}
	
	public static void resetContextHolder(boolean checkIsHolderEmpty) {
		ContextHolder _holder = (ContextHolder)appCtx.getBean(CONTEXT_HOLDER_ID);
		
		SfcAppUserProfile _profile = _holder.getAppUserProfile();
		if (checkIsHolderEmpty && _profile!=null) {
			logger.warn("Security Profile suppose be null in ContextHolder but an instance is found.");
		}
		
		TransactionHolder _tranHolder = _holder.getTransactionHolder();
		if (checkIsHolderEmpty && _tranHolder!=null) {
			logger.warn("Transaction Holder suppose be null in ContextHolder but an instance is found.");
		}
		
		_holder.setAppUserProfile(null);
		_holder.setTransactionHolder(null);
	}
	 
	/**
	 * Mark the transaction to be roll back. <p> 
	 * Be reminded that the real roll back action is not done in here and is processed by the TransactionManager.
	 * @return	true if the marking succeed, otherwise false.
	 */
	public static boolean setTransactionRollback() {

		TransactionHolder _txHolder = null;

		_txHolder = ContextUtils.getTransactionHolder();

		if (_txHolder != null) {
			TransactionStatus _ts = _txHolder.getTxnStatus();

			if (_ts != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("setRollbackOnly in TransactionStatus");
				}

				_ts.setRollbackOnly();
				return true;
			}
		}
		return false;
	}

	public static boolean isAuthorize(String objectCode) {
		SfcAppUserProfile _profile = getAppUserProfile();
		return _profile==null?false:_profile.isAuthorize(objectCode);
	}
}
