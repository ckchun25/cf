package hk.sfc.base.exception;

import hk.sfc.base.svc.message.SfcAppErrorMessage;
import hk.sfc.base.svc.message.SfcErrorMessage;

import java.util.Arrays;

/**
 * Exception thrown when entity authorization check in entity service fails.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>03/03/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class EntityAuthorizationException extends SvcException {

	private static final long serialVersionUID = -7235568058029494091L;

	/**
	 * Constructor for subclasses
	 * @param msg error message
	 */
	protected EntityAuthorizationException(SfcErrorMessage msg) {
		super(msg);
	}

	/**
	 * Constructor for single entity object associated with a CE Ref#.
	 * @param funcName function name
	 * @param ceref CE reference number
	 * @param cls class of entity object
	 * @param id ID of entity object
	 */
	public EntityAuthorizationException(String funcName, String ceref, Class cls, Object id) {
		super(SfcAppErrorMessage.ENTITY_AUTHORIZATION_FAILURE.withArgs(new Object[] { funcName,
				ceref, cls.getName().substring(cls.getName().lastIndexOf(".") + 1), id }));
	}

	/**
	 * Constructor for multiple entity objects associated with a CE Ref#.  
	 * @param funcName function name
	 * @param ceref CE reference number
	 * @param cls class of entity object
	 * @param ids List of ID of entity object
	 */
	public EntityAuthorizationException(String funcName, String ceref, Class cls, Object[] ids) {
		super(SfcAppErrorMessage.ENTITY_AUTHORIZATION_FAILURE.withArgs(new Object[] { funcName,
				ceref, cls.getName().substring(cls.getName().lastIndexOf(".") + 1),
				Arrays.toString(ids) }));
	}

	/**
	 * Constructor for no entity objects associated with a CE Ref#.  
	 * @param funcName function name
	 */
	public EntityAuthorizationException(String funcName) {
		super(SfcAppErrorMessage.DELG_ENTITY_AUTHORIZATION_FAILURE
				.withArgs(new Object[] { funcName }));
	}

}