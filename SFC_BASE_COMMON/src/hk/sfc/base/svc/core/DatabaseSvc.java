package hk.sfc.base.svc.core;


import hk.sfc.base.exception.SvcException;

import java.sql.SQLException;
import java.util.Date;


/**
 * Provide service related to database;
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>10/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface DatabaseSvc {
	
	
	/**
	 * Test whether the database connection is valid. If the connection is ok, implementation class can choose to return anything related about the testing (such as how long it takes), but it is optional. 
	 * Otherwise SQLException will be thrown.
	 * @return	anything about the testing result or null.
	 * @throws SQLException if the connection is failure.
	 */
	public Object testConnection() throws SQLException;
	
	/**
	 * Check current schema in lp_t_curr_schema, and set current schema in session
	 * Otherwise SQLException will be thrown.
	 * @return	anything about the testing result or null.
	 * @throws SQLException if the connection is failure.
	 */
	public Object setCurrentSchema() throws SQLException;
		
	/**
	 * Obtains the database time.
	 * @return database date
	 * @throws SQLException
	 */
	public Date getDatabaseDate() throws SvcException;

}
