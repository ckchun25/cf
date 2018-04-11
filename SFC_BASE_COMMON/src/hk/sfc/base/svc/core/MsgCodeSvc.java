package hk.sfc.base.svc.core;

import hk.sfc.base.domain.message.MessageCode;
import hk.sfc.base.exception.SvcException;

import java.util.List;
import java.util.Map;

/**
 * Message code entity service interface.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>18/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>25/03/2009</TD><TD>Richard Shiu</TD><TD>Add retrieveMap method</TD></TR>
 * <TR><TD>ASR15816</TD><TD>24/12/2009</TD><TD>Richard Shiu</TD><TD>Add retrieveWithDefault.</TD></TR>
 * </TABLE>
 *
 */

public interface MsgCodeSvc {

	/**
	 * Retrieve message code by given locale
	 * 
	 * @param type message type
	 * @param code message code
	 * @param subCode message subcode
	 * @param locale locale
	 * @return message code value
	 * @throws SvcException Service exception
	 */

	public String retrieve(String type, String code, String subCode, String locale)
			throws SvcException;

	/**
	 * Retrieve message code by default locale
	 * 
	 * @param type message type
	 * @param code message code
	 * @param subCode message subcode
	 * @return message code value
	 * @throws SvcException Service exception
	 */
	public String retrieve(String type, String code, String subCode) throws SvcException;

	/**
	 * Retrieve list of message code by type and code
	 * @param type message type
	 * @param code message code
	 * @return list of message code
	 * @throws SvcException service exception
	 */
	public List retrieve(String type, String code) throws SvcException;

	/**
	 * Create message code
	 * 
	 * @param msgCode message code to be inserted
	 * @throws SvcException service exception
	 */
	public void insert(MessageCode msgCode) throws SvcException;

	/**
	 * Update message code
	 * 
	 * @param msgCode message code to be updated
	 * @throws SvcException service exception
	 */
	public int update(MessageCode msgCode) throws SvcException;

	/**
	 * Delete message code
	 * 
	 * @param type message type
	 * @param code message code
	 * @param subCode message subcode
	 * @throws SvcException service exception
	 */
	public int delete(String type, String code, String subCode) throws SvcException;

	/**
	 * Retrieve message code by type and code.
	 * @param type message type
	 * @param code message code
	 * @param locale
	 * @return Map code map table
	 * @throws SvcException service exception
	 */
	public Map retrieveMap(String type, String code, String locale) throws SvcException;
	
	/**
	 * Retrieve list of message code with type = 'COMMON' and CODE = 'CE_CLS_SHR' by ceref
	 * @param ceref central entity
	 * @return list of message code
	 * @throws SvcException service exception
	 */
	public List retrieveNewShareClassByCeref(String ceref) throws SvcException;

	/**
	 * Retrieve list of message code by type and code with the default value "ALL".
	 * @param type message type
	 * @param code message code
	 * @return list of message code
	 * @throws SvcException service exception
	 */
	public List retrieveWithDefault(String type, String code) throws SvcException;
}
