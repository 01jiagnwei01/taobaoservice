package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailSenderTaskDao;
import com.gxkj.taobaoservice.enums.MailSenderStatus;
import com.gxkj.taobaoservice.services.MailSenderTaskService;
@Service
public class MailSenderTaskServiceImpl implements MailSenderTaskService {
	
	@Autowired
	private MailSenderTaskDao mailSenderDao;

	public ListPager doPage(int pageno, int pagesize, String title,
			MailSenderStatus status, Integer createUser) throws SQLException {
		 
		return mailSenderDao.doPage( pageno,  pagesize,  title,
				 status,  createUser);
	}

}
