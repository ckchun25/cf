package hk.sfc.base.svc.activedirectory;

import hk.sfc.base.exception.SvcException;

public interface ActiveDirectorySvc {

	public ADUser getUserAndMembership(String userCode) throws SvcException;

	public ADUser refreshUserGroupMembership(String userCode) throws SvcException;

}