package hk.sfc.base.ibatis.handler;

import hk.sfc.base.utils.EncodingUtils;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * A iBatis type handler that interchange String and Chinese String.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>14/08/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class ChineseToChineseStringTypeHandler implements TypeHandlerCallback {

	/* (non-Javadoc) Interface Method */
	/**
	 * Convert the String to unicode CJK String by calling {@link EncodingUtils.convertChinese}.
	 * @param	getter	ResultGetter
	 * @return the converted unicode CJK.
	 */
	public Object getResult(ResultGetter getter) throws SQLException {

		String _result = getter.getString();

		if (_result != null) {

			return EncodingUtils.convertChinese(_result);
		}

		return _result;
	}

	/* (non-Javadoc) Interface Method */
	/**
	 * Set the parameter from String to String object.
	 */
	public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {

		String _object = (String) parameter;
		setter.setString(_object);

	}

	/* (non-Javadoc) Interface Method */
	/**
	 * Return null if the input String is null, otherwise return the original String object.
	 */
	public Object valueOf(String s) {

		if (s == null) {
			return null;
		}

		return s;
	}

}
