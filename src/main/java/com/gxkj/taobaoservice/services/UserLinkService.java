package com.gxkj.taobaoservice.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.taobaoservice.enums.UserLinkActiveResult;

public interface UserLinkService {

	
	UserLinkActiveResult activeEmail(String email,int id,Date endDate)throws SQLException, JsonGenerationException, JsonMappingException, IOException, BusinessException;
}
