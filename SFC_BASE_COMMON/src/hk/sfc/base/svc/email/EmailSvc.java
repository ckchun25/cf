package hk.sfc.base.svc.email;

import hk.sfc.base.exception.SvcException;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.MailSendException;

/**
 * 
 *  Email Service Interface.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * </TABLE>
 *
 */
public interface EmailSvc {

	/**
	 * Send Email with :
	 * <ol>
	 * <li>default sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * </ol>
	 * @param address Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String[] address, String subject, String data) throws SvcException;

	/**
	 * Send Email with :
	 * <ol>
	 * <li>specific sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * </ol>
	 * @param fromAddress Sender Address 
	 * @param address Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String fromAddress, String[] address, String subject, String data)
			throws SvcException;

	/**
	 * Send Email with :
	 * <ol>
	 * <li>default sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Multiple BCC receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * </ol>
	 * @param address Receiver Address
	 * @param bccAddress BCC Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String[] address, String[] bccAddress, String subject, String data)
			throws SvcException;

	/**
	 * Send Email with :
	 * <ol>
	 * <li>specific sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Multiple BCC receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * </ol>
	 * @param fromAddress Sender Address
	 * @param address Receiver Address
	 * @param bccAddress BCC Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String fromAddress, String[] address, String[] bccAddress, String subject,
			String data) throws SvcException;

	/**
	* Send Email with :
	 * <ol>
	 * <li>default sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * <li>List of Attachments</li>
	 * </ol>
	 * @param address Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @param attachements Email Attachments
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String[] address, String subject, String data, List attachements)
			throws SvcException;

	/**
	 * Send Email with :
	 * <ol>
	 * <li>specific sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * <li>List of Attachments</li>
	 * </ol>
	 * @param fromAddress Sender Address
	 * @param address Receiver Address
	 * @param subject Email Subject 
	 * @param data Email Content Data
	 * @param attachements Email Attachments
	 * @throws SvcException Service Exception
	 */
	public void sendMail(String fromAddress, String[] address, String subject, String data,
			List attachements) throws SvcException;

	/**
	 * Global Method to send email
	 * Send Email with :
	 * <ol>
	 * <li>Specific sender Address</li>
	 * <li>Multiple receiver Address</li>
	 * <li>Multiple BCC receiver Address</li>
	 * <li>Email Subject</li>
	 * <li>Email Data</li>
	 * <li>List of Attachments</li>
	 * </ol>
	 * Remarks: 
	 * <ol>
	 * <li>Remove invalid receiver Address and  BCC receiver Address</li>
	 * <li>Audit Log will be created</li>
	 * </ol>
	 * 
	 * @param fromAddress Sender Address
	 * @param address Receiver Address
	 * @param bccAddress BCC Receiver Address
	 * @param subject Email Subject
	 * @param data Email content Data
	 * @param attachments Email Attachments
	 * @throws SvcException Service Exception
	 * @throws MessagingException when MimeMessageHelper setup is failure
	 * @throws MailSendException when the Mail Server cannot be connected
	 */
	public void sendMail(String fromAddress, String[] address, String[] bccAddress, String subject, String data,
			List attachements) throws SvcException;

	public void sendMail(String fromAddress, String[] address, String[] ccAddress, String[] bccAddress, 
			String subject, String data) throws SvcException;
	
	public void sendMail(String fromAddress, String[] address, String[] ccAddress, String[] bccAddress, 
			String subject, String data, List attachements) throws SvcException;
	
}