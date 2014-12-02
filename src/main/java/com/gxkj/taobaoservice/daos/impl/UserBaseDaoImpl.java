package com.gxkj.taobaoservice.daos.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.taobaoservice.daos.UserBaseDao;
import com.gxkj.taobaoservice.entitys.UserBase;
@Repository
public class UserBaseDaoImpl extends BaseDAOImpl implements UserBaseDao {

	 
	@SuppressWarnings("unchecked")
	public List<UserBase> getUsersByUserName(String userName) throws SQLException {
		String hql = "from UserBase where userName = ?";
		return ((List<UserBase>) this.selectByHQL(hql, new Object[]{userName}));
	}

	 
	

	 

}
