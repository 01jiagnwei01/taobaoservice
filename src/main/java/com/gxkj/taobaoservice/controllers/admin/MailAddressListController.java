package com.gxkj.taobaoservice.controllers.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.SessionConstant;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.MailAddressList;
import com.gxkj.taobaoservice.entitys.MailContent;
import com.gxkj.taobaoservice.enums.MailAddressListStatus;
import com.gxkj.taobaoservice.services.MailAddressListService;

@Controller
@RequestMapping("/admin/mail/addresslist")
public class MailAddressListController {
	
	@Autowired
	private MailAddressListService mailAddressListService;
	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "admin/mail/mailaddress";
		return mv;
	}
	
	
	@RequestMapping(value="/dopage",method={RequestMethod.POST})
	@ResponseBody
	public EntityReturnData doPage( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="pageno",defaultValue="0") int pageno,
			@RequestParam(value="limit",defaultValue="20") int pagesize,
			@RequestParam(value="name",defaultValue="") String name ,
			@RequestParam(value="email",defaultValue="") String email ,
			@RequestParam(value="status",required=false) MailAddressListStatus status,
			ModelMap modelMap) throws SQLException  {
			EntityReturnData ret = new EntityReturnData();
			ret.setMsg("执行成功");
			ret.setResult(true);
		
			ListPager paper = mailAddressListService.doPage(pageno, pagesize, name,email,status);
			ret.setEntity(paper);
			return ret;
	}
	@RequestMapping(value="/doadd",method={RequestMethod.POST})
	@ResponseBody
	public EntityReturnData doAdd( HttpServletRequest request,
			HttpServletResponse response,
			MailAddressList mailAddressList,
			ModelMap modelMap) throws SQLException, BindException  {
			EntityReturnData ret = new EntityReturnData();
			ret.setMsg("执行成功");
			ret.setResult(true);
			AdminUser adminUser = SessionConstant.getAdminUserInSession(request);
			mailAddressList = mailAddressListService.doAddMailAddressList(mailAddressList, adminUser);
			ret.setEntity(mailAddressList);
			 
			return ret;
	}

}
