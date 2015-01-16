package com.gxkj.taobaoservice.services;

import java.sql.SQLException;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;

public interface MailAddressListService {

	ListPager doPage(int pageno, int pagesize, String name, String email,
			MailAddressListStatus status)throws SQLException;

}
