package com.gxkj.taobaoservice.daos.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
 
 





import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.taobaoservice.daos.AdminMenuDao;
import com.gxkj.taobaoservice.entitys.AdminMenu;
@Repository
public class AdminMenuDaoImpl extends BaseDAOImpl implements AdminMenuDao {
	
	private String getAllsql = "select * from admin_menu order by orders ,id";
	
	@SuppressWarnings("unchecked")
	public List<AdminMenu> getAllMenu() throws SQLException{
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		clazzs.add(AdminMenu.class);
		return ((List<AdminMenu>) this.executeQuery(getAllsql, null, clazzs));
	}

	@SuppressWarnings("unchecked")
	public List<AdminMenu> getMenuWithSameBtnflag(AdminMenu entity) throws SQLException {
		List<Object> parameters = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select * from admin_menu where btnflag=? and isbutton=1  ");
		parameters.add(entity.getBtnflag());
		if(   entity.getId()!=0){
			sql.append( " and id != ?");
			parameters.add(entity.getId());
		}
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		clazzs.add(AdminMenu.class);
		return ((List<AdminMenu>) this.selectBySql(sql.toString(), parameters.toArray(), clazzs));
	}

}
