package com.gxkj.taobaoservice.controllers.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reg")
public class RegController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String reg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/reg";
		return mv;	
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String doreg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/reg";
		return mv;	
	}
}
