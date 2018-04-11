/**
 * 
 */
package hk.sfc.base.svc.utils;

import hk.sfc.base.exception.SvcException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * [Class Description]
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>&nbsp;</TD><TD>DD/MM/YYYY</TD><TD>mpkma1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface PrintQueueSvc {

	public static final String USER_ID = "userId";		
	public static final String USER_CEREF = "userCeref";
    public static final String REG_CEREF = "regCeref";
	public static final String TEMPLATE_ID = "tmplId";		
	public static final String DOC_XML = "docXML";
	public static final String APPLN_DATE = "applnDate";
	public static final String NEXT_PROCESS_DATE = "nextProcessDate";
	public static final String REGENERATE_PAYMENT_KEY_LETTER = "LETTER_LPU009";
	public static final String NEW_PAYMENT_KEY = "newPaymentKey";
	public static final String SFC_LINK = "sfcLink";
	public static final String FAQ_LINK = "faqLink";
	/**
	 * Add the print queue
	 * @param userCeref the user ceref
	 * @param tmplId the template ID
	 * @param docXML the XML document
	 * @param applnDate the application date
	 * @throws SvcException
	 */
	public void addPrintQueue(String userCeref, String tmplId, String docXML,
			Date applnDate) throws SvcException;
	/**
	 * Get the DocXML
	 * @param obj the parameter object
	 * @return A string which is the XML document
	 * @throws SvcException
	 */
	public String getDocXML(Map paramMap) throws SvcException;
	/**
	 * Get the address list
	 * @param regCeref the register ceref
	 * @param applnDate the application date
	 * @return list of address
	 * @throws SvcException
	 */
	public List<?> getAddressList(String regCeref, Date applnDate) throws SvcException;
}
