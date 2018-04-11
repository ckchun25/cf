package hk.sfc.base.utils;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  Utility class for encoding.
 *
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>17/03/2009</TD><TD>kmfong1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>11/08/2009</TD><TD>Karl Yeung</TD><TD>Add method length to find out string length with encoding 'MS950_HKSCS'.</TD></TR>
 * </TABLE>
 */

public final class EncodingUtils {

	private static final Log logger = LogFactory.getLog(EncodingUtils.class);

	public static final String CHARSET_MS950_HKSCS = "MS950_HKSCS";

	// Mapping from Big5 UDA HKSCS characters to normal Big5 characters.
	private static final Map big5udaCharMap = new HashMap();

	// Utilities class cannot be created
	private EncodingUtils() {
	}

	static {
		// Initialize mapping from Big5 UDA HKSCS characters to normal Big5 characters.
		big5udaCharMap.put("8e69", new byte[] { (byte) 0xba, (byte) 0xe6 });
		big5udaCharMap.put("8e6f", new byte[] { (byte) 0xed, (byte) 0xca });
		big5udaCharMap.put("8e7e", new byte[] { (byte) 0xa2, (byte) 0x61 });
		big5udaCharMap.put("8eab", new byte[] { (byte) 0xba, (byte) 0xfc });
		big5udaCharMap.put("8eb4", new byte[] { (byte) 0xbf, (byte) 0xa6 });
		big5udaCharMap.put("8ecd", new byte[] { (byte) 0xaa, (byte) 0xcc });
		big5udaCharMap.put("8ed0", new byte[] { (byte) 0xbf, (byte) 0xae });
		big5udaCharMap.put("8f57", new byte[] { (byte) 0xb5, (byte) 0xd7 });
		big5udaCharMap.put("8f69", new byte[] { (byte) 0xe3, (byte) 0xc8 });
		big5udaCharMap.put("8f6e", new byte[] { (byte) 0xdb, (byte) 0x79 });
		big5udaCharMap.put("8fcb", new byte[] { (byte) 0xbf, (byte) 0xcc });
		big5udaCharMap.put("8fcc", new byte[] { (byte) 0xa0, (byte) 0xd4 });
		big5udaCharMap.put("8ffe", new byte[] { (byte) 0xb0, (byte) 0x5f });
		big5udaCharMap.put("906d", new byte[] { (byte) 0xb3, (byte) 0xa3 });
		big5udaCharMap.put("907a", new byte[] { (byte) 0xf9, (byte) 0xd7 });
		big5udaCharMap.put("90dc", new byte[] { (byte) 0xc0, (byte) 0x52 });
		big5udaCharMap.put("90f1", new byte[] { (byte) 0xc5, (byte) 0x54 });
		big5udaCharMap.put("91bf", new byte[] { (byte) 0xf1, (byte) 0xe3 });
		big5udaCharMap.put("9244", new byte[] { (byte) 0x92, (byte) 0x42 });
		big5udaCharMap.put("92af", new byte[] { (byte) 0xa2, (byte) 0x59 });
		big5udaCharMap.put("92b0", new byte[] { (byte) 0xa2, (byte) 0x5a });
		big5udaCharMap.put("92b1", new byte[] { (byte) 0xa2, (byte) 0x5c });
		big5udaCharMap.put("92b2", new byte[] { (byte) 0xa2, (byte) 0x5b });
		big5udaCharMap.put("92c8", new byte[] { (byte) 0xa0, (byte) 0x5f });
		big5udaCharMap.put("92d1", new byte[] { (byte) 0xe6, (byte) 0xab });
		big5udaCharMap.put("9447", new byte[] { (byte) 0xd2, (byte) 0x56 });
		big5udaCharMap.put("94ca", new byte[] { (byte) 0xe6, (byte) 0xd0 });
		big5udaCharMap.put("95d9", new byte[] { (byte) 0xca, (byte) 0x52 });
		big5udaCharMap.put("9644", new byte[] { (byte) 0x9c, (byte) 0xe4 });
		big5udaCharMap.put("96ed", new byte[] { (byte) 0x96, (byte) 0xee });
		big5udaCharMap.put("96fc", new byte[] { (byte) 0xe9, (byte) 0x59 });
		big5udaCharMap.put("9b76", new byte[] { (byte) 0xef, (byte) 0xf9 });
		big5udaCharMap.put("9b78", new byte[] { (byte) 0xc5, (byte) 0xf7 });
		big5udaCharMap.put("9b7b", new byte[] { (byte) 0xf5, (byte) 0xe8 });
		big5udaCharMap.put("9bc6", new byte[] { (byte) 0xe8, (byte) 0xcd });
		big5udaCharMap.put("9bde", new byte[] { (byte) 0xd0, (byte) 0xc0 });
		big5udaCharMap.put("9bec", new byte[] { (byte) 0xfd, (byte) 0x64 });
		big5udaCharMap.put("9bf6", new byte[] { (byte) 0xbf, (byte) 0x47 });
		big5udaCharMap.put("9c42", new byte[] { (byte) 0xeb, (byte) 0xc9 });
		big5udaCharMap.put("9c53", new byte[] { (byte) 0xcd, (byte) 0xe7 });
		big5udaCharMap.put("9c62", new byte[] { (byte) 0xc0, (byte) 0xe7 });
		big5udaCharMap.put("9c68", new byte[] { (byte) 0xdc, (byte) 0x52 });
		big5udaCharMap.put("9c6b", new byte[] { (byte) 0xf8, (byte) 0x6d });
		big5udaCharMap.put("9c77", new byte[] { (byte) 0xdb, (byte) 0x5d });
		big5udaCharMap.put("9cbc", new byte[] { (byte) 0xc9, (byte) 0x5c });
		big5udaCharMap.put("9cbd", new byte[] { (byte) 0xaf, (byte) 0xb0 });
		big5udaCharMap.put("9cd0", new byte[] { (byte) 0xd4, (byte) 0xd1 });
		big5udaCharMap.put("9d57", new byte[] { (byte) 0xe0, (byte) 0x7c });
		big5udaCharMap.put("9d5a", new byte[] { (byte) 0xb5, (byte) 0xae });
		big5udaCharMap.put("9dc4", new byte[] { (byte) 0xa9, (byte) 0xe4 });
		big5udaCharMap.put("9ea9", new byte[] { (byte) 0xab, (byte) 0xec });
		big5udaCharMap.put("9eef", new byte[] { (byte) 0xde, (byte) 0xcd });
		big5udaCharMap.put("9efd", new byte[] { (byte) 0xc9, (byte) 0xfc });
		big5udaCharMap.put("9f60", new byte[] { (byte) 0xf9, (byte) 0xc4 });
		big5udaCharMap.put("9f66", new byte[] { (byte) 0x91, (byte) 0xbe });
		big5udaCharMap.put("9fcb", new byte[] { (byte) 0xb9, (byte) 0xb0 });
		big5udaCharMap.put("9fd8", new byte[] { (byte) 0x93, (byte) 0x61 });
		big5udaCharMap.put("a063", new byte[] { (byte) 0x8f, (byte) 0xb6 });
		big5udaCharMap.put("a077", new byte[] { (byte) 0xa9, (byte) 0xf0 });
		big5udaCharMap.put("a0d5", new byte[] { (byte) 0x94, (byte) 0x7a });
		big5udaCharMap.put("a0df", new byte[] { (byte) 0xde, (byte) 0x72 });
		big5udaCharMap.put("a0e4", new byte[] { (byte) 0x94, (byte) 0x55 });
		big5udaCharMap.put("fa5f", new byte[] { (byte) 0xad, (byte) 0xc5 });
		big5udaCharMap.put("fa66", new byte[] { (byte) 0xb0, (byte) 0xb0 });
		big5udaCharMap.put("fabd", new byte[] { (byte) 0xa5, (byte) 0x5d });
		big5udaCharMap.put("fac5", new byte[] { (byte) 0xa2, (byte) 0xcd });
		big5udaCharMap.put("fad5", new byte[] { (byte) 0xad, (byte) 0xeb });
		big5udaCharMap.put("fb48", new byte[] { (byte) 0x9d, (byte) 0xef });
		big5udaCharMap.put("fbb8", new byte[] { (byte) 0xb4, (byte) 0x40 });
		big5udaCharMap.put("fbf3", new byte[] { (byte) 0xc9, (byte) 0xdb });
		big5udaCharMap.put("fbf9", new byte[] { (byte) 0x9d, (byte) 0xfb });
		big5udaCharMap.put("fc4f", new byte[] { (byte) 0xd8, (byte) 0xf4 });
		big5udaCharMap.put("fc6c", new byte[] { (byte) 0xa0, (byte) 0xdc });
		big5udaCharMap.put("fcb9", new byte[] { (byte) 0xbc, (byte) 0xb5 });
		big5udaCharMap.put("fce2", new byte[] { (byte) 0xb4, (byte) 0xb8 });
		big5udaCharMap.put("fcf1", new byte[] { (byte) 0xa7, (byte) 0xfb });
		big5udaCharMap.put("fdb7", new byte[] { (byte) 0xcb, (byte) 0x58 });
		big5udaCharMap.put("fdb8", new byte[] { (byte) 0xb4, (byte) 0xfc });
		big5udaCharMap.put("fdbb", new byte[] { (byte) 0xb4, (byte) 0xe4 });
		big5udaCharMap.put("fdf1", new byte[] { (byte) 0xb5, (byte) 0x4e });
		big5udaCharMap.put("fe52", new byte[] { (byte) 0x99, (byte) 0x75 });
		big5udaCharMap.put("fe6f", new byte[] { (byte) 0xb7, (byte) 0xec });
		big5udaCharMap.put("feaa", new byte[] { (byte) 0xa2, (byte) 0x60 });
		big5udaCharMap.put("fedd", new byte[] { (byte) 0xcf, (byte) 0xf1 });
	}

	/**
	 * Check the encoding of string is being proper or not 
	 * @param data
	 * @return true if passed data is valid encoding
	 */
	public static boolean isValidEncodedChar(String data) {
		Charset _charset = Charset.forName(CHARSET_MS950_HKSCS);
		CharsetEncoder _encoder = _charset.newEncoder();
		boolean _rtn = false;
		try {
			CharBuffer _charBuff = CharBuffer.wrap(data);
			_encoder.encode(_charBuff);
			_rtn = true;
		} catch (UnmappableCharacterException _ex) {
			_rtn = false;
		} catch (CharacterCodingException _ex) {
			_rtn = false;
		}
		return _rtn;
	}

	/**
	 * Trim down the string based on the maximum number of bytes allowed.
	 *  <ul>
	 *  	<li>Convert Unicode string to MS950_HKSCS byte array.</li>
	 *  	<li>Recreate Unicode string using first (maxBytes + 1) bytes of byte array.</li>
	 *  	<li>Discard the last character in the new Unicode string.</li>
	 *  </ul>
	 * @param str Input string
	 * @param maxBytes Maximum number of bytes allowed in database field
	 * @return trimmed down string
	 */
	public static String substring(String str, int maxBytes) {
		String _out = str;

		try {
			if (str != null && str.getBytes(CHARSET_MS950_HKSCS).length > maxBytes) {
				// Convert Unicode string to MS950_HKSCS byte array.
				byte[] _data = str.getBytes(CHARSET_MS950_HKSCS);

				// Recreate Unicode string using first (maxBytes + 1) bytes of byte array.
				_out = new String(_data, 0, maxBytes + 1, CHARSET_MS950_HKSCS);

				// Discard the last character in the new Unicode string.
				_out = _out.substring(0, _out.length() - 1);
			}
		} catch (UnsupportedEncodingException _ex) {
			logger.error("substring(): " + CHARSET_MS950_HKSCS + " not supported", _ex);
		}

		return _out;
	}

	/**
	 * Convert chinese string with HKSCS-PUA characters to standard CJK Unicode string.
	 *  <ul>
	 *  	<li>Encode from Unicode string to MS950_HKSCS byte array.</li>
	 *  	<li>Map Big5 UDA HKSCS characters with equivalent normal big5 characters.</li>
	 *  	<li>Decode MS950_HKSCS byte array to normalized Unicode string.</li>
	 *  </ul>
	 * @param chineseString with HKSCS-PUA characters.
	 * @return Chinese Unicode standard string.
	 */
	public static String convertChinese(String chineseString) {
		String _out = chineseString;

		if (chineseString != null) {
			try {
				StringBuffer _buf = new StringBuffer();

				// Map Big5 UDA HKSCS characters with equivalent normal big5 characters.
				for (int _i = 0; _i < chineseString.length(); ++_i) {
					// Encode from Unicode string to MS950_HKSCS byte array.
					String _s = chineseString.substring(_i, _i + 1);
					byte[] _sourceBytes = _s.getBytes(CHARSET_MS950_HKSCS);

					if (_sourceBytes.length != 2) {
						// Non double-byte character - no transform is required.
						_buf.append(_s);
					} else {
						// Check double-byte character.
						String _value =
								Integer.toHexString(_sourceBytes[0]).replace("ffffff", "")
										+ Integer.toHexString(_sourceBytes[1])
												.replace("ffffff", "");
						byte[] _mappedBytes = (byte[]) big5udaCharMap.get(_value);

						if (_mappedBytes == null) {
							// Normal BIG5 character -> decode to Unicode using MS950_HKSCS encoding.
							_buf.append(new String(_sourceBytes, CHARSET_MS950_HKSCS));
						} else {
							// Mapped BIG5 character -> decode to Unicode using MS950_HKSCS encoding.
							String _mappedValue =
									Integer.toHexString(_mappedBytes[0]).replace("ffffff", "")
											+ Integer.toHexString(_mappedBytes[1]).replace(
													"ffffff", "");

							_buf.append(new String(_mappedBytes, CHARSET_MS950_HKSCS));

							if (logger.isDebugEnabled()) {
								logger.debug("convertChinese(): Replace " + _value + " with "
										+ _mappedValue);
							}
						}
					}
				}

				_out = _buf.toString();
			} catch (UnsupportedEncodingException _ex) {}
		}

		return _out;
	}

	/**
	 * Find input string length of encoding 'MS950_HKSCS'.
	 * @param str Input string
	 * @return int Length of input string
	 */
	public static int length(String str) throws UnsupportedEncodingException {
		int _len = 0;
		if (str != null) {
			_len = str.getBytes(CHARSET_MS950_HKSCS).length;
			if (logger.isDebugEnabled()) {
				logger.debug("EncodingUtils:findChineseStringLength - String length :[" + str
						+ "]/[" + _len + "]");
			}
		}
		return _len;
	}

}