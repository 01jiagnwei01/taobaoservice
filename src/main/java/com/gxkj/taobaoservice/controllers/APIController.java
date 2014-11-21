package com.gxkj.taobaoservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {

	@RequestMapping(method = RequestMethod.GET, value = "/say")
	@ResponseBody
	public String sayhello(String arg){
		return String.format("hello %s", arg);
	} 
	
	public static void main(String[] args) {
		System.out.println("hello world");

	}

}
