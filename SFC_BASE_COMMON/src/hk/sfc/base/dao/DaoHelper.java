package hk.sfc.base.dao;

import hk.sfc.base.domain.SfcDomainObject;
import hk.sfc.base.domain.SfcDomainProperties;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 *  Helper class for DAO.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class DaoHelper {

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Set object properties. Creation and modification details 
	 * will NOT be added for this object. 
	 * 
	 * @param obj
	 * @return
	 */
	public Object setObjectProps(Object obj) {
		return setObjectProps(obj, false, false);
	}

	/**
	 * Process the object before the execution of SQL. </p>
	 * 
	 * It will process the obj as follows:
	 * <ol>
	 * <li>If the obj is null, it will return a new instance of Map.</li>
	 * <li>It test whether the obj is either a instance of LicDomainObject, LicDomainProperties, Map or List.</li>
	 * <li>If not, It will create a <code>Map</code> and set "key" as the key of the Map, and set obj as the value of the Map.</li>
	 * </ol>
	 * 
	 * If obj is a instance of LicDomainObject, it will try to get the check key by {@link SfcDomainObject#getCheckKey()}.
	 * If the check key exist, it will set back as modification time in LicDomainObject by {@link SfcDomainObject#setModificationTime(Timestamp)}.
	 * 
	 * @param obj	the object to be processed.
	 * @param creationDetails	NOT USE anymore as set up creation details is done by database triggers!! Should remove later.
	 * @param modificationDetails NOT USE anymore as set up modification details is done by database triggers!! Should remove later.
	 * @return	processed object.
	 */
	public Object setObjectProps(Object obj, boolean creationDetails, boolean modificationDetails) {

		Object _domainObj = obj;

		// Test whether the obj is either a instance of LicDomainObject, LicDomainProperties, Map or List
		// Otherwise, wrap the object with a Map.
		if (_domainObj == null) {
			_domainObj = new HashMap();
		} else if (obj instanceof SfcDomainObject) {

			// Set the modification time with the checkKey. Used for the optimistic lock checking.
			SfcDomainObject _object = (SfcDomainObject) obj;
			if (StringUtils.hasText(_object.getCheckKey())) {
				_object.setModificationTime(Timestamp.valueOf(_object.getCheckKey()));
			}

		} else if (obj instanceof SfcDomainProperties) {
			// No need for processing.
		} else if (obj instanceof Map) {
			// No need for processing.
		} else if (obj instanceof List) {
			// No need for processing.
		} else {
			Map _map = new HashMap();
			_map.put("key", obj);
			_domainObj = _map;
			if (logger.isDebugEnabled())
				logger.debug("Input object is not a instance of LicDomainObject, LicDomainProperties, List or Map, "
						+ "wrapped with HashMap and 'key' as the key");
		}

		return _domainObj;
	}

	/**
	 * Try to set the value to specified property of the object. Return
	 * false if the setting is not succeed.
	 * 
	 * @param obj
	 */
	public boolean setPropertyIgnoreErr(Object obj, String propertyName, Object value) {

		try {
			PropertyUtils.setProperty(obj, propertyName, value);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * Get the value from the object property, return null if there are errors or
	 * the value of the property is null.
	 * 
	 * @param obj
	 */
	public Object getPropertyIgnoreErr(Object obj, String propertyName) {

		Object _value = null;
		try {
			_value = PropertyUtils.getProperty(obj, propertyName);
		} catch (Exception e) {

		}
		return _value;
	}

}
