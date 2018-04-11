package hk.sfc.base.domain.ce;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * Contact information of a central entity.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>&nbsp;</TD><TD>01/09/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ContactInfo extends SfcDomainObject {

	private static final long serialVersionUID = -1446213471057787901L;

	/** Name of contact person. */
	private String name;

	/** Tel of contact person. */
	private String tel;

	/** Job title of contact person. */
	private String title;

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
}