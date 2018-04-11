package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcErrorMessage;

/**
 * Authentication Exception that should be thrown when the authentication is failed.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>20/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class AuthenticationException extends SfcCheckedException {

	private String loginName;

	private String reason;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6238480021082038948L;

	/**
	 * Construct a AuthenticationException where login name and the reason will be the argument of LicErrorMessage.
	 * @param errMsg
	 */
	public AuthenticationException(SfcErrorMessage errMsg, String loginName, String reason) {

		super(errMsg.withArgs(new Object[] { loginName, reason }));
		setLoginName(loginName);
		setReason(reason);

	}

	/**
	 * getter method of loginName
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * setter method of loginName
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * getter method of reason
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * setter method of reason
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
