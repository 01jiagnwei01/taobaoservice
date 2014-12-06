package com.gxkj.common.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.gxkj.common.util.ListPager;
 
public  class BaseDAOImpl    implements BaseDAO {
	
    protected SessionFactory sessionFactory;
    

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object selectById(Serializable id, Class<?> clazz) throws SQLException { 
		return sessionFactory.getCurrentSession().get(clazz, id);
	}
 
	public   void insert(final Object entity) throws SQLException {
		sessionFactory.getCurrentSession().save(entity);
	}

	public   void delete(Object entity) throws SQLException {
		sessionFactory.getCurrentSession().delete(entity);

	}

	public  void update(Object entity) throws SQLException {
		sessionFactory.getCurrentSession().update(entity);
	}

	public  List<?> selectByHQL(String hql) throws SQLException {
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public  List<?> selectPage(String hql, ListPager pager)
			throws SQLException {
		
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
		 query.setFirstResult((pager.getPageNo() - 1) * pager.getRowsPerPage());   
		 query.setMaxResults(pager.getRowsPerPage());   
		 return query.list();
	}

	public  List<?> selectByHQL(String hql, Object[] parameters)
			throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	public  ListPager selectPageByHql(String hql, Object[] parameters,
			ListPager pager) throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		Query countQuery = session.createQuery(getCounthql(hql));
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				countQuery.setParameter(i, parameters[i]);
			}
		}
		List<?> temp = countQuery.list();
		long totalRows = temp!=null&&temp.size()>0?Long.parseLong(temp.get(0)+""):0L;
		pager.setTotalRows(totalRows);
		if(totalRows == 0){
			pager.setPageData(null);
			
			return pager; 
		}
		List<?> pageData = this.selectPageByHQL(hql,parameters,
				(pager.getPageNo()-1)*pager.getRowsPerPage(),pager.getRowsPerPage());
		pager.setPageData(pageData);
		return pager;
	}
	
	public  ListPager selectPageBySQL(String sql, Object[] parameters,Class<?> clazz,
			ListPager pager) throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		String countSql = this.getCounthql(sql);
		SQLQuery countQuery = session.createSQLQuery(countSql);
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				countQuery.setParameter(i, parameters[i]);
			}
		}
		BigInteger totalRows = (BigInteger) countQuery.uniqueResult();
		pager.setTotalRows(totalRows.longValue());
		if(totalRows.intValue() == 0){
			pager.setPageData(null);
			
			return pager; 
		}
		List<?> pageData = this.selectPageBySQL(sql,parameters,
				(pager.getPageNo()-1)*pager.getRowsPerPage(),clazz,pager.getRowsPerPage());
		pager.setPageData(pageData);
		return pager;
	}

	public List<?> selectPageByHQL(String hql, Object[] parameters, int from,
			int to) throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				query.setParameter(i, parameters[i]);
			}
		}
		 query.setFirstResult(from);   
		 query.setMaxResults(to);  
		  return query.list();
	}
	public List<?> selectPageBySQL(String sql, Object[] parameters, int from,Class<?> clazz,
			int to) throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				query.setParameter(i, parameters[i]);
			}
		}
		if(clazz != null){
//			query.setResultTransformer(Transformers.aliasToBean(clazz));  
			query.addEntity(clazz);
		}else{
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}
		 query.setFirstResult(from);   
		 query.setMaxResults(to);  
		  return query.list();
	}

	public Object selectOneByHQL(String hql, Object[] parameters) throws SQLException {
		Query query = sessionFactory.getCurrentSession().createQuery(hql ); 
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				query.setParameter(i, parameters[i]);
			}
		}
		List<?> enityts = query.list();
		return enityts.size()==0 ? null : enityts.get(0);
	}

	public Object selectOneByHQL(String hql) throws SQLException {
		List<?> enityts = sessionFactory.getCurrentSession().createQuery(hql).list();

		return enityts.size()==0 ? null : enityts.get(0);
	}

	public int executeUpdate(String sql, Object[] parameters)
			throws SQLException {
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql); 
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				q.setParameter(i, parameters[i]);
			}
		}
		return q.executeUpdate();
	}

	public int executeUpdateBatch(final String hql, final ArrayList<Object[]> parameters )
			throws SQLException {
	 
		System.out.println("executeUpdateBatch undo");
		return 0;
	}

	public int executeUpdateBatch(String sql,
			ArrayList<Object[]> parametersal, int batchSize)
			throws SQLException {
		 
		System.out.println("executeUpdateBatch undo");
		return 0;
	}

	public int executeUpdateBySql(String sql) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery(sql);  
		return q.executeUpdate();
	}
	public int executeUpdateBySql(String sql, Object[] parameters)
			throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				q.setParameter(i, parameters[i]);
			}
		}
		return q.executeUpdate();
	}
	public int executeUpdateByHql(String hql) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).executeUpdate();
	}
	
	public int executeUpdateByHql(String hql, Object[] parameters) throws SQLException{
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery(hql); 
			if(parameters != null){
				for(int i=0,l = parameters.length;i<l;i++ ){
					q.setParameter(i, parameters[i]);
				}
			}
			return q.executeUpdate();
	 }

	public long selectTotalRowCount(String sql, Object[] parameters)
			throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query countQuery = session.createQuery(getCounthql(sql));
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				countQuery.setParameter(i, parameters[i]);
			}
		}
		List<?> temp = countQuery.list();
		long totalRows = temp!=null&&temp.size()>0?Long.parseLong(temp.get(0)+""):0L;
		return totalRows;
	}

	public Object executeQueryOne(String sql, Object[] parameters, Class<?> clazz)
			throws SQLException {
		List<?> datas = this.executeQuery(sql, parameters, clazz);
		return  datas == null ?null :datas.get(0 );
	}
	public List<?> executeQuery(String sql, Object[] parameters,
			Class<?> clazz) throws SQLException {
		Session session = sessionFactory.getCurrentSession() ;
		 
		SQLQuery q = session.createSQLQuery(sql);
		if(clazz != null){
			//q.setResultTransformer(Transformers.aliasToBean(clazz));  
			q.addEntity(clazz);
			 
		}else{
			 q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				q.setParameter(i, parameters[i]);
			}
		}
		
		List<?> datas =  q.list();
		return   datas;
	}

	 

	protected  String getCounthql(String hql){
    	StringBuffer counthql = new StringBuffer("") ;
    	if(hql.indexOf("distinct")>0 && hql.indexOf(",")<=0)
    		counthql.append("select count("+hql.substring(hql.indexOf("distinct"), hql.indexOf("from"))+") as _count "+hql.substring(hql.indexOf("from"), hql.length()));
    	else	
    		counthql.append("select count(*) as _count "+hql.substring(hql.indexOf("from"), hql.length()));
    	return counthql.toString();
    }

	 
	public List<?> selectBySQL(String sql, Class<?> clazz) throws SQLException {
		return this.executeQuery(sql, null, clazz);
	}

	public List<?> selectBySql(String sql, Object[] parameters, Class<?> clazz)
			throws SQLException {
		return this.executeQuery(sql, parameters, clazz);
	}

	 
	public Object selectOneBySQL(String sql,Class<?> clazz) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql); 
		if(clazz != null){
			//q.setResultTransformer(Transformers.aliasToBean(clazz));  
			q.addEntity(clazz);
		}else{
			 q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}
		return q.uniqueResult();
	}

	 
	public Object selectOneBySQL(String sql, Object[] parameters,Class<?> clazz)
			throws SQLException {
		 
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql); 
		if(parameters != null){
			for(int i=0,l = parameters.length;i<l;i++ ){
				q.setParameter(i, parameters[i]);
			}
		}
		if(clazz != null){
			//q.setResultTransformer(Transformers.aliasToBean(clazz));  
			q.addEntity(clazz);
		}else{
			 q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}
		return q.uniqueResult();
	}

 
	public void deleteById(Serializable  id,Class<?> clazz) throws SQLException {
	 
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(clazz, id) );
	}

 
	public List<?> selectByHQL(String hql, Map<String, Object> parameters)
			throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (parameters != null){
			for (String key : parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}
		return query.list();
	}

	 
	public ListPager selectPageByHql(String hql, Map<String, Object> param,
			ListPager pager) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query countQuery = session.createQuery(getCounthql(hql));
		if (param != null){
			for (String key : param.keySet()) {
				countQuery.setParameter(key, param.get(key));
			}
		}
		List<?> temp = countQuery.list();
		long totalRows = temp!=null&&temp.size()>0?Long.parseLong(temp.get(0)+""):0L;
		pager.setTotalRows(totalRows);
		if(totalRows == 0){
			pager.setPageData(null);
			return pager; 
		}
		List<?> pageData = this.selectPageByHQL(hql,param,
				(pager.getPageNo()-1)*pager.getRowsPerPage(),pager.getRowsPerPage());
		pager.setPageData(pageData);
		return pager;
	}

	 
	public List<?> selectPageByHQL(String hql, Map<String, Object> param,
			int from, int to) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(param != null){
			for (String key : param.keySet()) {
				query.setParameter(key, param.get(key));
			}
		}
		 query.setFirstResult(from);   
		 query.setMaxResults(to);  
		 return query.list();
	}

 

}
