package com.gxkj.taobaoservice.daos.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.taobaoservice.daos.RelAdminUserRoleDao;
import com.gxkj.taobaoservice.entitys.AdminRole;
 
 
@Repository
public class RelAdminUserRoleDaoImpl extends BaseDAOImpl  implements RelAdminUserRoleDao{

 
	public void delRelationByUserId(int userId) throws SQLException {
	 String sql = "delete from rel_admin_user_role where admin_user_id = ?";
	 this.executeUpdate(sql, new Object[]{userId});
		
	}

	public AdminRole getRoleByUserId(int userId) throws SQLException {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		 clazzs.add(AdminRole.class);
		 
		 String sql = "select role.* from rel_admin_user_role rel,admin_role role where role.id = rel.admin_role_id and rel.admin_user_id= ?"; 
		return (AdminRole) this.selectOneBySQL(sql, new Object[]{userId}, clazzs);
	}

}
