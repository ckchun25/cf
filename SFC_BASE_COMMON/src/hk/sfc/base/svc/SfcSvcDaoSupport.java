package hk.sfc.base.svc;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import hk.sfc.base.dao.CommonDao;


public class SfcSvcDaoSupport extends SfcSvcSupport {
	
	protected CommonDao dao;

	/**
	 * Getter of CommonDao.
	 * @return
	 */
	public CommonDao getDao() {
		return dao;
	}

	/**
	 * Setter of CommonDao.
	 * @param commonDao	the CommonDao object.
	 */
	public void setDao(CommonDao commonDao) {
		dao = commonDao;
	}

	public SqlMapClientTemplate getSQLMapClientTemplate() {
		return dao!=null?dao.getSqlMapClientTemplate():null;
	}	 
}
