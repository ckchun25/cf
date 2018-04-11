package hk.sfc.base.ibatis.cache;

import java.net.URL;
import java.util.Properties;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.ibatis.sqlmap.engine.cache.CacheController;
import com.ibatis.sqlmap.engine.cache.CacheModel;

/**
 * EhCache controller
 * EhCache Implementation of the {@link com.ibatis.sqlmap.engine.cache.CacheController} interface to be able to use
 * EhCache as a cache implementation in iBatis. You can configure your cache model as follows, by example, in your
 * sqlMapping files:
 * &lt;cacheModel id="myCache" type="nl.rabobank.springproject.ibatis.EhCacheController" readOnly="true" serialize="false"&gt;
 *   &lt;property name="configFile" value="/path-to-ehcache.xml"/&gt;
 * &lt;/cacheModel&gt;
 * Alternatively, you can use a type alias in your type attribute and defining the class with a
 * &lt;TypeAlias&gt; declaration, see iBatis documentation on how to do this.
 * 
 * Copy from http://opensource.atlassian.com/confluence/oss/display/IBATIS/EHCache+support+for+iBatis
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>05/19/2009</TD><TD>kmfong</TD><TD>Initial version</TD></TR> 
 * </TABLE>
 *
 */

public class EhCacheController implements CacheController {

	/** The EhCache CacheManager. */
	private CacheManager cacheManager;

	/**
	 * Flush a cache model.
	 * 
	 * @param cacheModel
	 *            - the model to flush.
	 */
	public void flush(CacheModel cacheModel) {
		getCache(cacheModel).removeAll();
	}

	/**
	 * Get an object from a cache model.
	 * 
	 * @param cacheModel
	 *            - the model.
	 * @param key
	 *            - the key to the object.
	 * @return the object if in the cache, or null(?).
	 */
	public Object getObject(CacheModel cacheModel, Object key) {
		Object _result = null;
		Element _element = getCache(cacheModel).get(key);
		if (_element != null) {
			_result = _element.getObjectValue();
		}
		return _result;

	}

	/**
	 * Put an object into a cache model.
	 * 
	 * @param cacheModel
	 *            - the model to add the object to.
	 * @param key
	 *            - the key to the object.
	 * @param object
	 *            - the object to add.
	 */
	public void putObject(CacheModel cacheModel, Object key, Object object) {
		getCache(cacheModel).put(new Element(key, object));
	}

	/**
	 * Remove an object from a cache model.
	 * 
	 * @param cacheModel
	 *            - the model to remove the object from.
	 * @param key
	 *            - the key to the object.
	 * @return the removed object(?).
	 */
	public Object removeObject(CacheModel cacheModel, Object key) {
		Object _result = this.getObject(cacheModel, key);
		getCache(cacheModel).remove(key);
		return _result;
	}

	/**
	 * Configure a cache controller. Initialize the EH Cache Manager as a
	 * singleton.
	 * 
	 * @param props
	 *            - the properties object continaing configuration information.
	 */
	public void setProperties(Properties props) {
		URL _url = getClass().getResource(props.getProperty("configFile"));
		cacheManager = CacheManager.create(_url);
	}

	/**
	 * Gets an EH Cache based on an iBatis cache Model.
	 * 
	 * @param cacheModel
	 *            - the cache model.
	 * @return the EH Cache.
	 */
	private Cache getCache(CacheModel cacheModel) {
		String _cacheName = cacheModel.getId();
		Cache _cache = cacheManager.getCache(_cacheName);
		return _cache;
	}

	/**
	 * Shut down the EH Cache CacheManager.
	 */
	public void finalize() {
		if (cacheManager != null) {
			cacheManager.shutdown();
		}
	}
}