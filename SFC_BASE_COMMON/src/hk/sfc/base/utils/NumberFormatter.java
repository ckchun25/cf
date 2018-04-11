package hk.sfc.base.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * Number Formatter
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>14/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>16/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090716</TD></TR>
 * </TABLE>
 *
 */
public final class NumberFormatter {

	protected static Locale DEFAULT_LOCALE = Locale.ENGLISH;

	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private NumberFormatter() {
	}

	/**
	 * Format the no into default format
	 * @param loc locale(en or zh)
	 * @param data Data needed to format
	 * @return formatted data
	 */
	public synchronized static String format(Locale loc, double data) {
		NumberFormat _f = NumberFormat.getInstance(loc);
		if (_f instanceof DecimalFormat) {
			((DecimalFormat) _f).setDecimalSeparatorAlwaysShown(true);
		}
		return _f.format(data);
	}

	/**
	 * Format the no into default format and default locale
	 * @param data Data needed to format
	 * @return formatted data
	 */
	public synchronized static String format(double data) {
		return format(DEFAULT_LOCALE, data);
	}

	/**
	 * Format the no into specified pattern
	 * @param pattern Pattern which data want to format into
	 * @param data Data needed to format
	 * @return formatted data
	 */
	public synchronized static String format(String pattern, double data) {
		NumberFormat _f = NumberFormat.getInstance(DEFAULT_LOCALE);
		if (_f instanceof DecimalFormat) {
			((DecimalFormat) _f).applyPattern(pattern);
		}
		return _f.format(data);
	}
}
