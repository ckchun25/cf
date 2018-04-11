package hk.sfc.base.svc.core;

/**
 * 
 * Retireve Current Data Source Service Interface
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>09/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>15/07/2009</TD><TD>ssyli1</TD><TD>Adding Source Comment by Suyee Li at 20090715</TD></TR>
 * </TABLE>
 *
 */
public interface CurrentDataSourceSvc {
	
	/**
	 * Retrieve schema from lp_t_curr_schemas
	 * @return String(either A or B)
	 */
	public String retrieveCurrentDataSource();
	
}
