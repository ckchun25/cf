package hk.sfc.base.svc.transaction;

import org.springframework.transaction.TransactionStatus;

/**
 *  A simple holder to hold the TransactionStatus.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>07/Apr/2010</TD><TD>khyip1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class TransactionHolder {

	private int txnId = 1;
	private TransactionStatus txnStatus = null;
	
	/**
	 * Get the TransactionStatus.
	 * @return	a TransactionStatus.
	 */
	public TransactionStatus getTxnStatus() {
		return txnStatus;
	}

	/**
	 * Set the TransactionStatus.
	 * @param txnStatus	a TransactionStatus.
	 */
	public void setTxnStatus(TransactionStatus txnStatus) {
		this.txnStatus = txnStatus;
	}

	/**
	 * Get the transaction id
	 * @return the txnId
	 */
	public int getTxnId() {
		return txnId;
	}

	/**
	 * Set the transaction id
	 * @param txnId the txnId to set
	 */
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

}
