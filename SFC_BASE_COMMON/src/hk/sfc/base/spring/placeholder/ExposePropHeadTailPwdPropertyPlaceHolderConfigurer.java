package hk.sfc.base.spring.placeholder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.hksfc.efrr.util.GetAdmPwd;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
*
* <br>(C) 2008 The Securities And Futures Commission of Hong Kong. All rights reserved.
* <br>Revision History.<br>
* <TABLE BORDER=1>
* <TR><TH>ASR</TH><TH>Date</TH><TH>Names</TH><TH>Changes</TH></TR>
* <TR><TH>ASR12243</TH><TH>15/07/2008</TH><TH>Lewis</TH><TH>Inital Version</TH></TR>
* </TABLE>
*
*/
public class ExposePropHeadTailPwdPropertyPlaceHolderConfigurer extends PropertyPlaceholderConfigurer{
	
	private final static String PWDSTRING=".htpassword";
	private final static String PWDKEY=".htkey";
	private final static String PWDHEAD=".htheadpath";
	private final static String PWDTAIL=".httailpath";
	private static Hashtable pwdCache = new Hashtable();  
	
	private boolean headTailMode = false;
	
	public boolean isHeadTailMode() {
		return headTailMode;
	}

	public void setHeadTailMode(boolean headTailMode) {
		this.headTailMode = headTailMode;
	}

	/**
	* This resolve place holder function will check the placeholder
	* if the string with syntax .htpassword
	* system would assume it was using head /tail password
	* and it would expect system would have the .htkey; .htheadpath; .httailpath
	* with the properties key using the Prefix of .htpassword
	* e.g. the whole string for the placeholder is "sch.htpassword"
	* this function would thne locate the sch.htkey, sch.htheadpath, sch.httailpath
	* and usineg efrr's GetAdmPwd function to resolve the password
	* the password would then return to caller
	* Also the password property would be cached
	*/
	protected String resolvePlaceholder(String placeholder,
            Properties props) {
		// check if placeholder is with syntax xxx.password
		try {
		
		
			if (headTailMode && StringUtils.endsWithIgnoreCase(placeholder, PWDSTRING)) {
				// password
				// check if is exit on cache
				String pwd = (String) pwdCache.get(placeholder);
				if (pwd != null) {
					return pwd;
				
				}				
	
				// then we need to extract the Key and the HeadPath, TailPath
				// get the prefix string
				String[] pwdSplit = StringUtils.split(placeholder, PWDSTRING);
				// the Prefix will be pwdSplit[0];
				String pwdKey = super.resolvePlaceholder(pwdSplit[0] +PWDKEY, props);
				if (pwdKey == null) {
					logger.error("could not resolve " +pwdSplit[0] +PWDKEY );			
					return null;
				}
				
				String pwdheadPath = super.resolvePlaceholder(pwdSplit[0] +PWDHEAD, props);
				
				if (pwdheadPath == null) {
					logger.error("could not resolve " +pwdSplit[0] +PWDHEAD );			
					return null;
				}
				
				String pwdheadTail = super.resolvePlaceholder(pwdSplit[0] +PWDTAIL, props);
				
				if (pwdheadTail == null) {
					logger.error("could not resolve " +pwdSplit[0] +PWDTAIL );			
					return null;
				}
				// get the key
				
				
				GetAdmPwd gp = new GetAdmPwd ();
				gp.setKeyName (pwdKey);
				gp.setHeadPath (pwdheadPath);
				gp.setTailPath (pwdheadTail);
		
				char[] password = gp.getPassword();
				pwd = new String (password);
				pwdCache.put(placeholder, pwd );
				if (logger.isDebugEnabled()) {
					logger.debug("password is " + pwd);
				}
				return pwd;
				
			} else {
				return super.resolvePlaceholder(placeholder, props);
			}
		} catch (Throwable ex) {			
			logger.fatal("error during resolvePlaceholder", ex);
			return null;
		}		
	}

	
	

	  private Map<String, String> resolvedProps;

	  protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
	      Properties props) throws BeansException {
	      super.processProperties(beanFactoryToProcess, props);
	      resolvedProps = new HashMap<String, String>();
	      for (Object key : props.keySet()) {
	          String keyStr = key.toString();
	          resolvedProps.put(keyStr, parseStringValue(props.getProperty(keyStr), props,
	                  new HashSet()));
	      }
	  }

	  public Map<String, String> getResolvedProps() {
	      return Collections.unmodifiableMap(resolvedProps);
	  }
	  
	  public static Map<String, String> getSpringProperties(String propBeanName, ServletContext servletContext){ 
		  WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		  ExposePropHeadTailPwdPropertyPlaceHolderConfigurer configurer =
			  (ExposePropHeadTailPwdPropertyPlaceHolderConfigurer) context.getBean(propBeanName);
		  return configurer.getResolvedProps();
	  }
}

