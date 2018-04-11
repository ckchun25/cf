package hk.sfc.base.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *  It defines the common properties that the domain object should have. The
 *  properties include the domain create date time, modification date time, user ID and login name as well. 
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public interface SfcDomainProperties extends Serializable {

	
	/**
	 * Get creation time of this object.
	 * @return	a creation time.
	 */
	public Timestamp getCreationTime();

	/**
	 * Set the creation time for this object.
	 * @param creationTime
	 */
	public void setCreationTime(Timestamp creationTime);

	/**
	 * Get modification time of this object.
	 * @return	a modification time
	 */
	public Timestamp getModificationTime();

	/**
	 * Set the modification time of this object.
	 * @param modificationTime
	 */
	public void setModificationTime(Timestamp modificationTime);
	
	/**
	 * Get the user Id.
	 * @return	the user Id.
	 */
	public Long getUserId();
	
	/**
	 * Set the user Id.
	 * @param userId
	 */
	public void setUserId(Long userId);
	
	/**
	 * Get the login name of user.
	 * @return	the login name of user.
	 */
	public String getLoginName();
	
	/**
	 * Set the login name of user.
	 * @param loginName
	 */
	public void setLoginName(String loginName);

}
