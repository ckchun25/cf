package hk.sfc.base.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class StringUtils {

	static public boolean isEmpty(Object bean,String propertyPath) {
		boolean isEmpty;
		Object _property;
		if (bean!=null) {
			try {
				_property = PropertyUtils.getProperty(bean,propertyPath);
			} catch (IllegalAccessException e) {
				_property = null;
			} catch (InvocationTargetException e) {
				_property = null;
			} catch (NoSuchMethodException e) {
				_property = null;
			} catch (org.apache.commons.beanutils.NestedNullException e) {
				_property = null;		
			}
		} else {
			_property = null;
		}
		if (_property==null) {
			isEmpty = true;
		} else {
			if (_property instanceof String) {
				String _string = (String)_property;
				isEmpty = org.apache.commons.lang.StringUtils.isEmpty(_string);		
			} else {
				isEmpty = true;					
			}
		}		
		return isEmpty;
	}
	
	static public String trimAndUpper(String string) {
		if (string!=null) {
			return string.trim().toUpperCase();
		} else {
			return null;
		}
	}

	static public String trimAndUpper(Object bean,String propertyPath) {
		if (!isEmpty(bean, propertyPath)) {
			Object _property;
			try {
				_property = PropertyUtils.getProperty(bean, propertyPath);
			} catch (Exception e) {
				_property = null;
			}
			if (_property instanceof String) {
				return trimAndUpper((String)_property);
			} else { 
				return null;
			}
		} else {
			return null;
		}
	}
		
	static public String buildSQLLikeClause(String string,boolean toUpperCase) {
		if (string!=null) {
			string = (toUpperCase?string.toUpperCase():string);
			return "%"+string.trim()+"%";  
		} else {
			return null;
		}
	}
	
	static public String buildSQLLikeClause(Object bean,String propertyPath,boolean toUpperCase) {
		if (!isEmpty(bean, propertyPath)) {
			Object _property;
			try {
				_property = PropertyUtils.getProperty(bean, propertyPath);
			} catch (Exception e) {
				_property = null;
			}
			if (_property instanceof String) {
				return buildSQLLikeClause((String)_property, toUpperCase);
			} else { 
				return null;
			}
		} else {
			return null;
		}
	}

	static public boolean equals(String value1, String value2, boolean igroneCase) {
		if (value1!=null && value2!=null) {
			if (!igroneCase) {
				return value1.equals(value2);
			} else {
				return value1.equalsIgnoreCase(value2);
			}
		} else if (value1==null && value2==null) {
			return true;
		} else {
			return false;
		}
	}
	
}
