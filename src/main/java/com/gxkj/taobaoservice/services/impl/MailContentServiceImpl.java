package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailContentDao;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailContent;
import com.gxkj.taobaoservice.enums.MailContentStatus;
import com.gxkj.taobaoservice.services.MailContentService;

public class MailContentServiceImpl implements MailContentService {
	
	@Autowired
	private MailContentDao mailContentDao;
	
	public MailContent doAddMailContent(MailContent entity, AdminUser adminUser)
			throws SQLException {
		 Date now = new Date();
		 entity.setUpdateTime(now);
		 entity.setUpdateUserId(adminUser.getId());
		 entity.setStatus(MailContentStatus.NORMAL);
		 mailContentDao.insert(entity);
		return entity;
	}

	public MailContent doUpdateMailContent(MailContent entity,
			AdminUser adminUser) throws SQLException {
		Date now = new Date();
		entity.setUpdateTime(now);
		entity.setUpdateUserId(adminUser.getId());
		entity.setStatus(MailContentStatus.NORMAL);
		mailContentDao.update(entity);
		return entity;
	}

	@Override
	public boolean doDelMailContent(int id, AdminUser adminUser)
			throws SQLException {
		 
		MailContent entity = (MailContent) mailContentDao.selectById(id, MailContent.class);
		if(entity == null) return false;
		Date now = new Date();
		entity.setUpdateTime(now);
		entity.setUpdateUserId(adminUser.getId());
		entity.setStatus(MailContentStatus.DELETE);
		mailContentDao.update(entity);
		return true;
	}

	public MailContent getMailContentById(int id) throws SQLException {
		 
		return (MailContent) mailContentDao.selectById(id, MailContent.class);
	}

	 
	public ListPager doPage(int pageno, int pagesize, String title)
			throws SQLException {
		 
		return mailContentDao.doPage( pageno,  pagesize,  title);
	}

}
