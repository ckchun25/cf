package hk.sfc.base.security;

import hk.sfc.base.domain.core.FunctionGroupObject;
import hk.sfc.base.domain.core.UserAccessFunction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Access Control object which contains the access right data and the operation of it.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>07/05/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ITUAT-LOG-253</TD><TD>24/06/2009</TD><TD>tchan1</TD><TD>Implements Serializable interface</TD></TR>
 * </TABLE>
 *
 */
public class AccessControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2843389232014216042L;

	private static final Log logger = LogFactory.getLog(AccessControl.class);

	/** No special access level required. */
	//public static final Integer ACCESS_LEVEL_NONE = new Integer(0);

	/** Read access */
	//public static final Integer ACCESS_LEVEL_READ = new Integer(1);

	/** Update access */
	//public static final Integer ACCESS_LEVEL_UPDATE = new Integer(2);

	/** Delete access */
	//public static final Integer ACCESS_LEVEL_DELETE = new Integer(3);

	/** The user authority, this means the user has read authority.  */
	public static final String AUTHORITY_READ = "R";

	/** The user authority, this means the user has update authority. */
	public static final String AUTHORITY_UPDATE = "U";

	/** The user authority, this means the user has delete authority. */
	public static final String AUTHORITY_DELETE = "D";

	/** The user authority, this means the user has create authority. */
	public static final String AUTHORITY_NEW = "N";
	
	//private static final Map AUTHORITY_MAP = new HashMap();

	//static {
	//	AUTHORITY_MAP.put(AUTHORITY_READ, ACCESS_LEVEL_READ);
	//	AUTHORITY_MAP.put(AUTHORITY_UPDATE, ACCESS_LEVEL_UPDATE);
	//	AUTHORITY_MAP.put(AUTHORITY_DELETE, ACCESS_LEVEL_DELETE);
	//}

	class UserObjectPermission {
	
		private String objectCode;
		private String objectDesc;
		private String authority = "";

		
		public UserObjectPermission(String objectCode, String objectDesc) {
			this.objectCode = objectCode;
			this.objectDesc = objectDesc;
		}		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof UserObjectPermission) {
				UserObjectPermission _other = (UserObjectPermission)obj;
				if (this.objectCode!=null && _other.objectCode!=null) {
					return this.objectCode.equalsIgnoreCase(_other.objectCode);
				}
			}
			return false;
		}
		public void appendAuthority(String newAuthority) {
			this.authority = this.authority+newAuthority;
		}
		public boolean isAllowRead() {
			return authority.indexOf(AccessControl.AUTHORITY_READ) > -1;
		}
		public boolean isAllowNew() {
			return authority.indexOf(AccessControl.AUTHORITY_NEW) > -1;
		}
		public boolean isAllowUpdate() {
			return authority.indexOf(AccessControl.AUTHORITY_UPDATE) > -1;
		}
		public boolean isAllowDelete() {
			return authority.indexOf(AccessControl.AUTHORITY_DELETE) > -1;
		}
		
		public String getObjectCode() {
			return objectCode;
		}
		public void setObjectCode(String objectCode) {
			this.objectCode = objectCode;
		}
		public String getObjectDesc() {
			return objectDesc;
		}
		public void setObjectDesc(String objectDesc) {
			this.objectDesc = objectDesc;
		}
	}
	
	private String userId;

	private String userClass;

	private String userGroupCode;

	private List<UserAccessFunction> userAccessFunctions;
	
	private HashMap<String,UserObjectPermission> userObjPermMap = new HashMap<String,UserObjectPermission>();
	
	/**
	 * Function object code is the key; function group code is the value.
	 */
	private Map<String,String> functionGroupObjectMap;

	/**
	 * function group code is the key; authority (the highest) is the value.
	 */
	private Map<String,UserAccessFunction> functionGroupMap;
	
	/** the access control loaded for which CE. */
	//private String accessControlFor;

	/** 
	 * Create a instance of AccessControl. It will build the function group object map and function group map.
	 * @param userId	a string represents user ID.
	 * @param userClass	a string represents user class.
	 * @param userGroupCode	a string represents the user group code.
	 * @param userAccessFunctions	a UserAccessFunction object which contains user access control data.
	 */
	public AccessControl(String userId, String userClass, String userGroupCode, List<UserAccessFunction> userAccessFunctions) {
		setUserId(userId);
		setUserClass(userClass);
		setUserGroupCode(userGroupCode);
		this.userAccessFunctions = userAccessFunctions;
		this.buildUserObjPermMap();
		buildFunctionGroupObjectMap();
		buildFunctionGroupMap();
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userClass
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * @param userClass the userClass to set
	 */
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	/**
	 * @return the userGroupCode
	 */
	public String getUserGroupCode() {
		return userGroupCode;
	}

	/**
	 * @param userGroupCode the userGroupCode to set
	 */
	public void setUserGroupCode(String userGroupCode) {
		this.userGroupCode = userGroupCode;
	}

	/**
	 * @return the userAccessFunctions
	 */
	//public List getUserAccessFunctions() {
	//	return userAccessFunctions;
	//}

	/**
	 * @param userAccessFunctions the userAccessFunctions to set
	 */
	//public void setUserAccessFunctions(List userAccessFunctions) {
	//	this.userAccessFunctions = userAccessFunctions;
	//}

	/**
	 * @param functionGroupObjectMap the functionGroupObjectMap to set
	 */
	//public void setFunctionGroupObjectMap(Map functionGroupObjectMap) {
	//	this.functionGroupObjectMap = functionGroupObjectMap;
	//}

	/**
	 * @return the functionGroupObjectMap
	 */
	public Map<String,String> getFunctionGroupObjectMap() {
		return functionGroupObjectMap;
	}

	/**
	 * @param functionGroupMap the functionGroupMap to set
	 */
	//public void setFunctionGroupMap(Map functionGroupMap) {
	//	this.functionGroupMap = functionGroupMap;
	//}

	/**
	 * @return the functionGroupMap
	 */
	public Map<String,UserAccessFunction> getFunctionGroupMap() {
		return functionGroupMap;
	}

	/**
	 * @param accessControlFor the accessControlFor to set
	 */
	//public void setAccessControlFor(String accessControlFor) {
	//	this.accessControlFor = accessControlFor;
	//}

	/**
	 * @return the accessControlFor
	 */
	//public String getAccessControlFor() {
	//	return accessControlFor;
	//}

	/**
	 * Authorization checking by using ACCESS_LEVEL_NONE.
	 * @param objectCode	a object to be accessed.
	 * @return	true if the objectCode can be access, otherwise false.
	 */
	public boolean isAuthorize(String objectCode) {
		return this.userObjPermMap.containsKey(objectCode);
	}

	public boolean isAuthorize(String objectCode, String authority) {
		UserObjectPermission _usrObjPerm = this.userObjPermMap.get(objectCode);
		if (_usrObjPerm!=null) {
			if (AccessControl.AUTHORITY_READ.equalsIgnoreCase(authority)) {
				return _usrObjPerm.isAllowRead();
			} else if (AccessControl.AUTHORITY_NEW.equalsIgnoreCase(authority)) {
				return _usrObjPerm.isAllowNew();
			} else if (AccessControl.AUTHORITY_UPDATE.equalsIgnoreCase(authority)) {
				return _usrObjPerm.isAllowUpdate();
			} else if (AccessControl.AUTHORITY_DELETE.equalsIgnoreCase(authority)) {
				return _usrObjPerm.isAllowDelete();
			}
		}
		return false;
	}
	
	/**
	 * Authorization checking by the object code and access level.
	 * @param objectCode	Object code.
	 * @param accesslevel	Access level.
	 * @return	true if the object code is found and the access level is allowed. Otherwise false. 
	 */
//	private boolean isAuthorize(String objectCode, Integer accessLevel) {
//
//		Integer _authority;
//		String _functionGroupCode = (String) getFunctionGroupObjectMap().get(objectCode);
//
//		// No object is found for this object code in the map or the object code is not exist in the map.
//		// Any of this outcome indicate it is not authorized to access this object.
//		if (_functionGroupCode == null) {
//			return false;
//		}
//
//		_authority = (Integer) getFunctionGroupMap().get(_functionGroupCode);
//
//		return checkAuthorityWithAccessLevel(_authority, accessLevel);
//
//	}

	/**
	 * Add a list UserAccessFunction to existing collection of UserAccessFunction.
	 * The function group object map and function group map will be rebuilt.
	 * @param userAccessFunctions
	 * @return boolean
	 */
	public boolean addUserAccessFunctions(List userAccessFunctions) {

		boolean _added = this.userAccessFunctions.addAll(userAccessFunctions);
		if (_added) {
			this.buildUserObjPermMap();
			//buildFunctionGroupObjectMap();
			//buildFunctionGroupMap();
		}
		return _added;
	}

	/**
	 * Build the function group object map.<p>
	 * It iterates the list of UserAccessFunction and get the list of function group objects in each UserAccessFunction.<p>
	 * Then it iterates the list of function group objects and build the functionGroupObject map by setting the function object 
	 * code as the key and function group code as the value.
	 */
	private void buildFunctionGroupObjectMap() {

		functionGroupObjectMap = new HashMap();

		UserAccessFunction _userAccessFunction;
		FunctionGroupObject _functionGroupObject;
		List _functionGroupObjects;

		if (logger.isDebugEnabled()) {
			logger.debug("Building function group object map for user Id: " + getUserId());
		}

		for (int i = 0; i < userAccessFunctions.size(); i++) {
			_userAccessFunction = (UserAccessFunction) userAccessFunctions.get(i);
			_functionGroupObjects = _userAccessFunction.getFunctionGroupObjects();

			if (logger.isDebugEnabled()) {
				logger.debug("Processing function group "
						+ _userAccessFunction.getFunctionGroupCode());
			}

			for (int j = 0; j < _functionGroupObjects.size(); j++) {
				_functionGroupObject = (FunctionGroupObject) _functionGroupObjects.get(j);

				if (logger.isDebugEnabled()) {
					logger.debug("Putting object code :" + _functionGroupObject.getObjectCode());
				}

				functionGroupObjectMap.put(_functionGroupObject.getObjectCode(),
						_userAccessFunction.getFunctionGroupCode());
			}
		}

	}

	/**
	 * Build the function group map.<p>
	 * It iterates the list of UserAccessFunction and get the function group code and the authority out. <p>
	 * It builds the map by setting the function group code as key and authority as value. 
	 * During the iteration, if duplicate function group code is found in the map, it will compare the authority stored in the map with the new authority and 
	 * higher authority level will be put into the map.
	 */
	private void buildFunctionGroupMap() {

		if (logger.isDebugEnabled()) {
			logger.debug("Building function group map");
		}

		functionGroupMap = new HashMap();

		String _functionGroupCode;
		Integer _newAuthority;
		Integer _storeAuthority;

		UserAccessFunction _userAccessFunction;
		for (int i = 0; i < userAccessFunctions.size(); i++) {
			_userAccessFunction = (UserAccessFunction) userAccessFunctions.get(i);
			_functionGroupCode = _userAccessFunction.getFunctionGroupCode();
			functionGroupMap.put(_functionGroupCode, _userAccessFunction);
		}
	}

	private void buildUserObjPermMap() {
		
		this.userObjPermMap.clear();
		
		for (int i=0;this.userAccessFunctions!=null && i<this.userAccessFunctions.size();i++) {
			UserAccessFunction _userAccessFunc = this.userAccessFunctions.get(i);
			List<FunctionGroupObject> _funcGrpObjList = _userAccessFunc.getFunctionGroupObjects();
			for (int j=0;_funcGrpObjList!=null && j<_funcGrpObjList.size();j++) {
				FunctionGroupObject _funcGrpObj = _funcGrpObjList.get(j);
				UserObjectPermission _usrObjPerm = this.userObjPermMap.get(_funcGrpObj.getObjectCode());
				if (_usrObjPerm==null) {
					_usrObjPerm = new UserObjectPermission(_funcGrpObj.getObjectCode(),_funcGrpObj.getObjectDescription());
					this.userObjPermMap.put(_usrObjPerm.getObjectCode(), _usrObjPerm);
					if (logger.isDebugEnabled()) {
						logger.debug("Putting object code :" + _funcGrpObj.getObjectCode());
					}
				}
				_usrObjPerm.appendAuthority(_userAccessFunc.getAuthority());
			}
		}
	}
	
	/**
	 * Convert the string representation of authority to Integer by looking up the AUTHORITY_MAP.<p>
	 * If the input authority is null, empty or not found in AUTHORITY_MAP, a ACCESS_LEVEL_NONE will be returned.
	 * @param authority	a string representation of user authority.
	 * @return	a Integer representation of user authority.
	 */
//	private Integer convertAuthorityValue(String authority) {
//		Integer _auth;
//
//		if (StringUtils.hasText(authority)) {
//			_auth = (Integer) AUTHORITY_MAP.get(authority);
//			if (_auth != null) {
//				return _auth;
//			} else {
//				return ACCESS_LEVEL_NONE;
//			}
//		} else {
//			return ACCESS_LEVEL_NONE;
//		}
//	}

	/**
	 * Check the authority with access level. If user authority is NULL, it will return false.
	 * If user authority is greater than or equals to the access level, it returns true. Otherwise, return false. 
	 * 
	 * @param authority	represents the user authority.
	 * @param accessLevel	represents the access level.
	 * @return	true if the accessLevel is allowed, otherwise false.
	 */
//	private boolean checkAuthorityWithAccessLevel(Integer authority, Integer accessLevel) {
//
//		if (authority == null) {
//			return false;
//		}
//
//		if (authority.compareTo(accessLevel) >= 0) {
//			return true;
//		}
//
//		return false;
//
//	}

}
