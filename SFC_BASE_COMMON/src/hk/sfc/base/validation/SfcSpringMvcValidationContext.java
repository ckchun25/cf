package hk.sfc.base.validation;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.core.style.ToStringCreator;
import org.springframework.validation.Errors;

/**
 *  Validation context that is for Spring MVC.
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
public class SfcSpringMvcValidationContext implements SfcValidationContext {

	private Errors contextBackingObject;

	/**
	 * Default constructor.
	 * @param errors
	 */
	SfcSpringMvcValidationContext(Errors errors) {
		setContextBackingObject(errors);
	}

	/* (non-Javadoc) Interface Method */
	public Object getUserValue(String property) {
		return getContextBackingObject().getFieldValue(property);
	}

	/* (non-Javadoc) Interface Method */
	public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
		getContextBackingObject().reject(errorCode, errorArgs, defaultMessage);
	}

	/* (non-Javadoc) Interface Method */
	public void rejectValue(String field, String errorCode, Object[] errorArgs,
			String defaultMessage) {
		getContextBackingObject().rejectValue(field, errorCode, errorArgs, defaultMessage);
	}

	/**
	 * Get back the context backing object.
	 * @return the contextBackingObject
	 */
	public Errors getContextBackingObject() {
		return contextBackingObject;
	}

	/**
	 * Set the context backing object.
	 * @param contextBackingObject the contextBackingObject to set
	 */
	public void setContextBackingObject(Errors errors) {
		this.contextBackingObject = errors;
	}

	/* (non-Javadoc) Interface Method */
	public void reject(String errorCode, Object[] resolvableArgs) {
		reject(errorCode, createResolvableArgument(resolvableArgs), null);
	}

	/* (non-Javadoc) Interface Method */
	public void rejectValue(String field, String errorCode, Object[] resolvableArgs) {
		rejectValue(field, errorCode, createResolvableArgument(resolvableArgs), null);
		
	}
	
	/**
	 * Create a resolvableArgument with the input objects.
	 * @param args	array of objects to be converted to ResolvableArgument.
	 * @return	array of ResolvableArgument.
	 */
	private Object[] createResolvableArgument(Object[] args) {
		
		if (args == null) {
			return args;
		}
		
		Object[] _resolvableArgs = new Object[args.length];
		for (int i=0; i<_resolvableArgs.length; i++) {
			_resolvableArgs[i] = new ResolvableArgument(args[i]);
		}
		
		return _resolvableArgs;
		
	}
	
	// private inner class for create ResolvableArgument.
	private static class ResolvableArgument implements MessageSourceResolvable {

		private Object arg;

		public ResolvableArgument(Object arg) {
			this.arg = arg;
		}

		public Object[] getArguments() {
			return null;
		}

		public String[] getCodes() {
			return new String[] { arg.toString() };
		}

		public String getDefaultMessage() {
			return arg.toString();
		}

		public String toString() {
			return new ToStringCreator(this).append("arg", arg).toString();
		}

	}

}
