package com.gxkj.taobaoservice.controllers.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/login";
		return mv;	
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String dologin(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/login";
		return mv;	
	}
}
