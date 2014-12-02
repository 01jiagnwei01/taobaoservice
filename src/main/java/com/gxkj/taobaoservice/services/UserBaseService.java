package com.gxkj.taobaoservice.services;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;
import com.gxkj.taobaoservice.entitys.UserBase;

public interface UserBaseService {

	/**
	 * 用户注册
	 * @param regObjDTO
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	EntityReturnData addRegUser(RegObjDTO regObjDTO)throws SQLException, JsonGenerationException, JsonMappingException, IOException, AddressException, MessagingException ;

	/**
	 * 用户登陆 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException 
	 * @throws BusinessException 
	 */
	UserBase doLogin(String username, String password) throws SQLException, BusinessException;
	
	

}
