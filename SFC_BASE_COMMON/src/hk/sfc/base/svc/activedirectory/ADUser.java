package hk.sfc.base.svc.activedirectory;

import java.util.Date;
import java.util.Set;

public class ADUser extends ADObject {
	
	private int uid;
	private String sAMAccountName;
	private String displayName;
	private Date lastMembershipRefreshDate;
	private Set<ADGroup> memberOf;
		
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getSAMAccountName() {
		return sAMAccountName;
	}
	public void setSAMAccountName(String accountName) {
		sAMAccountName = accountName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public Date getLastMembershipRefreshDate() {
		return lastMembershipRefreshDate;
	}
	public void setLastMembershipRefreshDate(Date lastMembershipRefreshDate) {
		this.lastMembershipRefreshDate = lastMembershipRefreshDate;
	}

	public Set<ADGroup> getMemberOf() {
		return memberOf;
	}
	public void setMemberOf(Set<ADGroup> memberOf) {
		this.memberOf = memberOf;
	}
}
