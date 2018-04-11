package hk.sfc.base.svc.template;

import hk.sfc.base.exception.SvcException;

import java.util.Map;

/**
 * 
 * Use Velocity to merge the template Service Interface
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>06/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * </TABLE>
 *
 */
public interface VelocityMergingSvc {
	
	public final static String DATA_CONTENT = "Content";
	public final static String TITLE = "Title";

	/**
	 * Merge template content by Velocity 
	 * <ol>
	 * <li>Get the Template content by template name and version </li>
	 * <li>merge template content and data by velocity</li>
	 * <li>merge template title and title map data by velocity</li>
	 * <li>put merged template content and merged template title into map</li>
	 * </ol>
	 * @param tmplName Template Name
	 * @param version Version No
	 * @param data Content Data Map
	 * @param titleMap Title Data Map
	 * @return Map merged content map 
	 * @throws SvcException Service Exception
	 */
	public Map merge(String tmplName, Long version, Map data, Map titleMap) throws SvcException;
		
	/**
	 * Merge template content by Velocity 
	 * <ol>
	 * <li>Get the Template content by template name and latest version </li>
	 * <li>merge template content and data by velocity</li>
	 * <li>merge template title and title map data by velocity</li>
	 * <li>put merged template content and merged template title into map</li>
	 * </ol>
	 * @param tmplName Template Name
	 * @param data Content Data Map
	 * @param titleMap Title Data Map
	 * @return Map merged content map 
	 * @throws SvcException Service Exception
	 */
	public Map merge(String tmplName, Map data, Map titleMap) throws SvcException;
}
