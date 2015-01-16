package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailAddressListDao;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;
import com.gxkj.taobaoservice.services.MailAddressListService;
@Service
public class MailAddressListServiceImpl implements MailAddressListService {

	@Autowired
	private MailAddressListDao mailAddressListDao;

	 
	public ListPager doPage(int pageno, int pagesize, String name,
			String email, MailAddressListStatus status) throws SQLException {
	 
		ListPager pager = mailAddressListDao.doPage(  pageno,   pagesize,   name,
				  email,   status);
		return pager;
	}
}
