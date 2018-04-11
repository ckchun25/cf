package hk.sfc.base.exception.handler;

/**
 *  Interface to be implemented by objects that will handle exception.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface ExceptionHandler {

	/** 
	 * Handle exception.
	 * 
	 * @param t	the throwable object.
	 * @param obj The pass in object may be processed and return out.
	 * @return	object which passed in. But it can be other object as well.
	 */
	public Object handleException(Throwable t, Object obj);

	/**
	 * Check if the exception should be handled.
	 * @param t	the throwable object.
	 * @return	true if the throwable can be handled, otherwise false.
	 */
	public boolean canHandle(Throwable t);

}
