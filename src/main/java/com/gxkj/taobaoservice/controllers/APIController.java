package com.gxkj.taobaoservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String sayhello( ) throws Exception{
		 return "api/index";
	} 
	@RequestMapping(method = RequestMethod.GET, value = "/json")
	@ResponseBody
	public String getjson( @RequestParam(defaultValue = "" ,value="name") String name) throws Exception{
		 return String.format("{name:%s}",name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/exception")
	@ResponseBody
	public String exception( ) throws Exception{
		throw new Exception("error my god");
	} 
	
	public static void main(String[] args) {
		System.out.println("hello world");

	}

}
