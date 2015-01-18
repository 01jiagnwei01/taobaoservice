package com.gxkj.taobaoservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.taobaoservice.daos.MailSenderTaskDao;
import com.gxkj.taobaoservice.services.MailSenderTaskService;
@Service
public class MailSenderTaskServiceImpl implements MailSenderTaskService {
	
	@Autowired
	private MailSenderTaskDao mailSenderDao;

}
