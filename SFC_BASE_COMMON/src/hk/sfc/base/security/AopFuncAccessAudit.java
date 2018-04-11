package hk.sfc.base.security;

import hk.sfc.base.svc.core.AuditLogSvc;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StringUtils;

/**
 * For create function access log by intercepting the package and method name.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>14/05/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class AopFuncAccessAudit {

	private static final Log logger = LogFactory.getLog(AopFuncAccessAudit.class);

	private final String ANONYMOUS_LOGIN_NAME = "ANONYMOUS";

	private final String UN_DETERMINED_MODULE = "Undetermined module";

	private String packagesPatternToBeIntercepted;

	private int moduleNamePositionInPackage = 1;

	private List methodPattenToBeIntercepted;

	private AuditLogSvc auditLogSvc;

	/**
	 * Intercept the method name to see whether the method is in the list of methodPattenToBeIntercepted.
	 * If the method name is matched, get the user login name, the CE of the user on behalf and determine the module name of the method. 
	 * Log those data in the audit log.
	 * 
	 * If the method name is not matched, do nothing.
	 *
	 * @param pjp
	 * @return	the return object after invoking the target method.
	 * @throws Throwable
	 */
	public Object aroundIntercept(ProceedingJoinPoint pjp) throws Throwable {

		Object _returnObject = null;

		// Determine the method name
		String _actionName = "";
		String _methodName = pjp.getSignature().getName();

		// Check whether the calling method is one of the method pattern to be intercepted.
		for (int i = 0; i < methodPattenToBeIntercepted.size(); i++) {
			if (_methodName.matches(methodPattenToBeIntercepted.get(i).toString())) {
				_actionName = _methodName;
				break;
			}
		}

		// If the calling method is the one we need to audit, then continue to find out the user name, ceref, module name.
		if (StringUtils.hasText(_actionName)) {

			StringBuffer _sb = new StringBuffer();
			_sb.append("[Event:FuncAccessControl]");
			_sb.append("[UsrName:").append(getLoginName()).append("]");
			_sb.append("[Module:").append(getModuleName(pjp)).append("]");
			_sb.append("[Action:").append(_actionName).append("]");

			if (logger.isDebugEnabled()) {
				logger.debug("Write function access log " + _sb.toString());
			}

			auditLogSvc.createAuditLog(this.getClass().getName(), _sb.toString());
		}

		_returnObject = pjp.proceed();

		return _returnObject;

	}

	/**
	 * Get the module name of the current calling method.
	 * It first check whether the object package match the packages pattern to be intercepted.
	 * If it is matched, it will find out the module name by the moduleNamePositionInPakcage. <p>
	 * e.g. If the package is hk.sfc.licportal.ar.svc and the moduleNamePositionInPackage is 2. The module name will be ar (It start the counting from the last position in package.)
	 * @param pjp
	 * @return String
	 */
	private String getModuleName(ProceedingJoinPoint pjp) {
		// Determine the module name, get it from the package name.
		String _moduleName = UN_DETERMINED_MODULE;
		String _fullQualifiedName = pjp.getSignature().getDeclaringTypeName();
		int _lastDotIndex = _fullQualifiedName.lastIndexOf(".");
		String _packageName = _fullQualifiedName.substring(0, _lastDotIndex);
		StringTokenizer _st = null;
		int _totalToken = 0;
		int _tokenCount = 0;
		int _moduleNamePositionInToken = 0;
		if (_packageName.matches(getPackagesPatternToBeIntercepted())) {

			_st = new StringTokenizer(_packageName, ".");
			_totalToken = _st.countTokens();
			_moduleNamePositionInToken = _totalToken - moduleNamePositionInPackage;
			while (_st.hasMoreTokens()) {
				if (_tokenCount == _moduleNamePositionInToken) {
					_moduleName = _st.nextToken();
					break;
				} else {
					_st.nextToken();
				}
				_tokenCount++;
			}
		}

		return _moduleName;
	}

	/**
	 * Get the user login name.
	 */
	private String getLoginName() {

		// Get the login name.
		String _loginName = null;
		try {
			_loginName = ContextUtils.getAppUserProfile().getLoginName();
		} catch (NullPointerException npe) {
			//do nothing
		}

		if (_loginName == null) {
			_loginName = ANONYMOUS_LOGIN_NAME;
		}

		return _loginName;
	}

	/**
	 * setter method of operatorMessage
	 * @param packagesPatternToBeIntercepted the packagesPatternToBeIntercepted to set
	 */
	public void setPackagesPatternToBeIntercepted(String packagesPatternToBeIntercepted) {
		this.packagesPatternToBeIntercepted = packagesPatternToBeIntercepted;
	}

	/**
	 * getter method of packagesPatternToBeIntercepted
	 * @return the packagesPatternToBeIntercepted
	 */
	public String getPackagesPatternToBeIntercepted() {
		return packagesPatternToBeIntercepted;
	}

	/**
	 * setter method of methodPattenToBeIntercepted
	 * @param methodPattenToBeIntercepted the methodPattenToBeIntercepted to set
	 */
	public void setMethodPattenToBeIntercepted(List methodPattenToBeIntercepted) {
		this.methodPattenToBeIntercepted = methodPattenToBeIntercepted;
	}

	/**
	 * getter method of methodPattenToBeIntercepted
	 * @return the methodPattenToBeIntercepted
	 */
	public List getMethodPattenToBeIntercepted() {
		return methodPattenToBeIntercepted;
	}

	/**
	 * setter method of moduleNamePositionInPackage
	 * @param moduleNamePositionInPackage the moduleNamePositionInPackage to set
	 */
	public void setModuleNamePositionInPackage(int moduleNamePositionInPackage) {
		this.moduleNamePositionInPackage = moduleNamePositionInPackage;
	}

	/**
	 * getter method of moduleNamePositionInPackage
	 * @return the moduleNamePositionInPackage
	 */
	public int getModuleNamePositionInPackage() {
		return moduleNamePositionInPackage;
	}

	/**
	 * setter method of auditLogSvc
	 * @param auditLogSvc the auditLogSvc to set
	 */
	public void setAuditLogSvc(AuditLogSvc auditLogSvc) {
		this.auditLogSvc = auditLogSvc;
	}

	/**
	 * getter method of auditLogSvc
	 * @return the auditLogSvc
	 */
	public AuditLogSvc getAuditLogSvc() {
		return auditLogSvc;
	}

}
