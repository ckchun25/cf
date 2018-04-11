package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;
import hk.sfc.base.utils.NumberFormatter;

/**
 * Business Detail domain object.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>hywong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>03/11/2009</TD><TD>Edmund Fong</TD><TD>log 783: Portal - Profile - Display wrong financial year end of AE</TD></TR>
 * </TABLE>
 *
 */
public class BusinessDetail extends SfcDomainObject {

	private static final long serialVersionUID = 2419136767830055305L;

	/** business financial year end */
	private Long busFinYrEnd;

	/** business request no. */
	private String busRegNo;

	/** business inc date */
	private Date busIncDate;

	/** no. of staff full time */
	private int noStaffFulltime;

	/** no. of staff settle */
	private int noStaffSettle;

	/** no. of staff acct */
	private int noStaffAcct;

	/** no. of staff admin */
	private int noStaffAdmin;

	/** no. of staff trade */
	private int noStaffTrade;

	/** no. of staff other */
	private int noStaffOther;

	/** source of info */
	private String sourceOfInfo;

	/** limited info ind */
	private String limitedInfoInd;

	/** business nature */
	private String busNature;

	/** sub ind code */
	private String subIndCode;

	/** ind code */
	private String indcode;

	/** inc country code */
	private String incCountryCode;

	/** inc city code */
	private String incCityCode;

	/** ctl share country code */
	private String ctlShareCountryCode;

	/** entity subtype code */
	private String entitySubtypeCode;

	/** circular means */
	private String circularMeans;

	/**
	 * @return the busFinYrEnd
	 */
	public Long getBusFinYrEnd() {
		return busFinYrEnd;
	}

	/**
	 * @param busFinYrEnd the busFinYrEnd to set
	 */
	public void setBusFinYrEnd(Long busFinYrEnd) {
		this.busFinYrEnd = busFinYrEnd;
	}

	/**
	 * @return the busRegNo
	 */
	public String getBusRegNo() {
		return busRegNo;
	}

	/**
	 * @param busRegNo the busRegNo to set
	 */
	public void setBusRegNo(String busRegNo) {
		this.busRegNo = busRegNo;
	}

	/**
	 * @return the busIncDate
	 */
	public Date getBusIncDate() {
		return busIncDate;
	}

	/**
	 * @param busIncDate the busIncDate to set
	 */
	public void setBusIncDate(Date busIncDate) {
		this.busIncDate = busIncDate;
	}

	/**
	 * @return the noStaffFulltime
	 */
	public int getNoStaffFulltime() {
		return noStaffFulltime;
	}

	/**
	 * @param noStaffFulltime the noStaffFulltime to set
	 */
	public void setNoStaffFulltime(int noStaffFulltime) {
		this.noStaffFulltime = noStaffFulltime;
	}

	/**
	 * @return the noStaffSettle
	 */
	public int getNoStaffSettle() {
		return noStaffSettle;
	}

	/**
	 * @param noStaffSettle the noStaffSettle to set
	 */
	public void setNoStaffSettle(int noStaffSettle) {
		this.noStaffSettle = noStaffSettle;
	}

	/**
	 * @return the noStaffAcct
	 */
	public int getNoStaffAcct() {
		return noStaffAcct;
	}

	/**
	 * @param noStaffAcct the noStaffAcct to set
	 */
	public void setNoStaffAcct(int noStaffAcct) {
		this.noStaffAcct = noStaffAcct;
	}

	/**
	 * @return the noStaffAdmin
	 */
	public int getNoStaffAdmin() {
		return noStaffAdmin;
	}

	/**
	 * @param noStaffAdmin the noStaffAdmin to set
	 */
	public void setNoStaffAdmin(int noStaffAdmin) {
		this.noStaffAdmin = noStaffAdmin;
	}

	/**
	 * @return the noStaffTrade
	 */
	public int getNoStaffTrade() {
		return noStaffTrade;
	}

	/**
	 * @param noStaffTrade the noStaffTrade to set
	 */
	public void setNoStaffTrade(int noStaffTrade) {
		this.noStaffTrade = noStaffTrade;
	}

	/**
	 * @return the noStaffOther
	 */
	public int getNoStaffOther() {
		return noStaffOther;
	}

	/**
	 * @param noStaffOther the noStaffOther to set
	 */
	public void setNoStaffOther(int noStaffOther) {
		this.noStaffOther = noStaffOther;
	}

	/**
	 * @return the sourceOfInfo
	 */
	public String getSourceOfInfo() {
		return sourceOfInfo;
	}

	/**
	 * @param sourceOfInfo the sourceOfInfo to set
	 */
	public void setSourceOfInfo(String sourceOfInfo) {
		this.sourceOfInfo = sourceOfInfo;
	}

	/**
	 * @return the limitedInfoInd
	 */
	public String getLimitedInfoInd() {
		return limitedInfoInd;
	}

	/**
	 * @param limitedInfoInd the limitedInfoInd to set
	 */
	public void setLimitedInfoInd(String limitedInfoInd) {
		this.limitedInfoInd = limitedInfoInd;
	}

	/**
	 * @return the busNature
	 */
	public String getBusNature() {
		return busNature;
	}

	/**
	 * @param busNature the busNature to set
	 */
	public void setBusNature(String busNature) {
		this.busNature = busNature;
	}

	/**
	 * @return the subIndCode
	 */
	public String getSubIndCode() {
		return subIndCode;
	}

	/**
	 * @param subIndCode the subIndCode to set
	 */
	public void setSubIndCode(String subIndCode) {
		this.subIndCode = subIndCode;
	}

	/**
	 * @return the indcode
	 */
	public String getIndcode() {
		return indcode;
	}

	/**
	 * @param indcode the indcode to set
	 */
	public void setIndcode(String indcode) {
		this.indcode = indcode;
	}

	/**
	 * @return the incCountryCode
	 */
	public String getIncCountryCode() {
		return incCountryCode;
	}

	/**
	 * @param incCountryCode the incCountryCode to set
	 */
	public void setIncCountryCode(String incCountryCode) {
		this.incCountryCode = incCountryCode;
	}

	/**
	 * @return the incCityCode
	 */
	public String getIncCityCode() {
		return incCityCode;
	}

	/**
	 * @param incCityCode the incCityCode to set
	 */
	public void setIncCityCode(String incCityCode) {
		this.incCityCode = incCityCode;
	}

	/**
	 * @return the ctlShareCountryCode
	 */
	public String getCtlShareCountryCode() {
		return ctlShareCountryCode;
	}

	/**
	 * @param ctlShareCountryCode the ctlShareCountryCode to set
	 */
	public void setCtlShareCountryCode(String ctlShareCountryCode) {
		this.ctlShareCountryCode = ctlShareCountryCode;
	}

	/**
	 * @return the entitySubtypeCode
	 */
	public String getEntitySubtypeCode() {
		return entitySubtypeCode;
	}

	/**
	 * @param entitySubtypeCode the entitySubtypeCode to set
	 */
	public void setEntitySubtypeCode(String entitySubtypeCode) {
		this.entitySubtypeCode = entitySubtypeCode;
	}

	/**
	 * @return the circularMeans
	 */
	public String getCircularMeans() {
		return circularMeans;
	}

	/**
	 * @param circularMeans the circularMeans to set
	 */
	public void setCircularMeans(String circularMeans) {
		this.circularMeans = circularMeans;
	}

	public String getFinancialYearEnd() {
		if (busFinYrEnd == null || busFinYrEnd.intValue() <= 100 || busFinYrEnd.intValue() >= 10000) {
			return null;
		} else {
			String _s = NumberFormatter.format("0000", busFinYrEnd.intValue());
			return _s.substring(0, 2) + "/" + _s.substring(2);
		}
	}
}