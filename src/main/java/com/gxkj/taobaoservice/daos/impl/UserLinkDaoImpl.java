package com.gxkj.taobaoservice.daos.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.taobaoservice.daos.UserLinkDao;
import com.gxkj.taobaoservice.entitys.UserLink;
import com.gxkj.taobaoservice.enums.UserLinkTypes;
@Repository
public class UserLinkDaoImpl extends BaseDAOImpl implements UserLinkDao {

	@SuppressWarnings("unchecked")
	public List<UserLink> getUsersByEmail(String email) throws SQLException {
		String hql = "from UserLink where link_value = ? and link_type =?" ;
		return ((List<UserLink>) this.selectByHQL(hql, new Object[]{email,UserLinkTypes.EMAIL}));
	}

	 
	public UserLink getUserLinkByIdAndEmail(int id, String email)
			throws SQLException {
		String hql = "from UserLink where link_value = ? and link_type =? and id = ?" ;
		return (UserLink) this.selectOneByHQL(hql, new Object[]{email,UserLinkTypes.EMAIL,id});
	}


 
	public List<UserLink> getUsersByUserId(Integer userId) throws SQLException {
		 String hql = "from UserLink where userId = ?";
		return (List<UserLink>) this.selectByHQL(hql, new Object[]{userId});
	}
}
