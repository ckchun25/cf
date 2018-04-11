package hk.sfc.base.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * Encrypts the url parameter.
 * <br>
 * <br>
 * 
 * This class is separated from {@link EncodeHelper} for interface with CBS.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>14/04/2010</TD><TD>khyip1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class EncryptHelper {

	private static final Log logger = LogFactory.getLog(EncryptHelper.class);
	
	private static final String ENCODED_VALUE = "UTF-8";

	/**
	 * Encrypt URL Parameter inside {@code data}.
	 * <br>
	 * <br>
	 * 
	 * {@code data} may be a complete URL that contains the host name and context path.
	 * The function encrypts only the parameter portion behind the '?' character,
	 * hence the host name and context path is not affected.
	 * On the other hand, if {@code data} does not contain any '?' character, 
	 * the entire string will be encrypted. 
	 * 
	 * @param paramName the parameter name to precede the encrypted parameter
	 * @param data URL Parameter need to be encrypted
	 * @return enctypr URL Parameter
	 */
	public static String encodeURLParameter(String paramName, String data) {
		if (data == null) {
			return null;
		}
		if (data.length() == 0)
		{
			return data;
		}
		int _paramIdx = data.indexOf('?');

		if (_paramIdx == data.length()-1)
			return data;

		String _url = "";
		String _urlParam = data;
		if (_paramIdx > -1) {
			_url = data.substring(0, _paramIdx);
			_urlParam = data.substring(_paramIdx + 1);
		}

		String _encodeParam = "";
		try {
			_encodeParam = paramName + "=" + URLEncoder.encode(EncodeHelper.encode(_urlParam), ENCODED_VALUE);
		} catch (UnsupportedEncodingException e) {
			logger.error("encodeURLParameter - Error :[" + e.getMessage() + "]", e.fillInStackTrace());
		}

		String _output = _paramIdx > -1 ? _url + "?" + _encodeParam : _encodeParam;

		if ( logger.isDebugEnabled() ) {
			logger.debug( "before encrypt=" + data + "; after encrypt=" + _output );
		}
		return _output;
	}
}
