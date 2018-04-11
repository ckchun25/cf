package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;
import hk.sfc.base.utils.EncodeHelper;

/**
 * Back Account domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>03/05/2009</TD><TD>Richard Shiu</TD><TD>Added more attributes</TD></TR>
 * </TABLE>
 *
 */
public class BankAccount extends SfcDomainObject {

	private static final long serialVersionUID = 3846539370839346708L;

	/** Owner of the bank account. */
	private CentralEntity centralEntity;

	/** Bank. */
	private Bank bank;

	/** Bank account number. */
	private String bankAccNumber;

	/** Bank account type. */
	private String bankAccType;

	/** Bank account trust status. */
	private String bankAccTrustStatus;

	/** Bank account date opened. */
	private Date bankAccDateOpened;

	/** Bank account date closed. */
	private Date bankAccDateClosed;

	/**
	 * getter of bankAccNumber
	 * @return String
	 */
	public String getBankAccNumber() {
		return bankAccNumber;
	}

	/**
	 * getter of encoded bankAccNumber
	 * @return String
	 */
	public String getEncodedBankAccNumber() {
		return EncodeHelper.encode(bankAccNumber);
	}

	/**
	 * setter of bankAccNumber
	 * @param bankAccNumber
	 */
	public void setBankAccNumber(String bankAccNumber) {
		this.bankAccNumber = bankAccNumber;
	}

	/**
	 * getter of bankAccType
	 * @return String
	 */
	public String getBankAccType() {
		return bankAccType;
	}

	/**
	 * setter of bankAccType
	 * @param bankAccType
	 */
	public void setBankAccType(String bankAccType) {
		this.bankAccType = bankAccType;
	}

	/**
	 * getter of bankAccDateOpened
	 * @return Date
	 */
	public Date getBankAccDateOpened() {
		return bankAccDateOpened;
	}

	/**
	 * setter of bankAccDateOpened
	 * @param bankAccDateOpened
	 */
	public void setBankAccDateOpened(Date bankAccDateOpened) {
		this.bankAccDateOpened = bankAccDateOpened;
	}

	/**
	 * setter of bank
	 * @param bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/**
	 * getter of bank
	 * @return Bank
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * setter of bankAccTrustStatus
	 * @param bankAccTrustStatus
	 */
	public void setBankAccTrustStatus(String bankAccTrustStatus) {
		this.bankAccTrustStatus = bankAccTrustStatus;
	}

	/**
	 * getter of bankAccTrustStatus
	 * @return String
	 */
	public String getBankAccTrustStatus() {
		return bankAccTrustStatus;
	}

	/**
	 * setter of bankAccDateClosed
	 * @param bankAccDateClosed
	 */
	public void setBankAccDateClosed(Date bankAccDateClosed) {
		this.bankAccDateClosed = bankAccDateClosed;
	}

	/**
	 * getter of bankAccDateClosed
	 * @return Date
	 */
	public Date getBankAccDateClosed() {
		return bankAccDateClosed;
	}

	/**
	 * setter of centralEntity
	 * @param centralEntity
	 */
	public void setCentralEntity(CentralEntity centralEntity) {
		this.centralEntity = centralEntity;
	}

	/**
	 * getter of centralEntity
	 * @return CentralEntity
	 */
	public CentralEntity getCentralEntity() {
		return centralEntity;
	}
}