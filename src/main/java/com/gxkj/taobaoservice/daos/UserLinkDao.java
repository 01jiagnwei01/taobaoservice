package com.gxkj.taobaoservice.daos;

import java.sql.SQLException;
import java.util.List;

import com.gxkj.common.dao.BaseDAO;
import com.gxkj.taobaoservice.entitys.UserLink;

public interface UserLinkDao extends BaseDAO {

	

	/**
	 * 根据邮箱查询用户信息
	 * @param email
	 * @return
	 */
	List<UserLink> getUsersByEmail(String email)throws SQLException;

	/**
	 * 根据ID和Email查询UserLink
	 * @param id
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	UserLink getUserLinkByIdAndEmail(int id, String email)throws SQLException;
}
