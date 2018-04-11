package hk.sfc.base.domain.core;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * It stores the function group objects data.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>23/04/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class FunctionGroupObject extends SfcDomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7895187794061656233L;

	private String objectCode;

	private String objectDescription;

	/**
	 * Create default instance.
	 */
	public FunctionGroupObject() {

	}

	/**
	 * Create a instance with the input objectCode.
	 * @param objectCode
	 */
	public FunctionGroupObject(String objectCode) {
		setObjectCode(objectCode);
	}

	/**
	 * setter method of objectCode
	 * @param objectCode the objectCode to set
	 */
	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	/**
	 * getter method of objectCode
	 * @return the objectCode
	 */
	public String getObjectCode() {
		return objectCode;
	}

	/**
	 * setter method of objectDescription
	 * @param objectDescription the objectDescription to set
	 */
	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}

	/**
	 * getter method of objectDescription
	 * @return the objectDescription
	 */
	public String getObjectDescription() {
		return objectDescription;
	}

	/**
	 * Return true if the object code (but ignore the case comparison) is the same (allow empty string but not allow null).
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {

		// Ensure the object code is not null first.
		if (this.objectCode != null) {

			// Check the passing object is not null and is a instance of FunctionGroupObject.
			if (o != null && o instanceof FunctionGroupObject) {
				FunctionGroupObject _functionGroupObject = (FunctionGroupObject) o;

				// Ensure the passing object's objectCode are not null.
				if (_functionGroupObject.objectCode != null) {
					if (this.objectCode.trim().equalsIgnoreCase(
							_functionGroupObject.objectCode.trim())) {
						return true;
					}
				}

			}
		}
		return false;
	}

}
