package hk.sfc.base.dwr;

import hk.sfc.base.exception.handler.ExceptionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.directwebremoting.extend.Call;
import org.directwebremoting.extend.Reply;
import org.directwebremoting.impl.DefaultRemoter;

/**
 * Extend DWR LicDefaultRemoter to add exception handling.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>30/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class LicDefaultRemoter extends DefaultRemoter {

	private final Log logger = LogFactory.getLog(LicDefaultRemoter.class);

	/** The exception handler to handle exception thrown during the DWR call */
	private ExceptionHandler exHandler;

	/**
	 * @return the exHandler
	 */
	public ExceptionHandler getExHandler() {
		return exHandler;
	}

	/**
	 * @param exHandler the exHandler to set
	 */
	public void setExHandler(ExceptionHandler exHandler) {
		this.exHandler = exHandler;
	}

	/**
	 * It will execute the method in the super class first. Then it will examine whether
	 * any throwable object in the Reply object. If true, call exception handler to handler it.
	 * @see org.directwebremoting.impl.DefaultRemoter#execute(org.directwebremoting.extend.Call)
	 */
	public Reply execute(Call call) {

		if (logger.isDebugEnabled()) {
			logger.debug("Before execute DWR call:" + call.getMethodName());
		}

		Reply _reply = super.execute(call);

		if (logger.isDebugEnabled()) {
			logger.debug("After execute DWR call");
		}

		if (_reply.getThrowable() != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("DWR Exception is found, try to handle it.");
			}
			return (Reply) exHandler.handleException(_reply.getThrowable(), _reply.getCallId());
		}
		return _reply;
	}

}
