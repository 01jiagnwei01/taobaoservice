package com.gxkj.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

 
	@SuppressWarnings("unchecked")
	public List<Object> selectByHql(String hql, List<Object> parameters) {
		Session session  =  this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (parameters != null){
			for(int i=0,l = parameters.size();i<l;i++ ){
				query.setParameter(i, parameters.get(i));
			}
		}
		return ((List<Object>)query.list());
	}
	
	public void test(){
		System.out.println("play success");
	}
	 
	 
	 

   

}
