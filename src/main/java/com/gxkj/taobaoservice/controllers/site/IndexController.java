package com.gxkj.taobaoservice.controllers.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class IndexController {

	/**
	 * 前台首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/index";
		return mv;	
	}
	
	
	
	
	
	
}
