package hk.sfc.base.extjs;

public class JSONReaderResponse {

	private boolean success;
	private Object[] results;
	private int total;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object[] getResults() {
		return results;
	}
	public void setResults(Object[] results) {
		this.results = results;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
