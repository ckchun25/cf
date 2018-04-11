package hk.sfc.base.security;

import java.util.List;

import hk.sfc.base.exception.SecurityCheckException;
import hk.sfc.base.svc.message.SfcAppErrorMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StringUtils;

public class AopTranSvcInterceptor {
	
	private static final Log logger = LogFactory.getLog(AopTranSvcInterceptor.class);

	private List exemptionSvcList;
	
	public List getExemptionSvcList() {
		return exemptionSvcList;
	}

	public void setExemptionSvcList(List exemptionSvcList) {
		this.exemptionSvcList = exemptionSvcList;
	}

	public Object aroundIntercept(ProceedingJoinPoint pjp) throws SecurityCheckException, Throwable {

		if (logger.isDebugEnabled()) {
			logger.debug("###################################################");
			logger.debug("Service Method invoked:");
			logger.debug("Package and object name:" + pjp.getSignature().getDeclaringTypeName());
			logger.debug("Method:" + pjp.getSignature().getName());
			logger.debug("w/args: " + StringUtils.arrayToCommaDelimitedString(pjp.getArgs()));
			logger.debug("###################################################");
		}
		
		boolean _exemptSvc = false;
		if (exemptionSvcList != null) {
			for (int i=0;i<exemptionSvcList.size();i++) {
				if (pjp.getSignature().getDeclaringTypeName().equals(exemptionSvcList.get(i))) {
					if (logger.isDebugEnabled()) {
						logger.debug("Invoked Service Class is in Exemption List:["+pjp.getClass()+"]");
					}					
					_exemptSvc = true;
					break;
				}
			}
		}

		Object _returnObject = null;
		boolean _isChecked = false;

		try {
			if (_exemptSvc) {
				_isChecked = true;
			} else {
				_isChecked = preHandle(pjp);
			}
			_returnObject = pjp.proceed();
		} catch (SecurityCheckException sce) {
			throw sce;
		} catch (Throwable t) {
			if (!_exemptSvc) {
				postHandle(pjp, t, _isChecked);
			}
			throw t;
		}
		if (!_exemptSvc) {
			postHandle(pjp, null, _isChecked);
		}

		return _returnObject;
	}

	/**
	 * Process before the target method invoked. <p>
	 * It will start the security checking if the following pre-condition is fullfilled:
	 * <ol>
	 * <li>The request is security check required by checking the security profile</li>
	 * <li>The user is authenticated</li>
	 * <li>The access control data is loaded for this user</li>
	 * <li>If the current request is a method execution</li>
	 * <li>The security check is not done for this request.</li> 
	 * </ol>
	 * 
	 * After that, the security check will be started and proceed as follows:
	 * <ol>
	 * <li>It will try to authorize the the object with fully qualified name + ".*". (e.g. hk.sfc.licportal.ar.svc.ArSvcImpl.*)</li>
	 * <li>If above authorization checking is failure, it will try to authorized the object with fully qualified name + # + method name (e.g. hk.sfc.licportal.ar.svc.ArSvcImpl#saveAr)</li>
	 * <li>If above checking is failure, the SecurityCheckException will be thrown</li>
	 * </ol>
	 * 
	 * If the security checking is done without problem, this request will be marked as security check done to prevent further checking on this request.
	 * 
	 * @param pjp
	 * @return	true if the security checking is done, false if the ProceedingJoinPoint is not a method execution.
	 * @throws SecurityCheckException if the security check is failure.
	 */
	protected boolean preHandle(ProceedingJoinPoint pjp) throws SecurityCheckException {
		// Set the request is processed by the Service interceptor.
		ContextUtils.getAppUserProfile().setProcessedBySecurityModule(true);
				
		if (ContextUtils.getAppUserProfile().isSecurityCheckRequired()) {
			// Check only if the user is authenticated.
			//if (ContextUtils.getSecurityProfile().isAuthenticated()) {
				// Check only if the access control data is loaded for the user.
				//if (ContextUtils.getSecurityProfile().getGlTUser().getAccessControl() != null) {

					if (pjp.getKind() != ProceedingJoinPoint.METHOD_EXECUTION) {
						return false;
					}

					if (ContextUtils.getAppUserProfile().isSecurityChecked()) {
						if (logger.isDebugEnabled()) {
							logger.debug("The security checking is already done for this request, no need to check again.");
						}
						return true;
					}

					if (logger.isDebugEnabled()) {
						logger.debug("Start security checking ...");
					}

					// Check the package name and class name, add ".*" before access control checking.
					String _packageAndObjectName = pjp.getSignature().getDeclaringTypeName() + ".*";

					if (!ContextUtils.getAppUserProfile().isAuthorize(
							_packageAndObjectName)) {
						if (logger.isDebugEnabled()) {
							logger.debug("(" + _packageAndObjectName + ") is not authorized");
						}
						// The package and object is not found, try the method checking.
						String _packageObjectAndMethodName =
								pjp.getSignature().getDeclaringTypeName() + "#"
										+ pjp.getSignature().getName();

						if (!ContextUtils.getAppUserProfile().isAuthorize(
								_packageObjectAndMethodName)) {
							if (logger.isDebugEnabled()) {
								logger.debug("(" + _packageObjectAndMethodName
										+ ") is not authorized");
								logger.debug("Will throw SecurityCheckException ..");
							}
							throw new SecurityCheckException(SfcAppErrorMessage.UNAUTHORIZED_ACCESS);
						}
					}

					ContextUtils.getAppUserProfile().setSecurityChecked(true);

					if (logger.isDebugEnabled()) {
						logger.debug("End security checking and the access control is allowed. ");
					}

				//}

			//}
		}

		// Either no security checking is required or security check is passed.
		return true;
	}

	/**
	 * Process after the target method invoked. It will check whether the security check is done in preHandle method. 
	 * It it is not, it will set security checked to false to enforce security checking again in subsequent intercepted method call.
	 * @param pjp
	 * @param t	Throwable object.
	 * @param isChecked	flag that indicates whether the security checking is done.
	 */
	protected void postHandle(ProceedingJoinPoint pjp, Throwable t, boolean isChecked) {

		// If the security check is not done or reset. Set back the security check to false.
		if (!isChecked) {
			SfcAppUserProfile _profile = ContextUtils.getAppUserProfile();
			if (_profile!=null) {
				_profile.setSecurityChecked(false);
			}
		}

	}
}
