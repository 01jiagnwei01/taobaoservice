package com.gxkj.taobaoservice.services;

import java.sql.SQLException;
import java.util.List;

import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.dto.ShouJianRen;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailSenderTask;
import com.gxkj.taobaoservice.enums.MailSenderStatus;

public interface MailSenderTaskService {

	ListPager doPage(int pageno, int pagesize, String title,
			MailSenderStatus status, Integer createUser) throws SQLException;

	/**
	 * 新增邮件发送任务
	 * @param contentId
	 * @param adminUser
	 * @param shouJianRens
	 * @return
	 * @throws BusinessException 
	 */
	MailSenderTask doAddMailSendTask(int contentId, AdminUser adminUser,List<ShouJianRen> shouJianRens)throws SQLException, BusinessException;

}
