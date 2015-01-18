package com.gxkj.taobaoservice.services;

import java.sql.SQLException;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.enums.MailSenderStatus;

public interface MailSenderTaskService {

	ListPager doPage(int pageno, int pagesize, String title,
			MailSenderStatus status, Integer createUser) throws SQLException;

}
