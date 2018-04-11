package hk.sfc.base.svc.email;

import hk.sfc.base.domain.email.Email;
import hk.sfc.base.exception.SvcException;

/**
 * 
 * Email Spool Service Interface
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>08/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14723</TD><TD>09/11/2009</TD><TD>Joyce</TD><TD>Send EOD mail immediately</TD></TR>
 * <TR><TD>ASR14723</TD><TD>07/01/2010</TD><TD>Froster Lau</TD><TD>Adding new method for Payment Mail spool</TD></TR>  
 * </TABLE>
 *
 */
public interface EmailSpoolSvc {
	
	/**
	 * Spool e-mail into lp_t_email_spools
	 * @param mailObj Email Object 
	 * @throws SvcException Service Exception
	 */
	public void spoolMail(Email mailObj) throws SvcException;
	
	/**
	 * Spool e-mail into lp_t_payment_email_spools
	 * @param mailObj Email Object 
	 * @throws SvcException Service Exception
	 */
	public void spoolPaymentMail(Email mailObj) throws SvcException;
	
	/**
	 * Send Spool Email
	 * <ol>
	 * <li>Get all Status N(New) from lp_t_email_spools</li>
	 * <li>Send email by EmailSvc </li>
	 * <li>Send Email Success, update status = S(Sent) in  lp_t_email_spools</li>
	 * <li>Send Email Success, update status = F(Fail) in  lp_t_email_spools </li>
	 * <li>Audit Log is created for each email spool record</li>
	 * </ol>
	 */
	public void sendMail() throws SvcException;
	
	/**
	 * Send Spool Email Payment
	 * <ol>
	 * <li>Get all Status N(New) from lp_t_email_spools_payment</li>
	 * <li>Send email by EmailSvc </li>
	 * <li>Send Email Success, update status = S(Sent) in  lp_t_email_spools_payment</li>
	 * <li>Send Email Success, update status = F(Fail) in  lp_t_email_spools_payment </li>
	 * <li>Audit Log is created for each email spool record</li>
	 * </ol>
	 */
	public void sendPaymentMail() throws SvcException;
	
	/**
	 * Send Mail then save into Spool Email table for record
	 * <ol>
	 * <li>Send email by EmailSvc </li>
	 * <li>Insert into lp_t_email_spools with status = S(Sent)</li>
	 * </ol>
	 */
	public void sendAndSpoolMail(Email mailObj) throws SvcException;
	
}
