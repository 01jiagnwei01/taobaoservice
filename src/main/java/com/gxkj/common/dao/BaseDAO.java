package com.gxkj.common.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxkj.common.util.ListPager;

public interface BaseDAO {

	public Object selectById(Serializable id, Class<?> clazz)
			throws SQLException;

	public void insert(final Object entity) throws SQLException;

	public void delete(Object entity) throws SQLException;

	public void update(Object entity) throws SQLException;

	public List<?> select(String hql) throws SQLException;

	public List<?> selectPage(String hql, ListPager pager) throws SQLException;

	public List<?> select(String hql, Object[] parameters) throws SQLException;
	
	public List<?> selectBySql (String sql,Class<?> clazz) throws SQLException;

	public ListPager selectPage(String hql, Object[] parameters, ListPager pager)
			throws SQLException;

	public List<?> selectPage(String hql, Object[] parameters, int from, int to)
			throws SQLException;

	public Object selectOne(String hql, Object[] parameters)
			throws SQLException;

	public Object selectOne(String hql) throws SQLException;

	public int executeUpdate(String sql, Object[] parameters)
			throws SQLException;

	public int executeUpdateBatch(final String hql,
			final ArrayList<Object[]> parameters) throws SQLException;

	public int executeUpdateBatch(String sql, ArrayList<Object[]> parametersal,
			int batchSize) throws SQLException;

	public int executeUpdateBySql(String sql) throws SQLException;

	public int executeUpdateBySql(String sql, Object[] parameters)
			throws SQLException;

	public int executeUpdateByHql(String hql) throws SQLException;

	public int executeUpdateByHql(String hql, Object[] parameters)
			throws SQLException;

	public long selectTotalRowCount(String sql, Object[] parameters)
			throws SQLException;

	public Object executeQueryOne(String sql, Object[] parameters,
			Class<?> clazz) throws SQLException;

	public List<?> executeQuery(String sql, Object[] parameters, Class<?> clazz)
			throws SQLException;

}
