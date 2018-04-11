package hk.sfc.base.utils;

import hk.sfc.base.constant.BaseConstant;
import hk.sfc.base.exception.SvcException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.util.StringUtils;

/**
 * 
 * Encode Helper (For Encoding and Decoding)
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR16260</TD><TD>17/07/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public final class EncodeHelper {
	
	// Password
	private static String password;
	
	// Algorithm 
	private static String algorithm;

	// Encryptor
	protected static StandardPBEStringEncryptor encryptor = null;
	
	/**
	 * The key for velocity to invoke this class, 
	 * to encrypt the link to be embedded in e-mail message 
	 */
	public static final String KEY = "EncodeHelper";
	
	private static final Log logger = LogFactory.getLog(EncodeHelper.class);
	
	/**
	 * Prevent a new instance is created
	 * @stereotype singleton
	 */
	private EncodeHelper() {
	}
	
	/**
	 * Create a EncodeHelper instance which is only used for special case. (e.g. Putting a class object into map for Velocity to use.)
	 * In normal situation, should use static method calling. 
	 * @return EncodeHelper
	 */
	public static EncodeHelper getInstance() {
		return new EncodeHelper();
	}
	
	/**
	 * Encrypt URL Parameter
	 * <br>
	 * <br>
	 * 
	 * Now delegate to {@link EncryptHelper#encodeURLParameter(String, String)}
	 * 
	 * @param data URL Parameter need to be encrypted
	 * @return enctypr URL Parameter
	 */
	public static String encodeURLParameter(String data) {
		return EncryptHelper.encodeURLParameter(BaseConstant.ENCRYPT_URL_PARAM, data);
	}
	
	/**
	 * Generate Encoded Data
	 * @param data data to be encoded
	 * @return String encoded data
	 * @throws SvcException
	 */
	public static String encode(String data) {

		if (data == null || data.length() == 0) {
			return null;
		}
		String encodedData = getEncryptor().encrypt(data);
		
		return encodedData;
	}

	/**
	 * Generate Decoded Data
	 * @param data data to be decoded
	 * @return String decoded data
	 * @throws SvcException
	 */
	public static String decode(String data) throws IllegalArgumentException {
		if (data == null || data.length() == 0) {
			return null;
		}
		if(logger.isDebugEnabled()){
			logger.debug("Decypt data: "+data);
		}
		return getEncryptor().decrypt(StringUtils.replace(data, " ", "+"));
	}
	
	/**
	 * Common method to initialize the encryptor
	 * @return Encryptor
	 */
	private static StandardPBEStringEncryptor getEncryptor(){
		if (encryptor == null) {
			encryptor = new StandardPBEStringEncryptor();
			encryptor.setProvider(new BouncyCastleProvider());
			encryptor.setAlgorithm(algorithm);
			encryptor.setPassword(password);
		}
		return encryptor;		
	}

	/**
	 * Getter method of password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method of password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		EncodeHelper.password = password;
	}

	
	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(String algorithm) {
		EncodeHelper.algorithm = algorithm;
	}

}
