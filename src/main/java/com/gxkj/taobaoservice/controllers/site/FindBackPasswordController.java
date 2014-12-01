package com.gxkj.taobaoservice.controllers.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/findbackpassword")
public class FindBackPasswordController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String findbackpassword_GET(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/findbackpassword";
		return mv;	
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public String findbackpassword_POST(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/findbackpassword";
		return mv;	
	}
}
