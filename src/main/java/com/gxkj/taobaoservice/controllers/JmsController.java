package com.gxkj.taobaoservice.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Autowired
	@Qualifier("simpleGateway")
	private  TempConverter converter;
	
	@Autowired
	@Qualifier("wsGateway")
	private  TempConverter wsGateway;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String path(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		 return "demo/jms_client";
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public EntityReturnData path_post(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		EntityReturnData entity = new EntityReturnData();
	 
		System.out.println(converter.fahrenheitToCelcius(68.0f));
		
		 System.out.println(wsGateway.fahrenheitToCelcius(68.0f));
		
		 entity.setResult(true);
		 entity.setMsg("ok");
		 return entity;
	}

}
