package hk.sfc.base.domain;

import java.io.Serializable;
import java.util.List;


/**
 *  A simple container to hold the page result.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>12/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class PageResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2893259432095276918L;

	private boolean success;
	// The total row count.
	private long rowCount;
	
	// The list of row.
	private List rows;
	
	public PageResult() {
	}
	/**
	 * Create a instance with rowCount and a list of result.
	 * @param rowCount	the number of row in the PageResult.
	 * @param rows	List of result.
	 */
	public PageResult(long rowCount, List rows) {
		setRowCount(rowCount);
		setRows(rows);
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	/**
	 * Get the total number of row.
	 * @return the total row number.
	 */
	public long getRowCount() {
		return rowCount;
	}

	/**
	 * Set the total number of row.
	 * @param rowCount the total row count.
	 */
	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * Get the list of result.
	 * @return the list of rows.
	 */
	public List getRows() {
		return rows;
	}

	/**
	 * Set the list of result.
	 * @param rows the list of rows.
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}
