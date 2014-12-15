package com.gxkj.taobaoservice.services;

import java.sql.SQLException;

import com.gxkj.taobaoservice.entitys.TaskOrder;

public interface TaskOrderService {
	
	/**
	 * 创建任务订单
	 * @param taskOrder
	 * @return
	 * @throws SQLException
	 */
	public TaskOrder addTaskOrder(TaskOrder taskOrder)throws SQLException;

}
