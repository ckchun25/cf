package hk.sfc.base.domain;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  Abstract domain object class that implements LicDomainProperties for further extend.
 *
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>02/03/2009</TD><TD>tchan1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR14171</TD><TD>11/12/2009</TD><TD>Richard Shiu</TD><TD>UAT#681: Quality Check / Fix: Production: Exception Logging in Portal, Intra and Admin should be in error level</TD></TR>
 * <TR><TD>ASR16449</TD><TD>05/07/2010</TD><TD>Patrick Yung</TD><TD>P2B new feature of optimistic lock handling</TD></TR>
 * <TR><TD>ASR16449</TD><TD>27/08/2010</TD><TD>Suyee Li</TD><TD>Exend LicBaseDomain</TD></TR>
 * <TR><TD>ASR16449</TD><TD>14/10/2010</TD><TD>Richard Shiu</TD><TD>Add @XmlTransient annotation for XML schema generation.</TD></TR>
 * </TABLE>
 *
 */
public class SfcDomainObject extends SfcBaseDomain implements SfcDomainProperties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229331876369627873L;


	private static final Log logger = LogFactory.getLog(SfcDomainObject.class);


	protected Timestamp creationTime;
	protected Timestamp modificationTime;
	protected Long userId;
	protected String loginName;
	protected String checkKey;
	
	// P2B BEGIN: PY@05July2010
	// New optimistic lock mechanism by sequence number	
	// The column-name is SEQUENCE_NO confirmed with SFC-IT at 14July2010.
	// The attribute name is seqNum because seqNo is used by others.
	protected Long seqNum;
	// P2B END

	/* (non-Javadoc) Interface Method */
	@XmlTransient
	public Timestamp getCreationTime() {
		return creationTime;
	}

	/* (non-Javadoc) Interface Method */
	@XmlTransient
	public Timestamp getModificationTime() {
		return modificationTime;
	}

	/* (non-Javadoc) Interface Method */
	public void setCreationTime(Timestamp time) {
		creationTime = time;
	}

	/* (non-Javadoc) Interface Method */
	public void setModificationTime(Timestamp time) {
		modificationTime = time;
	}

	/* (non-Javadoc) Interface Method */
	public Long getUserId() {
		return userId;
	}

	/* (non-Javadoc) Interface Method */
	public void setUserId(Long id) {
		userId = id;
	}

	/* (non-Javadoc) Interface Method */
	public String getLoginName() {
		return loginName;
	}

	/* (non-Javadoc) Interface Method */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Set the checkKey. Usually used by the field binding for the hidden checkKey field.
	 * @param key
	 */
	public void setCheckKey(String key) {
		checkKey = key;
	}

	/**
	 * The checkKey is the identifier of the domain object status. If the object is changed, the key should be different.<p>
	 * @return String
	 */
	public String getCheckKey() {
		return checkKey;
	}

	// P2B BEGIN: PY@05July2010
	// New optimistic lock mechanism by sequence number	
	/**
	 * The lastSeqNo is used for preventing concurrent update of same record.<p>
	 * @return Long
	 */
	public Long getSeqNum() {
		return seqNum;
	}

	/**
	 * The lastSeqNo is used for preventing concurrent update of same record.<p>
	 * @param lastSeqNo
	 */
	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}
	// P2B END
	
	/**
	 * Override toStringMethod to write all properties in the Domain object.
	 * @return	a string that contains all the properties in key and value pair.
	 */
	public String toString() {
		Map _map;
		Set _set;
		StringBuffer _sb = new StringBuffer();

		try {
			_map = BeanUtils.describe(this);
			_set = _map.entrySet();
			Map.Entry _entry;
			Object[] _objs = (Object[]) _set.toArray();
			for (int i = 0; i < _objs.length; i++) {
				_entry = (Map.Entry) _objs[i];
				_sb.append("Key=" + _entry.getKey() + " ; Value=" + _entry.getValue());
			}
		} catch (Exception e) {
			logger.error("Calling toString in LicDomainObject occurs error: " + e.getMessage());
			return super.toString();
		}

		return _sb.toString();
	}

}
