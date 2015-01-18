package com.gxkj.taobaoservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.taobaoservice.daos.MailSenderDao;
import com.gxkj.taobaoservice.services.MailSenderService;
@Service
public class MailSenderServiceImpl implements MailSenderService {
	
	@Autowired
	private MailSenderDao mailSenderDao;

}
