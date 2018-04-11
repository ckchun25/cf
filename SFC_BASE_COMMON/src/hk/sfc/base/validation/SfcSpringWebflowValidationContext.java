package hk.sfc.base.validation;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.validation.ValidationContext;

/**
 *  Validation context that is used for spring webflow.
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
public class SfcSpringWebflowValidationContext implements SfcValidationContext {

	ValidationContext contextBackingObject;

	/**
	 * Default constructor.
	 * @param context
	 */
	SfcSpringWebflowValidationContext(ValidationContext context) {
		contextBackingObject = context;
	}

	/* (non-Javadoc) Interface Method */
	public Object getUserValue(String property) {
		return getContextBackingObject().getUserValue(property);
	}

	/* (non-Javadoc) Interface Method */
	public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
		getContextBackingObject().getMessageContext().addMessage(
				new MessageBuilder().error().code(errorCode).args(errorArgs).defaultText(
						defaultMessage).build());

	}
	
	/* (non-Javadoc) Interface Method */
	public void reject(String errorCode, Object[] resolvableArgs) {
		getContextBackingObject().getMessageContext().addMessage(
				new MessageBuilder().error().code(errorCode).resolvableArgs(resolvableArgs).build());

	}
	
	/* (non-Javadoc) Interface Method */
	public void rejectValue(String field, String errorCode, Object[] errorArgs,
			String defaultMessage) {
		getContextBackingObject().getMessageContext().addMessage(
				new MessageBuilder().error().source(field).code(errorCode).args(errorArgs)
						.defaultText(defaultMessage).build());

	}
	
	/* (non-Javadoc) Interface Method */
	public void rejectValue(String field, String errorCode, Object[] resolvableArgs) {
		getContextBackingObject().getMessageContext().addMessage(
				new MessageBuilder().error().source(field).code(errorCode).resolvableArgs(resolvableArgs).build());

	}

	/**
	 * Get the context backing object.
	 * @return the contextBackingObject
	 */
	public ValidationContext getContextBackingObject() {
		return contextBackingObject;
	}

	/**
	 * Set the context backing object.
	 * @param contextBackingObject the contextBackingObject to set
	 */
	public void setContextBackingObject(ValidationContext validationContext) {
		this.contextBackingObject = validationContext;
	}

	

}
