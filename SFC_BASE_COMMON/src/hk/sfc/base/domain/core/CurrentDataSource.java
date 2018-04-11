package hk.sfc.base.domain.core;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * 
 * POJO of table - LP_T_CURR_SCHEMA
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>DD/MM/YYYY</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class CurrentDataSource extends SfcDomainObject{

	/**
	 * Generate Serial Version ID
	 */
	private static final long serialVersionUID = 936831077002608993L;
	
	//CURRENT_DB attribute
	private String currentDB;

	
	/**
	 * @return the currentDB
	 */
	public String getCurrentDB() {
		return currentDB;
	}

	
	/**
	 * @param currentDB the currentDB to set
	 */
	public void setCurrentDB(String currentDB) {
		this.currentDB = currentDB;
	}

	
}