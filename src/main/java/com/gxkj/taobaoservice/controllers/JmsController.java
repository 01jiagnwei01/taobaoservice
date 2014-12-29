package com.gxkj.taobaoservice.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gxkj.taobaoservice.amqps.in.TempConverter;
import com.gxkj.taobaoservice.dto.EntityReturnData;
@Controller
@RequestMapping("/jms")
public class JmsController {
	
	//private MessageProducer messageProducer;
	
	private  TempConverter converter;; 
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String path(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		 return "demo/jms_client";
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public EntityReturnData path_post(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		EntityReturnData entity = new EntityReturnData();
		Date a = new Date();  
        long b = System.currentTimeMillis();  
        for (int i = 0; i <= 10000; i++) {  
           // messageProducer.sendMessage(i);  
        	 System.out.println(converter.fahrenheitToCelcius(68.0f));
        }  
        System.out.println(a);  
        System.out.println(new Date());  
        System.out.println("共花了" + (System.currentTimeMillis() - b) + "ms");  
		 return entity;
	}

}
