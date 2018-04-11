package hk.sfc.base.ibatis.handler;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class YNToBooleanTypeHandler implements TypeHandlerCallback {

	@Override
	public Object getResult(ResultGetter getter) throws SQLException {
		return "Y".equalsIgnoreCase(getter.getString());
	}

	@Override
	public void setParameter(ParameterSetter setter, Object object) throws SQLException {
		if (object instanceof Boolean) {			
			setter.setString(((Boolean)object)?"Y":"N");
		} else {
			setter.setString("N");
		}
	}

	@Override
	public Object valueOf(String string) {
		return "Y".equalsIgnoreCase(string);
	}

}
