package com.gxkj.taobaoservice.services;

import java.sql.SQLException;

import org.springframework.validation.BindException;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailAddressList;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;

public interface MailAddressListService {

	ListPager doPage(int pageno, int pagesize, String name, String email,
			MailAddressListStatus status)throws SQLException;
	
	/**
	 * 增加通讯录内容
	 * @param mailAddressList
	 * @param adminUser
	 * @return
	 */
	MailAddressList doAddMailAddressList(MailAddressList mailAddressList,
			AdminUser adminUser)throws SQLException, BindException ;
	
	/**
	 * 修改通讯录内容
	 * @param mailAddressList
	 * @param adminUser
	 * @return
	 */
	MailAddressList doUpdateMailAddressList(MailAddressList mailAddressList,
			AdminUser adminUser)throws SQLException , BindException;
	
	/**
	 * 删除通讯录内容
	 * @param id
	 * @param adminUser
	 * @return
	 */
	void doDelMailAddressList(Integer id, AdminUser adminUser) throws SQLException ;

}
