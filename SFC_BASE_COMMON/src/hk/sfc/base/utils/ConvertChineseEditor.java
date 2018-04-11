package hk.sfc.base.utils;

import java.beans.PropertyEditorSupport;

/**
 * A converter to convert a Chinese String to standard CJK string. 
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>10/08/2009</TD><TD>Tony Chan</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>25/08/2009</TD><TD>Karl Yeung</TD><TD>log #638, log #642 Add checking 'EncodingUtils.isValidEncodedChar' for the inputed string from request.</TD></TR>
 * <TR><TD>ASR14171</TD><TD>09/09/2009</TD><TD>Karl Yeung</TD><TD>ituat #197 Remove the useless comment.</TD></TR>
 * </TABLE>
 *
 */
public class ConvertChineseEditor extends PropertyEditorSupport {

	/**
	 * Default constructor.
	 */
	public ConvertChineseEditor() {

	}

	/* (non-Javadoc) Interface Method */
	/**
	 * This convert the Chinese String to standard CJK unicode.
	 */
	public void setAsText(String text) {

		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			if ( EncodingUtils.isValidEncodedChar(value) ) {
				value = EncodingUtils.convertChinese(value);
			}
			setValue(value);

		}
	}

	/* (non-Javadoc) Interface Method */
	public String getAsText() {

		Object value = getValue();
		return (value != null ? value.toString() : "");
	}

}
