package com.gxkj.taobaoservice.services.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.taobaoservice.daos.OperateLogDao;
import com.gxkj.taobaoservice.daos.UserBaseDao;
import com.gxkj.taobaoservice.daos.UserLinkDao;
import com.gxkj.taobaoservice.entitys.OperateLog;
import com.gxkj.taobaoservice.entitys.UserBase;
import com.gxkj.taobaoservice.entitys.UserLink;
import com.gxkj.taobaoservice.enums.OperateTypes;
import com.gxkj.taobaoservice.enums.UserBaseStatus;
import com.gxkj.taobaoservice.enums.UserLinkActiveResult;
import com.gxkj.taobaoservice.enums.UserLinkStatus;
import com.gxkj.taobaoservice.services.UserLinkService;
@Service
public class UserLinkServiceImpl implements UserLinkService {

	private static final Log log = 
			LogFactory.getLog(UserLinkServiceImpl.class);
	
	@Autowired
	private UserLinkDao userLinkDao;
	@Autowired
	private UserBaseDao userBaseDao;
	
	@Autowired
	private OperateLogDao operateLogDao;
	
	 
	/**
	 * 邮箱激活 
	 */
	public UserLinkActiveResult activeEmail(String email, int id, Date endDate) throws SQLException, JsonGenerationException, JsonMappingException, IOException,BusinessException {
		 
		Date now = new Date();
		if(endDate == null){
			return UserLinkActiveResult.HAVE_PASS_ACTIVE_DATE_FAILER;
		}
		else if(!now.after( endDate)){
			return UserLinkActiveResult.HAVE_PASS_ACTIVE_DATE_FAILER;
		}
		UserLink userLink = userLinkDao.getUserLinkByIdAndEmail(id,email);
		if(userLink == null){
			return UserLinkActiveResult.ID_OR_EMAIL_ERRORE_FAILER;
		}
		 ObjectMapper mapper = new ObjectMapper();  
		 
		userLink.setActiveTime(now);
		userLink.setStatus(UserLinkStatus.NORMAL);
		userLinkDao.update(userLink);
		 
		log.info(String.format("update userLink=%s", mapper.writeValueAsString(userLink)));
		
		int userId = userLink.getUserId();
		UserBase userBase = (UserBase) userBaseDao.selectById(userId, UserBase.class);
		if(userBase == null){
			throw new BusinessException(BusinessExceptionInfos.NO_USER_FOUND_BY_ID);
		}
		userBase.setStatus(UserBaseStatus.NORMAL);
		userBaseDao.update(userBase);
		log.info(String.format("update userBase=%s", mapper.writeValueAsString(userBase)));
		
		OperateLog operateLog = new OperateLog();
		operateLog.setOperateTime(now);
		operateLog.setOperateType(OperateTypes.ACTIVE_EMAIL);
		operateLog.setBeforeValue(userLink.getLinkValue());
		operateLog.setAfterValue(userLink.getLinkValue());
		operateLog.setUser_id(userBase.getId());
		operateLogDao.insert(operateLog);
		 
		return UserLinkActiveResult.SUCCESS;
	}

}
