package com.gxkj.taobaoservice.daos;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.gxkj.common.dao.BaseDAO;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.entitys.UserBase;
import com.gxkj.taobaoservice.enums.UserBaseStatus;
import com.gxkj.taobaoservice.enums.YANS;

public interface UserBaseDao extends BaseDAO{

	/**
	 * 根据用户名，查询用户信息
	 * @param userName
	 * @return
	 */
	List<UserBase> getUsersByUserName(String userName)throws SQLException;
	
	/**
	 * 分页查看用户信息
	 */
	public ListPager doPage(int pageno, int pagesize, String name ,UserBaseStatus status,Date regBeignTime ,Date regEndTime,YANS supplyMoneystatus,BigDecimal supplyMoney) throws SQLException;

	/**
	 * 查询所有的公司补助的公司
	 * @return
	 * @throws SQLException
	 */
	List<UserBase> getAllSupplyUsers()throws SQLException;

}
