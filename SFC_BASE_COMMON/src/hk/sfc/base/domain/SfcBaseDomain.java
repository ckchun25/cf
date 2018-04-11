package hk.sfc.base.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * Lic Base Domain
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16449</TD><TD>23/04/2010</TD><TD>Suyee Li</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class SfcBaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929448447854589212L;

	/* (non-Javadoc) Interface Method */
	public String toString() {
		// Use Reflection to build the string
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
