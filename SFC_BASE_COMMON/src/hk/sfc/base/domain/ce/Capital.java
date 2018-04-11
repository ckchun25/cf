package hk.sfc.base.domain.ce;

import java.math.BigDecimal;
import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Capital domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class Capital extends SfcDomainObject {

	private static final long serialVersionUID = 1558976261203954922L;

	/** ceref */
	private String ceref;

	/** share capital as a date */
	private Date shrCapitalAsADate;

	/** cls class */
	private String clsClass;

	/** currency code */
	private String currCode;

	/** share par value */
	private BigDecimal shrParValue;

	/** share share issued */
	private BigDecimal shrShareIssued;

	/** share auth capital */
	private BigDecimal shrAuthCapital;

	/** share issue capital */
	private BigDecimal shrIssueCapital;

	/** trade currency code */
	private String tradeCurrCode;

	/** share lot size */
	private BigDecimal shrLotSize;

	/** paid up capital */
	private BigDecimal paidUpCapital;

	/** premium paid */
	private BigDecimal premPaid;

	/**
	 * @return the ceref
	 */
	public String getCeref() {
		return ceref;
	}

	/**
	 * @param ceref the ceref to set
	 */
	public void setCeref(String ceref) {
		this.ceref = ceref;
	}

	/**
	 * @return the shrCapitalAsADate
	 */
	public Date getShrCapitalAsADate() {
		return shrCapitalAsADate;
	}

	/**
	 * @param shrCapitalAsADate the shrCapitalAsADate to set
	 */
	public void setShrCapitalAsADate(Date shrCapitalAsADate) {
		this.shrCapitalAsADate = shrCapitalAsADate;
	}

	/**
	 * @return the clsClass
	 */
	public String getClsClass() {
		return clsClass;
	}

	/**
	 * @param clsClass the clsClass to set
	 */
	public void setClsClass(String clsClass) {
		this.clsClass = clsClass;
	}

	/**
	 * @return the currCode
	 */
	public String getCurrCode() {
		return currCode;
	}

	/**
	 * @param currCode the currCode to set
	 */
	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	/**
	 * @return the shrParValue
	 */
	public BigDecimal getShrParValue() {
		return shrParValue;
	}

	/**
	 * @param shrParValue the shrParValue to set
	 */
	public void setShrParValue(BigDecimal shrParValue) {
		this.shrParValue = shrParValue;
	}

	/**
	 * @return the shrShareIssued
	 */
	public BigDecimal getShrShareIssued() {
		return shrShareIssued;
	}

	/**
	 * @param shrShareIssued the shrShareIssued to set
	 */
	public void setShrShareIssued(BigDecimal shrShareIssued) {
		this.shrShareIssued = shrShareIssued;
	}

	/**
	 * @return the shrAuthCapital
	 */
	public BigDecimal getShrAuthCapital() {
		return shrAuthCapital;
	}

	/**
	 * @param shrAuthCapital the shrAuthCapital to set
	 */
	public void setShrAuthCapital(BigDecimal shrAuthCapital) {
		this.shrAuthCapital = shrAuthCapital;
	}

	/**
	 * @return the shrIssueCapital
	 */
	public BigDecimal getShrIssueCapital() {
		return shrIssueCapital;
	}

	/**
	 * @param shrIssueCapital the shrIssueCapital to set
	 */
	public void setShrIssueCapital(BigDecimal shrIssueCapital) {
		this.shrIssueCapital = shrIssueCapital;
	}

	/**
	 * @return the tradeCurrCode
	 */
	public String getTradeCurrCode() {
		return tradeCurrCode;
	}

	/**
	 * @param tradeCurrCode the tradeCurrCode to set
	 */
	public void setTradeCurrCode(String tradeCurrCode) {
		this.tradeCurrCode = tradeCurrCode;
	}

	/**
	 * @return the shrLotSize
	 */
	public BigDecimal getShrLotSize() {
		return shrLotSize;
	}

	/**
	 * @param shrLotSize the shrLotSize to set
	 */
	public void setShrLotSize(BigDecimal shrLotSize) {
		this.shrLotSize = shrLotSize;
	}

	/**
	 * @return the paidUpCapital
	 */
	public BigDecimal getPaidUpCapital() {
		return paidUpCapital;
	}

	/**
	 * @param paidUpCapital the paidUpCapital to set
	 */
	public void setPaidUpCapital(BigDecimal paidUpCapital) {
		this.paidUpCapital = paidUpCapital;
	}

	/**
	 * @return the premPaid
	 */
	public BigDecimal getPremPaid() {
		return premPaid;
	}

	/**
	 * @param premPaid the premPaid to set
	 */
	public void setPremPaid(BigDecimal premPaid) {
		this.premPaid = premPaid;
	}
}