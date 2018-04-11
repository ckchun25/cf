package hk.sfc.base.domain.email;

import java.io.Serializable;

/**
 * 
 * Email POJO - lp_t_email_spools
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>08/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class EmailAttachment implements Serializable {

	/**
	 *  Generated Serial Version ID
	 */
	private static final long serialVersionUID = -9160819541275182522L;

	//Attachment fileName which will be received in the email 
	private String fileName;

	// Attachment inputStream content
	private byte[] content;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

}