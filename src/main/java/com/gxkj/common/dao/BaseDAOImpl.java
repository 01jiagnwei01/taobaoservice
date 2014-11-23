package com.gxkj.common.dao;

import java.util.List;

import org.hibernate.SessionFactory;
 
/**
 * @Description DAO接口实现类，此接口是Spring框架中DAO的接口实现类的基类，继承此的DAO不需要代码控制事务
 * @ClassName BaseDAOImpl
 */
public class BaseDAOImpl implements BaseDAO {

	 private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

 
	public List<Object> selectByHql(String hql, List<Object> parameters) {
		 
		return null;
	}
	 
	 
	 

   

}
