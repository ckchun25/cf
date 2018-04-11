package hk.sfc.base.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *  Utility class for date.
 *
 * Users should be cautious in their use of Timestamp objects and should not
 * assume that they are interchangeable with java.util.Date objects.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>12/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR15816</TD><TD>05/02/2010</TD><TD>Froster Lau</TD><TD>Added new function for calculate Date</TD></TR>
 * <TR><TD>ASR16468</TD><TD>09/04/2010</TD><TD>Froster Lau</TD><TD>P2A Enhancement</TD></TR>
 * <TR><TD>ASR16449</TD><TD>28/07/2010</TD><TD>Richard Shiu</TD><TD>Add getSystemDateString() for file name generation.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>09/08/2010</TD><TD>Tony Chan</TD><TD>Add DEFAULT_DATE_MONTH, DEFAULT_YEAR_PATTERN. Add formatYear() function.</TD></TR>
 * <TR><TD>ASR16449</TD><TD>30/09/2010</TD><TD>Richard Shiu</TD><TD>Add formatDmsDate().</TD></TR>
 * <TR><TD>ASR16449</TD><TD>01/11/2010</TD><TD>Patrick Yung</TD><TD>Add getCalendar(),getDate(),addSecound(),isBetween(),MAX_DATE,MIN_DATE</TD></TR>
 * <TR><TD>ASR16449</TD><TD>15/11/2010</TD><TD>Patrick Yung</TD><TD>UAA_DATE_PATTERN</TD></TR>
 * <TR><TD>ASR16449</TD><TD>22/11/2010</TD><TD>Richard Shiu</TD><TD>Add parseDmsDate() for DMS WS search document API.</TD></TR>
 * </TABLE>
 *
 */

public final class DateUtils {

	public static final String KEY = "DateUtils";

	/*
	 * Data pattern reference:
	 * http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html
	 */
	/** Default date format in dd/MM/yyyy */
	public static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";

	/** DMS date format. */
	public static final String DMS_DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

	/** User Access Audit Report date format. */
	public static final String UAA_DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

	/** Default date format in dd M yyyy */
	private static final String DEFAULT_LONG_DATE_PATTERN = "d MMMMM yyyy";

	/** Default time format HH:mm */
	public static final String DEFAULT_TIME_PATTERN = "HH:mm";

	/** time format dd/MM/yyyy HH:mm:ss.SSS */
	public static final String MINISEC_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss.SSS";
	
	private static Locale DEFAULT_LOCALE = Locale.US;

	/** Default timestamp format in dd/MM/yyyy HH:mm */
	public static final String DEFAULT_TIMESTAMP_PATTERN =
			DEFAULT_DATE_PATTERN + " " + DEFAULT_TIME_PATTERN;

	/** System date in string format */
	public static final String DEFAULT_SYSTEM_DATE_FORMAT = "yyyyMMddHHmmss";

	/** Default day/month constant when combing with year */
	public static final String DEFAULT_DAY_MONTH = "01/01/";

	/** Default date format in yyyy */
	public static final String DEFAULT_YEAR_PATTERN = "yyyy";

	/** Max Future Date*/
	public static final Date MAX_DATE = new Date(Long.MAX_VALUE);
	/** The first second of Date. January 1, 1970, 00:00:00 GMT */
	public static final Date MIN_DATE = new Date(0);

	// Utilities class cannot be created
	private DateUtils() {
	}

	/**
	 * Create a DateUtils instance which is only used for special case. (e.g. Putting a class object into map for Velocity to use.)
	 * In normal situation, should use static method calling. 
	 * @return DateUtils
	 */
	public static DateUtils getInstance() {
		return new DateUtils();
	}

	/**
	 * Get the system date
	 * @return java.util.Date
	 */
	public static Date getSystemDate() {
		return new Date();
	}

	/**
	 * Get the system timestamp
	 * @return java.sql.timestamp
	 */
	public static Timestamp getSystemTimestamp() {
		return toTimestamp(getSystemDate());
	}

	/**
	 * Get the system current year
	 * 
	 */
	public static String getCurrentYear() {
		return formatDate(getSystemDate(), "yyyy");
	}

	/**
	 * Get given date with default date format
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return formatDate(date, DEFAULT_DATE_PATTERN);
	}

	/**
	 * Get given date with DMS date format.
	 * @param date Formatted date
	 * @return date in DMS date format
	 */
	public static String formatDmsDate(Date date) {
		return formatDate(date, DMS_DATE_PATTERN);
	}

	/**
	 * Parse given date string with DMS date format.
	 * @param dateStr Date string in DMS date format
	 * @return Date Actual date
	 */
	public static Date parseDmsDate(String dateStr) {
		try {
			return parse(dateStr, DMS_DATE_PATTERN);
		} catch (ParseException _ex) {
			return null;
		}
	}

	/**
	 * Get given timestamp with default timestamp format
	 * @param timestamp
	 * @return String
	 */
	public static String formatTimestamp(Timestamp timestamp) {
		return formatTimestamp(timestamp, DEFAULT_TIMESTAMP_PATTERN);
	}

	/**
	 * Get given date with specified date format
	 * if date is null, return null; 
	 * if fmt  is null, default date pattern will be used;
	 * 
	 * @param date
	 * @param fmt
	 * @return String
	 */
	public static String formatDate(Date date, String fmt) {
		if (date == null) return null;
		return (fmt == null) ? format(date, DEFAULT_DATE_PATTERN) : format(date, fmt);
	}

	/**
	 * Get given timestamp with specified date format
	 * if timestamp is null, return null; 
	 * if fmt       is null, default timestamp pattern will be used;
	 * 
	 * @param timestamp
	 * @param fmt
	 * @return String
	 */
	public static String formatTimestamp(Timestamp timestamp, String fmt) {
		if (timestamp == null) return null;
		return (fmt == null) ? format(timestamp, DEFAULT_TIMESTAMP_PATTERN)
				: format(timestamp, fmt);
	}

	/**
	 * Get given dateStr with default date format
	 * @param gcDate
	 * @return String
	 */
	public static String parseDate(GregorianCalendar gcDate) throws ParseException {

		int dd = gcDate.get(GregorianCalendar.DAY_OF_MONTH);
		int mm = gcDate.get(GregorianCalendar.MONTH) + 1;
		int yyyy = gcDate.get(GregorianCalendar.YEAR);
		Date date = parseDate(dd + "/" + mm + "/" + yyyy);
		return formatDate(date, DEFAULT_DATE_PATTERN);
	}

	/**
	 * Parse given date with default date format
	 * @param dateStr date in String format
	 * @return Date
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		return parse(dateStr, DEFAULT_DATE_PATTERN);
	}

	/**
	 * Parse given timestamp with default timestamp format
	 * @param dateStr date in String format
	 * @return Timestamp
	 */
	public static Timestamp parseTimestamp(String timestampStr) throws ParseException {
		Date _date = parse(timestampStr, DEFAULT_TIMESTAMP_PATTERN);
		return toTimestamp(_date);
	}

	/**
	 * Convert date to timestamp
	 * @param date
	 * @return Timestamp
	 */
	public static Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * Convert timestamp to date
	 * @param timestamp
	 * @return Date
	 */
	public static Date toDate(Timestamp timestamp) {
		long _milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
		return new Date(_milliseconds);
	}

	/**
	 * Format given date with given date format
	 * @param date
	 * @param fmt
	 * @return String
	 */
	public static String format(Date date, String fmt) {
		// SimpleDateFormat is not thread-safety, create it every time
		return new SimpleDateFormat(fmt, DEFAULT_LOCALE).format(date);
	}

	/**
	 * Format given date with default time format.
	 * i.e. If date is "17/04/2009 23:13", it will return "23:13".
	 * @param date	the date object that will be formated.
	 * @return	the formatted time string.
	 */
	public static String formatTime(Date date) {
		return format(date, DEFAULT_TIME_PATTERN);
	}

	/**
	 * Parse given date string with given date format
	 * @param dateStr
	 * @param fmt
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parse(String dateStr, String fmt) throws ParseException {
		// SimpleDateFormat is not thread-safety, create it every time
		return new SimpleDateFormat(fmt, DEFAULT_LOCALE).parse(dateStr);
	}

	/**
	 * Compare two date object and return the earliest date
	 * @param date1
	 * @param date2
	 * @return earliest date
	 * @throws ParseException
	 */
	public static Date getEarliestDate(Date date1, Date date2) throws ParseException {
		Date _date = null;
		if (date1 != null && date2 != null) {
			if (date1.before(date2)) {
				_date = date1;
			} else {
				_date = date2;
			}
		} else if (date1 != null && date2 == null) {
			_date = date1;
		} else if (date1 == null && date2 != null) {
			_date = date2;
		}
		return _date;
	}

	/**
	 * Convert yyyyMMdd to Chinese character format
	 * 
	 * @return date in Chinese character format
	 */
	public static String date2chinese(String date) {

		StringBuffer sb = new StringBuffer();
		sb.append(getChinese(Integer.parseInt(date.substring(0, 1))));
		sb.append(getChinese(Integer.parseInt(date.substring(1, 2))));
		sb.append(getChinese(Integer.parseInt(date.substring(2, 3))));
		sb.append(getChinese(Integer.parseInt(date.substring(3, 4))));
		sb.append("年");

		String month1 = date.substring(4, 5);
		if (!"0".equals(month1)) {
			sb.append("十");
		}
		String month2 = date.substring(5, 6);
		if (!"0".equals(month2)) {
			sb.append(getChinese(Integer.parseInt(month2)));
		}
		sb.append("月");

		String day1 = date.substring(6, 7);
		if ("0".equals(day1)) {
			// nothing
		} else if ("1".equals(day1)) {
			sb.append("十");
		} else {
			sb.append(getChinese(Integer.parseInt(day1)));
			sb.append("十");
		}
		String day2 = date.substring(7, 8);
		if (!"0".equals(day2)) {
			sb.append(getChinese(Integer.parseInt(day2)));
		}
		sb.append("日");
		return sb.toString();
	}

	private static String getChinese(int digital) {
		switch (digital) {
			case 0:
				return "零";
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
			case 7:
				return "七";
			case 8:
				return "八";
			case 9:
				return "九";
		}
		return "零";
	}

	/**
	*	 Major LS calculation routine
	*	 @param sDate 		- Date object
	*	 @param duration 	- in 999A format where A can only be Y, M, W and D
	*   @return String in DD/MM/YYYY format, null if any exception occur
	*/
	public static String calcDate(Date date, String duration) {

		try {
			String sDate = formatDate(date);
			String yr, mth, day;
			day = sDate.substring(0, 2);
			mth = sDate.substring(3, 5);
			yr = sDate.substring(6, 10);
			return calcLS(yr, mth, day, duration);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	*	 Major LS calculation routine
	*	 @param sDate 		- in DD/MM/YYYY format
	*	 @param duration 	- in 999A format where A can only be Y, M, W and D
	*   @return String in DD/MM/YYYY format, null if any exception occur
	*/
	public static String calcDate(String sDate, String duration) {

		try {
			String yr, mth, day;
			day = sDate.substring(0, 2);
			mth = sDate.substring(3, 5);
			yr = sDate.substring(6, 10);
			return calcLS(yr, mth, day, duration);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	*	 Major LS calculation routine
	*	 @param yr 			- in YYYY format
	*	 @param mth 		- in MM format
	*	 @param day			- in DD format
	*	 @param duration 	- in 999A format where A can only be Y, M, W and D
	*   @return String in DD/MM/YYYY format, null if any exception occur
	*/
	private final static char YEAR = 'Y';
	private final static char MTH = 'M';
	private final static char WEEK = 'W';
	private final static char DAY = 'D';

	private static String calcLS(String yr, String mth, String day, String duration) {

		try {
			GregorianCalendar calendar =
					new GregorianCalendar(Integer.parseInt(yr), Integer.parseInt(mth) - 1, Integer
							.parseInt(day));
			char durationType = duration.charAt(duration.length() - 1);
			int amount = Integer.parseInt(duration.substring(0, duration.length() - 1));
			String result = null;
			switch (durationType) {
				case YEAR:
					result = calcLSYr(calendar, amount);
					break;
				case MTH:
					result = calcLSMth(calendar, amount);
					break;
				case WEEK:
					result = calcLSDay(calendar, amount * 7);
					break;
				case DAY:
					result = calcLSDay(calendar, amount);
					break;
			}

			return result;
		} catch (Exception e) {
			return null;
		}
	}

	private static String calcLSDay(GregorianCalendar calendar, int amount) throws ParseException {

		calendar.add(Calendar.DATE, amount);
		return parseDate(calendar);
	}

	private static String calcLSMth(GregorianCalendar calendar, int amount) throws ParseException {

		// orgmth and new mth are zero-based
		int orgmth = calendar.get(Calendar.MONTH);
		int newmth = orgmth + amount;

		if (newmth < 0)
			while (newmth < 0)
				newmth = newmth + 12;
		else while (newmth >= 12)
			newmth -= 12;
		calendar.add(Calendar.MONTH, amount);

		if (newmth != calendar.get(Calendar.MONTH)) {
			calendar.add(Calendar.MONTH, -1);
			GregorianCalendar newCalendar =
					new GregorianCalendar(calendar.get(Calendar.YEAR),
							calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DATE));
			return parseDate(newCalendar);
		} else return parseDate(calendar);
	}

	private static String calcLSYr(GregorianCalendar calendar, int amount) throws ParseException {

		//Calendar.YEAR
		// orgmth and new mth are zero-based
		int orgmth = calendar.get(Calendar.MONTH);
		calendar.add(Calendar.YEAR, amount);
		if (orgmth != calendar.get(Calendar.MONTH)) {
			calendar.add(Calendar.MONTH, -1);
			GregorianCalendar newCalendar =
					new GregorianCalendar(calendar.get(Calendar.YEAR),
							calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DATE));
			return parseDate(newCalendar);
		} else {
			return parseDate(calendar);
		}
	}

	/**
	 * @return the dEFAULT_LONG_DATE_PATTERN
	 */
	public static String getLongDatePattern() {
		return DEFAULT_LONG_DATE_PATTERN;
	}

	/**
	 * Create current system date in yyyyMMddHHmmss format.
	 * @return system date in yyyyMMddHHmmss string format.
	 */
	public static String getSystemDateString() {
		return format(getSystemDate(), DEFAULT_SYSTEM_DATE_FORMAT);
	}

	/**
	 * Format the input date to default year in string format. If the input date is null, return empty string.
	 * @param date
	 * @return	the default format of the year part of the input date if the date object is not null. Otherwise, return empty string.
	 */
	public static String formatYear(Date date) {
		if (date != null) {
			return format(date, DateUtils.DEFAULT_YEAR_PATTERN);
		} else {
			return "";
		}
	}

	/**
	 * Add second to passed date.
	 * @param dt
	 * @param second
	 * @return
	 */
	public static Date addSecound(Date dt, long second) {
		long _tm = dt.getTime();
		_tm = _tm + (second * 1000);
		Date _dt = new Date(_tm);
		return _dt;
	}

	/**
	 * Check: frDate <= targetDate <= toDate
	 * @param frDate
	 * @param toDate
	 * @param targetDate
	 * @return
	 */
	public static boolean isBetween(Date frDate, Date toDate, Date targetDate) {
		long _target = targetDate.getTime();
		long _fr = frDate.getTime();
		if (_fr > _target) {
			return false;
		} else {
			long _to = toDate.getTime();
			if (_to < _target) {
				return false;
			} else {
				return true;
			}
		}

	}

	/**
	 * Create Calendar object with specified data
	 * @param yr
	 * @param mth
	 * @param day
	 * @param hr
	 * @param min
	 * @param sec
	 * @return
	 */
	public static Calendar getCalendar(int yr, int mth, int day, int hr, int min, int sec) {
		Calendar _cal = new GregorianCalendar(yr, mth, day, hr, min, sec);
		return _cal;
	}

	/**
	 * Create Date object with specified data
	 * @param yr
	 * @param mth
	 * @param day
	 * @param hr
	 * @param min
	 * @param sec
	 * @return
	 */
	public static Date getDate(int yr, int mth, int day, int hr, int min, int sec) {
		Calendar _cal = getCalendar(yr, mth, day, hr, min, sec);
		return _cal.getTime();
	}

	/**
	 * Create Calendar obj with specified Date-object
	 * @param dt
	 * @return
	 */
	public static Calendar getCalendar(Date dt) {
		Calendar _cal = new GregorianCalendar();
		_cal.setTime(dt);
		return _cal;
	}

}
