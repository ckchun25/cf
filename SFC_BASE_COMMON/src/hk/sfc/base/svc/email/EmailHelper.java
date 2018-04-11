package hk.sfc.base.svc.email;

import hk.sfc.base.domain.email.Email;
import hk.sfc.base.exception.SvcException;

import java.util.List;
/**
 * 
 * Email Helper Service interface
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>08/06/2009</TD><TD>kmfong</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface EmailHelper {

	/**
	 * Get email by Id
	 * @param id email id
	 * @return email with specified id
	 * @throws SvcException Service exception
	 */
	public Email retrieve(Long id) throws SvcException;

	/**
	 * Get email by email status 
	 * @param status email status
	 * @return list of email with specified status
	 * @throws SvcException Service exception
	 */
	public List queryIdByStatus(String status) throws SvcException;
	
	/**
	 * Get payment email by Id
	 * @param id email id
	 * @return email with specified id
	 * @throws SvcException Service exception
	 */
	public Email retrievePaymentMail(Long id) throws SvcException;

	/**
	 * Get payment email by email status 
	 * @param status email status
	 * @return list of email with specified status
	 * @throws SvcException Service exception
	 */
	public List queryIdByStatusForPayment(String status) throws SvcException;

}
