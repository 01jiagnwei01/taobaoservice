package com.gxkj.taobaoservice.daos.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.MailAddressListDao;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;
@Repository
public class MailAddressListDaoImpl extends BaseDAOImpl implements
		MailAddressListDao {

	public ListPager doPage(int pageno, int pagesize, String name,
			String email, MailAddressListStatus status) throws SQLException {
		
		String hql = "from MailAddressList where  ";
		Map<String,Object > params = new HashMap<String,Object > ();
		boolean  haveParam = false;
		if(StringUtils.isNotBlank(name)){
			haveParam = true;
			 hql += "  name like :name";
			 params.put("name", "%"+name+"%");
		}
		if(StringUtils.isNotBlank(email)){
			if(haveParam){
				 hql += " and ";
			}
			haveParam = true;
			 hql += "  email like :email";
			 params.put("email", "%"+email+"%");
		}
		if(status != null){
			if(haveParam){
				 hql += " and ";
			}
			haveParam = true;
			 hql += "   status = :status";
			 params.put("status", status);
		}
		if(!haveParam){
			hql = hql.replace("where", "");
		}
		ListPager pager = new ListPager();
		pager.setPageNo(pageno);
		pager.setRowsPerPage(pagesize );
		pager = this.selectPageByHql(hql, params, pager);
		 
		return pager;
	}

}
