package hk.sfc.base.svc.jasper;

import hk.sfc.base.exception.SvcException;

import java.io.OutputStream;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * 
 * Jasper Report Svc Interface
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>04/05/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * </TABLE>
 *
 */
public interface JasperMergingSvc {

	/**
	 * Merge and Generate the Template by Jasper Service
	 * <ol>
	 * <li>Retrieve the Template content by TemplateSvc</li> 
	 * <li>merge the template content and given JRdataSource</li>
	 * <li>generate the outputStream</li>
	 * </ol>
	 * @param tmpl_name Template Name
	 * @param parameter Parameter data Map
	 * @param dataSource Jasper DataSource
	 * @param out OutputStream
	 * @throws SvcException Service Exception
	 */
	public void mergeAndGenerateBytePDF(String tmpl_name, Map parameter, JRDataSource dataSource,
			OutputStream out) throws SvcException;

	/**
	 * Merge and Generate the Template by Jasper Service
	 * <ol>
	 * <li>Retrieve the Template content by TemplateSvc</li> 
	 * <li>merge the template content and given JRdataSource</li>
	 * <li>generate byteArray pdf content and return</li>
	 * </ol>
	 * @param tmpl_name Template Name 
	 * @param parameter Parameter data Map
	 * @param dataSource Jasper DataSource
	 * @return byte[] PDF Content Byte Array 
	 * @throws SvcException Service Exception
	 */
	public byte[] mergeAndGenerateBytePDF(String tmpl_name, Map parameter, JRDataSource dataSource)
			throws SvcException;

    /**
     * This jasper return JasperPrint
     * @param tmpl_name
     * @param parameter
     * @param dataSource
     * @return
     * @throws SvcException
     */
	public JasperPrint merge(String tmpl_name, Map parameter, JRDataSource dataSource) throws SvcException;
	    
}
