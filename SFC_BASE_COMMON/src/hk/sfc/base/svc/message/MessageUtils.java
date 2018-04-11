package hk.sfc.base.svc.message;

import hk.sfc.base.utils.LocaleUtils;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;

/**
 *  Utility class for getting message from message source.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class MessageUtils implements MessageSourceAware {

	private static MessageSource msgSource;

	/* (non-Javadoc) Interface Method */
	public void setMessageSource(MessageSource messageSource) {

		msgSource = messageSource;
	}

	/**
	 * Get the message from default MessageSource.
	 * 
	 * @param resolvable	the MessageSourceResolvable.
	 * @param locale	the Locale object.
	 * @return	a resolved message.
	 */
	public static String getMessage(MessageSourceResolvable resolvable, Locale locale) {
		return getMessage(null, resolvable, locale);
	}

	/**
	 * Get the message by the input MessageSource if it is not null.
	 * Otherwise, use the default MessageSource. If both are not found, return the MessageSourceResolvable.toString().
	 * 
	 * @param msgSrc	the MessageSource.
	 * @param resolvable	the MessageSourceResolvable.
	 * @param locale	the Locale object.
	 * @return	a resolved message.
	 */
	public static String getMessage(MessageSource msgSrc, MessageSourceResolvable resolvable,
			Locale locale) {
		if (msgSrc != null) {
			return msgSrc.getMessage(resolvable, locale);
		}
		if (msgSource != null) {
			return msgSource.getMessage(resolvable, locale);
		}

		return ("No message Source Defined. The MessageSourceResolvable is " + resolvable);
	}
	
	/**
	 * getMessageByCode
	 * @param code
	 * @return
	 */
	public static String getMessageByCode(String code){
		return getMessageByCode(code, LocaleUtils.getLanguage());
	}
	/**
	 * getMessageByCode
	 * @param code
	 * @param language
	 * @return
	 */
	public static String getMessageByCode(String code, String language){
		return msgSource.getMessage(code, null, new Locale(language));
	}
}
