package com.gxkj.taobaoservice.controllers.admin;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.enums.MailSenderStatus;
import com.gxkj.taobaoservice.services.MailSenderTaskService;

@Controller
@RequestMapping("/admin/mail/sendertask")
public class MailSenderTaskController {
	
	@Autowired
	private MailSenderTaskService mailSenderService;
	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "admin/mail/mailsendertask";
		return mv;
	}
	
	@RequestMapping(value="/dopage",method={RequestMethod.POST})
	 @ResponseBody
 public EntityReturnData doPage( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="pageno",defaultValue="0") int pageno,
			@RequestParam(value="limit",defaultValue="20") int pagesize,
			@RequestParam(value="title",defaultValue="") String title ,
			@RequestParam(value="createUser",defaultValue="0") Integer createUser ,
			@RequestParam(value="status",required=false) MailSenderStatus status ,
			
			ModelMap modelMap) throws SQLException  {
			EntityReturnData ret = new EntityReturnData();
			ret.setMsg("执行成功");
			ret.setResult(true);
		
			ListPager paper = mailSenderService.doPage(pageno, pagesize, title,status,createUser);
			ret.setEntity(paper);
			return ret;
	}

}
