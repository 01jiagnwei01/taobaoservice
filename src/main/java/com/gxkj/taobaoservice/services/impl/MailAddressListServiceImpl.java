package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailAddressListDao;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailAddressList;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;
import com.gxkj.taobaoservice.services.MailAddressListService;
@Service
public class MailAddressListServiceImpl implements MailAddressListService {

	@Autowired
	private MailAddressListDao mailAddressListDao;

	/**
	 * 分类查询
	 */
	public ListPager doPage(int pageno, int pagesize, String name,
			String email, MailAddressListStatus status) throws SQLException {
	 
		ListPager pager = mailAddressListDao.doPage(  pageno,   pagesize,   name,
				  email,   status);
		return pager;
	}


	/**
	 * 增加
	 */
	public MailAddressList doAddMailAddressList(
			MailAddressList mailAddressList, AdminUser adminUser) throws SQLException {
		 
		mailAddressList.setCreateUserId(adminUser.getId());
		mailAddressList.setCreteTime(new Date());
		mailAddressList.setStatus(MailAddressListStatus.NORMAL);
		mailAddressListDao.insert(mailAddressList);
		return mailAddressList;
	}


	/**
	 * 修改
	 */
	public MailAddressList doUpdateMailAddressList(
			MailAddressList mailAddressList, AdminUser adminUser) throws SQLException {
		mailAddressList.setCreateUserId(adminUser.getId());
		mailAddressList.setCreteTime(new Date());
		mailAddressList.setStatus(MailAddressListStatus.NORMAL);
		mailAddressListDao.update(mailAddressList);
		return mailAddressList;
	}


	/**
	 * 删除 
	 */
	public void doDelMailAddressList(Integer id,
			AdminUser adminUser) throws SQLException {
		MailAddressList mailAddressList = (MailAddressList) mailAddressListDao.selectById(id, MailAddressList.class);
		mailAddressList.setCreateUserId(adminUser.getId());
		mailAddressList.setCreteTime(new Date());
		mailAddressList.setStatus(MailAddressListStatus.DEL);
		mailAddressListDao.update(mailAddressList);
		
	}


	 
	 
}
