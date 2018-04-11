package hk.sfc.base.dao;

import hk.sfc.base.domain.PageResult;
import hk.sfc.base.domain.PaginationQuery;
import hk.sfc.base.exception.RecordConcurrentAccessException;
import hk.sfc.base.exception.SvcException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapException;

/**
 *  The iBATIS implementation of CommonDao interface.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class CommonDao extends SqlMapClientDaoSupport {

	protected final Log logger = LogFactory.getLog(getClass());
	protected final DaoHelper daoHelper = new DaoHelper();

	/* (non-Javadoc) Interface Method */
	public int delete(String statementName) {
		if (logger.isDebugEnabled()) {
			logger.debug("statement: " + statementName);
		}

		int _count = getSqlMapClientTemplate().delete(statementName);

		return _count;
	}

	/* (non-Javadoc) Interface Method */
	public int delete(String statementName, Object obj) {

		if (logger.isDebugEnabled()) {
			logger.debug("statement: " + statementName);
		}

		Object _param = setObjectProps(obj, false, false);

		int _count = getSqlMapClientTemplate().delete(statementName, _param);

		return _count;

	}

	/* (non-Javadoc) Interface Method */
	public Object insert(String statementName, Object obj) {
		return insert(statementName, obj, false, false);
	}

	/* (non-Javadoc) Interface Method */
	public Object insert(String statementName, Object obj, boolean creationdDetails) {
		return insert(statementName, obj, creationdDetails, false);

	}

	/* (non-Javadoc) Interface Method */
	public Object insert(String statementName, Object obj, boolean creationdDetails,
			boolean modificationDetails) {

		if (logger.isDebugEnabled()) logger.debug("Statement:" + statementName);

		Object _param = setObjectProps(obj, creationdDetails, modificationDetails);

		return getSqlMapClientTemplate().insert(statementName, _param);

	}

	/* (non-Javadoc) Interface Method */
	public List queryForList(String statementName, Object obj) {

		if (logger.isDebugEnabled()) logger.debug("statement:" + statementName);

		Object _param = setObjectProps(obj, false, false);

		return getSqlMapClientTemplate().queryForList(statementName, _param);
	}

	/* (non-Javadoc) Interface Method */
	public List queryForList(String statementName, Object obj, int skipResults, int maxResults) {

		if (logger.isDebugEnabled())
			logger.debug("statement:" + statementName + " skipResults=" + skipResults
					+ " maxResults=" + maxResults);

		Object _param = setObjectProps(obj, false, false);

		return getSqlMapClientTemplate().queryForList(statementName, _param, skipResults,
				maxResults);
	}

	/* (non-Javadoc) Interface Method */
	public Map queryForMap(String statementName, Object bean, String keyProperty) {

		if (logger.isDebugEnabled())
			logger.debug("statement:" + statementName + " keyProperty=" + keyProperty);

		Object _param = setObjectProps(bean, false, false);

		return getSqlMapClientTemplate().queryForMap(statementName, _param, keyProperty);
	}

	/* (non-Javadoc) Interface Method */
	public Map queryForMap(String statementName, Object obj, String keyProperty,
			String valueProperty) {

		if (logger.isDebugEnabled())
			logger.debug("statement:" + statementName + " keyProperty=" + keyProperty
					+ " valueProperty=" + valueProperty);

		Object _param = setObjectProps(obj, false, false);

		return getSqlMapClientTemplate().queryForMap(statementName, _param, keyProperty,
				valueProperty);
	}
	/* (non-Javadoc) Interface Method */
	/**
	 * The implementation will try to get the total record count by executing the sql statement statementName + "Count".<br>
	 * (e.g. if the input statementName is "AnnualReturn.queryForOutstandingRecord", the implementation will try to call "AnnualReturn.queryForOutstandingRecordCount" to get the total count).<p>
	 * If no such count SQL statement is found, it will assume all record will be retrieved.<p>
	 * The parameter Object (it could be Domain object, Map) will be put in a map keyed as "param", hence you could refer the property in the iBatis SQL file by "#param.ceref#" etc.<p>
	 * Also, the sorting order will be provides in 2 ways:<br>
	 * 1. You can specific the sorting order as follow in iBatis SQL file.<br>
	 * <pre>
	 *  &lt;dynamic prepend="order by"&gt;		
	 *	 &lt;isNotNull property="sortBy"&gt;
	 *		$sortBy$ $sortOrder$ 
	 *	 &lt;/isNotNull&gt;
	 *	&lt;/dynamic&gt;
	 * </pre>
	 * where the $sortBy$ is the database field to be sort by and $sortOrder$ which is the sorting order (either ASC or DESC).<p>
	 * 2. There is another way provide for you to add the sorting clause where the whole ordering clause is built for you.<br>
	 * <pre>
	 *  &lt;isNotNull property="sortStatement"&gt;
	 *		$sortStatement$ 
	 *	&lt;/isNotNull&gt;
	 * </pre>
	 */
	public PageResult queryForPage(String statementName, Object paramObject,
			PaginationQuery paginationQuery) {

		boolean _hasCountStatement = true;
		int _rowCount = 0;
		Object _countResult;
		Map _paramMap = new HashMap();
		List _queryResult = null;
		String _countStatement;
		String _sortingBy = paginationQuery.getSortBy();
		String _sortingOrder = paginationQuery.getSortingOrder();

		// Create parameter map
		_paramMap.put("param", paramObject);
		_paramMap.put("sortOrder", _sortingOrder);
		_paramMap.put("sortBy", _sortingBy);
		if (_sortingBy != null && _sortingOrder != null) {
			_paramMap.put("sortStatement", "ORDER BY " + _sortingBy + " " + _sortingOrder);
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("pagination statement:" + statementName + " sortOrder:" + _sortingOrder + " sortBy:" + _sortingBy);
		}

		// Check any count total record statement
		_countStatement = statementName + "Count";
		try {
			_countResult = queryForObject(_countStatement, _paramMap);
			if (_countResult instanceof Integer) {
				_rowCount = ((Integer) _countResult).intValue();
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("count SQL statement found but not used as the result is not a number.");
				}
				_hasCountStatement = false;
			}
		} catch (SqlMapException sqlMapException) {
			// Assume the count SQL is not found when this exception is thrown.
			logger.error("No count SQL statement:" + sqlMapException.getMessage());
			_hasCountStatement = false;
		}

		if (_hasCountStatement) {

			_queryResult =
					queryForList(statementName, _paramMap, paginationQuery.getStartRowNumber(),
							paginationQuery.getPageSize());

		} else {
			// if no count statement, assume all record will be returned.
			_queryResult = queryForList(statementName, _paramMap);
			_rowCount = _queryResult.size();
		}

		return new PageResult(_rowCount, _queryResult);
	}

	/* (non-Javadoc) Interface Method */
	public Object queryForObject(String statementName) {

		return queryForObject(statementName, null);
	}

	/* (non-Javadoc) Interface Method */
	public Object queryForObject(String statementName, Object obj) {

		if (logger.isDebugEnabled()) {
			logger.debug("statement:" + statementName);
		}

		Object _param = setObjectProps(obj, false, false);

		return getSqlMapClientTemplate().queryForObject(statementName, _param);
	}

	/* (non-Javadoc) Interface Method */

	public void queryForObject(String statementName, Object bean, Object result) {

		if (logger.isDebugEnabled()) logger.debug("statement:" + statementName);

		Object _param = setObjectProps(bean, false, false);

		getSqlMapClientTemplate().queryForObject(statementName, _param, result);

	}

	/* (non-Javadoc) Interface Method */

	public int update(String statementName, Object bean) throws SvcException {

		return update(statementName, bean, true);

	}

	/* (non-Javadoc) Interface Method */

	public int update(String statementName, Object obj, boolean modificationDetails) throws SvcException {

		if (logger.isDebugEnabled()) logger.debug("statement:" + statementName);

		Object _param = setObjectProps(obj, false, modificationDetails);

		int _count = getSqlMapClientTemplate().update(statementName, _param);
		
		if (_count == 0) {
			throw new RecordConcurrentAccessException(statementName);
		}

		return _count;

	}

	/**
	 * It process the bean by adding creation and modification details.
	 * @param bean	Bean to be operated
	 * @param creationDetails	true to add creation details.
	 * @param modificationDetails	true to add modification details
	 * @return	bean that has been processed.
	 */
	private Object setObjectProps(Object bean, boolean creationDetails, boolean modificationDetails) {
		return daoHelper.setObjectProps(bean, creationDetails, modificationDetails);
	}

}
