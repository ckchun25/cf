package hk.sfc.base.svc.transaction;

import hk.sfc.base.exception.SfcRuntimeException;
import hk.sfc.base.security.SfcAppUserProfile;

/**
 *  It provides transaction operation. 
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>07/Apr/2010</TD><TD>khyip1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface TransactionSvc {

	/**
	 * Open the transaction by using the SecurityProfile. 
	 * @param secProf	the SecurityProfile object.
	 * @return	LicTransactionHolder object.
	 * @throws LicRuntimeException
	 */
	public TransactionHolder openTransaction(SfcAppUserProfile secProf) throws SfcRuntimeException;
	
	/**
	 * Close the transaction. If the Exception is not null, it should rollback the transaction.
	 * @param holder	LicTransactionHolder object.
	 * @param ex	Exception class.
	 * @throws LicRuntimeException
	 */
	public void closeTransaction(TransactionHolder holder, Exception ex) throws SfcRuntimeException;
	
	
	
}
