package hk.sfc.base.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *  A simple container to hold the pagination query parameter.
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
public class PaginationQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8687583445240241941L;

	// The page number.
	private int startRowNumber = 0;

	// Number of record in each page.
	private int pageSize = DEFAULT_PAGE_SIZE;

	// The field sorting order ,either descending or ascending. 
	private String sortingOrder;

	// The field to be sorted.
	private String sortBy;

	/** Sorting order in ascending. */
	public final static String SORTING_ORDER_ASCENDING = "ASC";

	/** Sorting order in descending */
	public final static String SORTING_ORDER_DESCENDING = "DESC";

	/** Default page size where currently is set to 10. */
	public final static int DEFAULT_PAGE_SIZE = 10;

	/**
	 * Construct a default Pagination query with start row number = 0 and default page size.<p>
	 * The sorting order and sort By is set to null.
	 */
	public PaginationQuery() {

	}

	/**
	 * Construct a PaginationQuery with the input start row number and default page size.<p>
	 * The sorting order and sort By is set to null.
	 * @param startRowNumber
	 */
	public PaginationQuery(int startRowNumber) {
		setStartRowNumber(startRowNumber);
	}

	
	/**
	 * Construct a PaginationQuery with the input start row number and page size.<p>
	 * The sorting order and sort By is set to null.
	 * @param startRowNumber
	 * @param pageSize
	 */
	public PaginationQuery(int startRowNumber, int pageSize) {
		this(startRowNumber, pageSize, null, null);
	}

	/**
	 * Construct a PaginationQuery with the input start row number, page size, sorting order and sort by.<p>
	 * @param startRowNumber
	 * @param pageSize
	 * @param sortingOrder
	 * @param sortBy
	 */
	public PaginationQuery(int startRowNumber, int pageSize, String sortingOrder, String sortBy) {
		setStartRowNumber(startRowNumber);
		setPageSize(pageSize);
		setSortingOrder(sortingOrder);
		setSortBy(sortBy);

	}

	/**
	 * Get start row number.
	 * @return the start row number.
	 */
	public int getStartRowNumber() {
		return startRowNumber;
	}

	/**
	 * Set the start row number.
	 * @param startRowNumber the start row number.
	 */
	public void setStartRowNumber(int rowNumber) {
		this.startRowNumber = rowNumber;
	}

	/**
	 * get the number of record in each page.
	 * @return the number of record in each page.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Set the number of record in each page.
	 * @param pageSize	the number of record in each page.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Get the field sorting order. 
	 * @return the field sorting order.
	 */
	public String getSortingOrder() {
		return sortingOrder;
	}

	/**
	 * Set the field sorting order.
	 * @param sortingOrder the field sorting order.
	 */
	public void setSortingOrder(String sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	/**
	 * Get the sorting field name.
	 * @return sorting field name.
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * Set the sorting field name.
	 * @param sortBy the sorting field name.
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Return the string of pagination query. 
	 */
	public String toString() {

		return ToStringBuilder.reflectionToString(this);
	}

}
