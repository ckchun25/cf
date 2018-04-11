package hk.sfc.base.svc.activedirectory;

import java.util.Date;

public class ADGroup extends ADObject {
	
	private int gid;
	private String sAMAccountName;
	private String displayName;
	private Date lastMembershipRefreshDate;
	
	public ADGroup() {
	}

	public ADGroup(String distinguishedName) {
		setDistinguishedName(distinguishedName);
	}

	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
	
}
