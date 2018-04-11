package hk.sfc.base.domain.core;

/**
 * This stores environment information.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>25/02/2011</TD><TD>lcktong1</TD><TD>Initial version based on P2B</TD></TR>
 * </TABLE>
 *
 */
public class EnvironmentInfo {

	private String tagVersionNumber;

	/** The full host path include the port number if any. e.g. https://sfc.org.hk:923 */
	private String hostPath;

	private boolean debug;

	/**
	 * getter method of tagVersionNumber
	 * @return the tagVersionNumber
	 */
	public String getTagVersionNumber() {
		return tagVersionNumber;
	}

	/**
	 * setter method of tagVersionNumber
	 * @param tagVersionNumber the tagVersionNumber to set
	 */
	public void setTagVersionNumber(String tagVersionNumber) {
		this.tagVersionNumber = tagVersionNumber;
	}

	/**
	 * setter method of hostPath
	 * @param hostPath the hostPath to set
	 */
	public void setHostPath(String hostPath) {
		this.hostPath = hostPath;
	}

	/**
	 * getter method of hostPath
	 * @return the hostPath
	 */
	public String getHostPath() {
		return hostPath;
	}

	/**
	 * setter method of debug
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * check isDebug
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

}
