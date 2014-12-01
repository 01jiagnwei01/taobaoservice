package com.gxkj.taobaoservice.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;
import com.gxkj.test.BaseSpringTest;

public class UserBaseServiceImplTest extends BaseSpringTest{
	/**
	 * 
	 */
	@Autowired
	private UserBaseService userBaseServiceImpl;
	
	@Test
	public void addRegUser() throws Exception {
		
		RegObjDTO regObjDTO = new RegObjDTO ();
		regObjDTO.setEmail("01jiangwei01@163.com");
		regObjDTO.setIp("127.0.0.1");
		regObjDTO.setPassword("123");
		regObjDTO.setRePassword("123");
		regObjDTO.setUserName("01jiangwei01");
		regObjDTO.setYanzhengma(null);
		EntityReturnData ret = userBaseServiceImpl.addRegUser(regObjDTO);
		System.out.println(ret.getMsg());
		
	}

}
