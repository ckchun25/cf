package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

/**
 *  Relation type domain object.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>28/04/2009</TD><TD>kmfong</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class RelationType extends SfcDomainObject {

	private static final long serialVersionUID = -6690235688553201049L;

	private String relCode;
	private String oppRelCode;
	private String reqStsGpCode;
	private String reqStsGpStatus;
	private String reqStsGpText;
	private String reqStsGpNumber;
	private String reqStsGpValue;
	private String checkStsGpCode;
	private String checkStsGpStatus;
	private String relHardSoftInd;
	private String relCodeDesc;
	private String labelStsGpCode;
	private String labelStsGpStatus;
	private String labelStsGpText;
	private String labelStsGpNumber;
	private String labelStsGpValue;
	
	/**
	 * @return the relCode
	 */
	public String getRelCode() {
		return relCode;
	}
	
	/**
	 * @param relCode the relCode to set
	 */
	public void setRelCode(String relCode) {
		this.relCode = relCode;
	}
	
	/**
	 * @return the oppRelCode
	 */
	public String getOppRelCode() {
		return oppRelCode;
	}
	
	/**
	 * @param oppRelCode the oppRelCode to set
	 */
	public void setOppRelCode(String oppRelCode) {
		this.oppRelCode = oppRelCode;
	}
	
	/**
	 * @return the reqStsGpCode
	 */
	public String getReqStsGpCode() {
		return reqStsGpCode;
	}
	
	/**
	 * @param reqStsGpCode the reqStsGpCode to set
	 */
	public void setReqStsGpCode(String reqStsGpCode) {
		this.reqStsGpCode = reqStsGpCode;
	}
	
	/**
	 * @return the reqStsGpStatus
	 */
	public String getReqStsGpStatus() {
		return reqStsGpStatus;
	}
	
	/**
	 * @param reqStsGpStatus the reqStsGpStatus to set
	 */
	public void setReqStsGpStatus(String reqStsGpStatus) {
		this.reqStsGpStatus = reqStsGpStatus;
	}
	
	/**
	 * @return the reqStsGpText
	 */
	public String getReqStsGpText() {
		return reqStsGpText;
	}
	
	/**
	 * @param reqStsGpText the reqStsGpText to set
	 */
	public void setReqStsGpText(String reqStsGpText) {
		this.reqStsGpText = reqStsGpText;
	}
	
	/**
	 * @return the reqStsGpNumber
	 */
	public String getReqStsGpNumber() {
		return reqStsGpNumber;
	}
	
	/**
	 * @param reqStsGpNumber the reqStsGpNumber to set
	 */
	public void setReqStsGpNumber(String reqStsGpNumber) {
		this.reqStsGpNumber = reqStsGpNumber;
	}
	
	/**
	 * @return the reqStsGpValue
	 */
	public String getReqStsGpValue() {
		return reqStsGpValue;
	}
	
	/**
	 * @param reqStsGpValue the reqStsGpValue to set
	 */
	public void setReqStsGpValue(String reqStsGpValue) {
		this.reqStsGpValue = reqStsGpValue;
	}
	
	/**
	 * @return the checkStsGpCode
	 */
	public String getCheckStsGpCode() {
		return checkStsGpCode;
	}
	
	/**
	 * @param checkStsGpCode the checkStsGpCode to set
	 */
	public void setCheckStsGpCode(String checkStsGpCode) {
		this.checkStsGpCode = checkStsGpCode;
	}
	
	/**
	 * @return the checkStsGpStatus
	 */
	public String getCheckStsGpStatus() {
		return checkStsGpStatus;
	}
	
	/**
	 * @param checkStsGpStatus the checkStsGpStatus to set
	 */
	public void setCheckStsGpStatus(String checkStsGpStatus) {
		this.checkStsGpStatus = checkStsGpStatus;
	}
	
	/**
	 * @return the relHardSoftInd
	 */
	public String getRelHardSoftInd() {
		return relHardSoftInd;
	}
	
	/**
	 * @param relHardSoftInd the relHardSoftInd to set
	 */
	public void setRelHardSoftInd(String relHardSoftInd) {
		this.relHardSoftInd = relHardSoftInd;
	}
	
	/**
	 * @return the relCodeDesc
	 */
	public String getRelCodeDesc() {
		return relCodeDesc;
	}
	
	/**
	 * @param relCodeDesc the relCodeDesc to set
	 */
	public void setRelCodeDesc(String relCodeDesc) {
		this.relCodeDesc = relCodeDesc;
	}
	
	/**
	 * @return the labelStsGpCode
	 */
	public String getLabelStsGpCode() {
		return labelStsGpCode;
	}
	
	/**
	 * @param labelStsGpCode the labelStsGpCode to set
	 */
	public void setLabelStsGpCode(String labelStsGpCode) {
		this.labelStsGpCode = labelStsGpCode;
	}
	
	/**
	 * @return the labelStsGpStatus
	 */
	public String getLabelStsGpStatus() {
		return labelStsGpStatus;
	}
	
	/**
	 * @param labelStsGpStatus the labelStsGpStatus to set
	 */
	public void setLabelStsGpStatus(String labelStsGpStatus) {
		this.labelStsGpStatus = labelStsGpStatus;
	}
	
	/**
	 * @return the labelStsGpText
	 */
	public String getLabelStsGpText() {
		return labelStsGpText;
	}
	
	/**
	 * @param labelStsGpText the labelStsGpText to set
	 */
	public void setLabelStsGpText(String labelStsGpText) {
		this.labelStsGpText = labelStsGpText;
	}
	
	/**
	 * @return the labelStsGpNumber
	 */
	public String getLabelStsGpNumber() {
		return labelStsGpNumber;
	}
	
	/**
	 * @param labelStsGpNumber the labelStsGpNumber to set
	 */
	public void setLabelStsGpNumber(String labelStsGpNumber) {
		this.labelStsGpNumber = labelStsGpNumber;
	}
	
	/**
	 * @return the labelStsGpValue
	 */
	public String getLabelStsGpValue() {
		return labelStsGpValue;
	}
	
	/**
	 * @param labelStsGpValue the labelStsGpValue to set
	 */
	public void setLabelStsGpValue(String labelStsGpValue) {
		this.labelStsGpValue = labelStsGpValue;
	}


}