package hk.sfc.base.validation;


/**
 *  A validation context. Allows for recording validation error messages, as well as validating data entered by the user. 
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>13/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface SfcValidationContext {
	
	/**
	 * Obtain the value entered by the current user in the UI field bound to the property provided.
	 * @param property	the name of a bound property.
	 * @return	the value the user entered in the field bound to the property.
	 */
	public Object getUserValue(String property);
	
	/**
	 * Register a global error for the entire target object, using the given error description. 
	 * @param errorCode	error code, interpretable as a message key
	 * @param errorArgs	error arguments, for argument binding via MessageFormat (can be null)
	 * @param defaultMessage	
	 */
	public void reject(String errorCode, Object[] errorArgs, String defaultMessage);
	
	/**
	 * Register a global error for the entire target object, using the given error description.
	 * @param errorCode
	 * @param resolvableArgs	the argument value to be resolved by message source.
	 */
	public void reject(String errorCode, Object[] resolvableArgs);
	
	/**
	 * Register a field error for the specified field of the current object.
	 * @param field	the field name 
	 * @param errorCode	error code, interpretable as a message key
	 * @param errorArgs	error arguments, for argument binding via MessageFormat (can be null)
	 * @param defaultMessage	fallback default message
	 */
	public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage);
	
	/**
	 * Register a field error for the specified field of the current object.
	 * @param field
	 * @param errorCode
	 * @param resolvableArgs	the argument value to be resolved by message source.
	 */
	public void rejectValue(String field, String errorCode, Object[] resolvableArgs);
}
