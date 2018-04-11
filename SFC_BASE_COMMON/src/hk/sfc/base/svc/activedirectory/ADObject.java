package hk.sfc.base.svc.activedirectory;

public abstract class ADObject implements Comparable<ADObject> {
	
	private String distinguishedName;

	public String getDistinguishedName() {
		return distinguishedName;
	}
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}

	@Override
	public int compareTo(ADObject other) {
		int _result = -1;
		if (this.distinguishedName!=null && other.distinguishedName!=null) {
			_result = this.distinguishedName.compareTo(other.distinguishedName);
		} else if (this.distinguishedName==null && other.distinguishedName!=null) {
			_result = -1;
		} else if (this.distinguishedName!=null && other.distinguishedName==null) {
			_result = 1;
		} else {
			_result = 0;
		}
		return _result;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean _result = false;
		if (object instanceof ADObject) {
			ADObject _other = (ADObject)object;
			if (this.distinguishedName!=null && _other.distinguishedName!=null) {
				_result = this.distinguishedName.equalsIgnoreCase(_other.distinguishedName);
			} else if (this.distinguishedName==null && _other.distinguishedName==null) {
				_result = true;
			}
		} else if (object instanceof String) {
			String _dn = (String)object;
			_result = _dn.equalsIgnoreCase(this.distinguishedName);
		}
		return _result;
	}
	
	@Override
	public int hashCode() {
		if (this.distinguishedName!=null) {
			return this.distinguishedName.hashCode();
		} else {
			return 0;
		}
	}
	
}
