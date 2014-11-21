package com.gxkj.taobaoservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class APIController {

	@RequestMapping(method = RequestMethod.GET, value = "/say/{userName}")
	@ResponseBody
	public String sayhello(@PathVariable(value = "userName") String userName, @RequestParam(defaultValue = "") String name){
		return String.format("hello %s  %s", userName,name);
	} 
	
	public static void main(String[] args) {
		System.out.println("hello world");

	}

}
