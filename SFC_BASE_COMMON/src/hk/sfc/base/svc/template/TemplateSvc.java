package hk.sfc.base.svc.template;

import hk.sfc.base.domain.template.Template;
import hk.sfc.base.exception.SvcException;

import java.util.List;


/**
 * 
 * Template Service Interface
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
public interface TemplateSvc {

	/**
	 * Insert template into lp_t_templates
	 * @param tmpl Template POJO
	 * @return long : Template Id
	 * @throws SvcException Service Exception
	 */
	public Long add(Template tmpl) throws SvcException;

	/**
	 * Delete record by template Id
	 * @param tmplId Template ID
	 * @throws SvcException Service Exception
	 */
	public void deleteByInternalKey(Long tmplId) throws SvcException;
	
	/**
	 * Delete record by template Name and version
	 * @param tmplName Template Name
	 * @param version Version No
	 * @throws SvcException Service Exception
	 */
	public void delete(String tmplName, Long version) throws SvcException;
	
	/**
	 * Retrieve template by template Name
	 * @param tmplName Template Name
	 * @return List Template List
	 * @throws SvcException Service Exception
	 */
	public List retrieve(String tmplName) throws SvcException;
	
	/**
	 * Retrieve Template by template details
	 * @param tmpl Template POJO
	 * @return List Template List
	 * @throws SvcException Service Exception
	 */
	public List retrieve(Template tmpl) throws SvcException;
	
	/**
	 * update Template record 
	 * @param tmpl Template POJO
	 * @throws SvcException Service Exception
	 */
	public void update(Template tmpl) throws SvcException;
	
	/**
	 * Get Sequence Number from LP_Q_TEMPLATE_NAME
	 * @return Long Seq No 
	 * @throws SvcException Service Exception
	 */
	public Long retrieveVelocitySeqNum() throws SvcException; 
}
