package hk.sfc.base.utils;

import hk.sfc.base.constant.BaseConstant;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Utilities for locale operations.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>01/12/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>04/12/2009</TD><TD>Edmund Fong</TD><TD>Update javadoc</TD></TR>
 * </TABLE>
 *
 */
public class LocaleUtils {

	private static final Log logger = LogFactory.getLog(LocaleUtils.class);

	/**
	 * Return preferred language of the user served by the current request thread.
	 */
	public static String getLanguage() {
		Locale _locale = LocaleContextHolder.getLocale();
		String _lang = "";
		if (_locale != null && _locale.getLanguage() != null) {
			_lang = _locale.getLanguage();
		} else {
			_lang = BaseConstant.LANG_EN;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("language: " + _lang);
		}
		return _lang;
	}
}