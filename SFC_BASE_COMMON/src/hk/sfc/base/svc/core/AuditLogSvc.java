package hk.sfc.base.svc.core;

/**
 * Audit Log Interface.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>19/03/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * </TABLE>
 *
 */
public interface AuditLogSvc {	
	
	/**
	 * Insert audit Data into Audit Log file -- licportal-portal-audit.log
	 * Please refer to log4j.properties setting
	 * @param className Class Name(e.g. AnnualReturnClass)
	 * @param auditData Log Data
	 */
	public void createAuditLog(String className, String auditData);
}
