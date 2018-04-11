package hk.sfc.base.ibatis.handler;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * A ibatis type handler that interchange Timestamp and String.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class TimestampToStringTypeHandler implements TypeHandlerCallback {

	private static final Log logger = LogFactory.getLog(TimestampToStringTypeHandler.class);
	/* (non-Javadoc) Interface Method */
	/**
	 * Convert the Timestamp object to String by calling {@link Timestamp#toString()} in Timestamp object.
	 * If the return timestamp is null, it will be converted to empty string.
	 */
	public Object getResult(ResultGetter getter) throws SQLException {

		if (getter.wasNull()) {
			if (logger.isDebugEnabled()) {
				logger.debug("null result is found and return null.");
			}
			return null;
		}

		if (getter.getTimestamp() == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("null timestamp is found and now convert it to empty string.");
			}
			return "";
		} else {
			return getter.getTimestamp().toString();
		}
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * Set the parameter from String to Timestamp object. It will calling the Timestamp.valueOf method for the conversion.
	 */
	public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {

		String _object = (String) parameter;
		setter.setTimestamp(Timestamp.valueOf(_object));

	}
	/* (non-Javadoc) Interface Method */
	/**
	 * Return null if the input String is null, otherwise return the Timestamp object.
	 */
	public Object valueOf(String s) {

		if (logger.isDebugEnabled()) {
			logger.debug("Calling valueOf method.");
		}

		if (s == null) {
			return null;
		}

		return Timestamp.valueOf(s);
	}

}
