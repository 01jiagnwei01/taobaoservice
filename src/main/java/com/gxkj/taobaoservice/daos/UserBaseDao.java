package com.gxkj.taobaoservice.daos;

import java.sql.SQLException;
import java.util.List;

import com.gxkj.common.dao.BaseDAO;
import com.gxkj.taobaoservice.entitys.UserBase;

public interface UserBaseDao extends BaseDAO{

	/**
	 * 根据用户名，查询用户信息
	 * @param userName
	 * @return
	 */
	List<UserBase> getUsersByUserName(String userName)throws SQLException;

}
