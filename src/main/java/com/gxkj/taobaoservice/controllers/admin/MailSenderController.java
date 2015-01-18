package com.gxkj.taobaoservice.controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gxkj.taobaoservice.services.MailSenderService;

@Controller
@RequestMapping("/admin/mail/sender")
public class MailSenderController {
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "admin/mail/mailsender";
		return mv;
	}

}
