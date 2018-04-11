package hk.sfc.base.utils;

import java.util.HashSet;
import java.util.Set;

/**
 *  Exception util <p>Provides utilities for manipulating and examining
 *  <code>Throwable</code> objects.</p>
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>11/06/2009</TD><TD>kmfong</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */

public final class ExceptionUtils {

	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private ExceptionUtils() {
	}

	/**
	 * Check an exception class is the exception itself or wrapped by an exception
	 * @param t Throwable instance to be checked
	 * @param clazz exception class name wrapped by Throwable
	 * @return boolean the exception class is wrapped by the Throwable
	 */
	public static boolean isExist(Throwable t, Class clazz) {
		Set _exceptionSet = toSet(t);
		return _exceptionSet.contains(clazz.getName());
	}

	/**
	 * Convert exception and wrapped exception to <code>Set</code>
	 * @param t Throwable instance
	 * @return Set set of exception class
	 */
	public static Set toSet(Throwable t) {
		Throwable _cause = t;
		Set _exceptionSet = new HashSet();

		do {
			_exceptionSet.add(_cause.getClass().getName());
			_cause = _cause.getCause();
		} while (_cause != null);
		return _exceptionSet;
	}
}
