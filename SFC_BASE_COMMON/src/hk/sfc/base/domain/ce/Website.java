package hk.sfc.base.domain.ce;

import java.util.Date;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Website domain object.
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
public class Website extends SfcDomainObject {

	private static final long serialVersionUID = 5945124958775586826L;

	/** website */
	private String website;

	/** website description */
	private String websiteDesc;

	/** effective date */
	private Date effectiveDate;

	
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	
	/**
	 * @return the websiteDesc
	 */
	public String getWebsiteDesc() {
		return websiteDesc;
	}

	
	/**
	 * @param websiteDesc the websiteDesc to set
	 */
	public void setWebsiteDesc(String websiteDesc) {
		this.websiteDesc = websiteDesc;
	}

	
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}