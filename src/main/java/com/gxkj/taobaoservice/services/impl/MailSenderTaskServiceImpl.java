package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailContentDao;
import com.gxkj.taobaoservice.daos.MailSenderTaskDao;
import com.gxkj.taobaoservice.dto.ShouJianRen;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailContent;
import com.gxkj.taobaoservice.entitys.MailSenderTask;
import com.gxkj.taobaoservice.enums.MailSenderStatus;
import com.gxkj.taobaoservice.services.MailSenderTaskService;
@Service
public class MailSenderTaskServiceImpl implements MailSenderTaskService {
	
	@Autowired
	private MailSenderTaskDao mailSenderTaskDao;
	
	@Autowired
	private MailContentDao mailContentDao;

	public ListPager doPage(int pageno, int pagesize, String title,
			MailSenderStatus status, Integer createUser) throws SQLException {
		 
		return mailSenderTaskDao.doPage( pageno,  pagesize,  title,
				 status,  createUser);
	}

	/**
	 * 增加邮件发送任务 
	 * @throws BusinessException 
	 */
	public MailSenderTask doAddMailSendTask(int contentId, AdminUser adminUser,List<ShouJianRen> shouJianRens)
			throws SQLException, BusinessException {
		if(CollectionUtils.isEmpty(shouJianRens)){
			throw new BusinessException(BusinessExceptionInfos.MAIL_RECEIVER_CANNOT_BE_NULL);
		}
		MailContent mailContent = (MailContent) mailContentDao.selectById(contentId, MailContent.class);
		if(mailContent == null){
			throw new BusinessException(BusinessExceptionInfos.MAIL_CONTENT_CANNOT_FOUND);
		}
		MailSenderTask task = new MailSenderTask();
		task.setContent(mailContent.getContent());
		task.setCreateTime(new Date());
		task.setCreateUser(adminUser.getId());
		task.setStatus(MailSenderStatus.NOSEND);
		task.setTitle(mailContent.getTitle());
		mailSenderTaskDao.insert(task);
		
		//保存收件人
		for(ShouJianRen item :shouJianRens){
			
		}
		return task;
	}

}
