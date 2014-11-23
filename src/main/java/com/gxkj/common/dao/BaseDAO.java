package com.gxkj.common.dao;

import java.util.List;




/**
 * @Description DAO接口实现类，此接口是Spring框架中DAO的接口实现类的基类，继承此的DAO不需要代码控制事务
 * @ClassName BaseDAO
 */
public interface BaseDAO {
	

	public  List<Object> selectByHql(String hql,List<Object> parameters);
}
