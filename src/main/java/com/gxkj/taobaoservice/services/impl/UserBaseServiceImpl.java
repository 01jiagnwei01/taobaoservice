package com.gxkj.taobaoservice.services.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.common.util.PWDGenter;
import com.gxkj.common.util.StringMatchUtil;
import com.gxkj.taobaoservice.daos.OperateLogDao;
import com.gxkj.taobaoservice.daos.UserAccountDao;
import com.gxkj.taobaoservice.daos.UserBaseDao;
import com.gxkj.taobaoservice.daos.UserLinkDao;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;
import com.gxkj.taobaoservice.entitys.OperateLog;
import com.gxkj.taobaoservice.entitys.UserAccount;
import com.gxkj.taobaoservice.entitys.UserBase;
import com.gxkj.taobaoservice.entitys.UserLink;
import com.gxkj.taobaoservice.enums.OperateTypes;
import com.gxkj.taobaoservice.enums.RegProcessResult;
import com.gxkj.taobaoservice.enums.UserBaseStatus;
import com.gxkj.taobaoservice.enums.UserLinkStatus;
import com.gxkj.taobaoservice.enums.UserLinkTypes;
import com.gxkj.taobaoservice.services.BusinessExceptionService;
import com.gxkj.taobaoservice.services.UserBaseService;
import com.gxkj.taobaoservice.util.mail.MailSender;
@Service
public class UserBaseServiceImpl implements UserBaseService {

	private static final Log log = 
			LogFactory.getLog(UserBaseServiceImpl.class);

	@Autowired
	private UserBaseDao userBaseDao;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private OperateLogDao operateLogDao;
	
	@Autowired
	private UserLinkDao userLinkDao;
	
	@Autowired
	private BusinessExceptionService businessExceptionService;
	/**
	 * 前台用户注册接口
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public EntityReturnData addRegUser(RegObjDTO regObjDTO) throws SQLException, JsonGenerationException, JsonMappingException, IOException, AddressException, MessagingException  {
		
		EntityReturnData ret = new EntityReturnData();
		 ObjectMapper mapper = new ObjectMapper();  
		 
		boolean checkResult =  checkRegCondition(regObjDTO,ret);
		log.info(String.format("checkRegCondition checkResult=%s", checkResult));
		/**
		 * 验证不通过把验证结果返回
		 */
		if(!checkResult) return ret;
		Date now = new Date();
		/**
		 * 验证通过，数据入库
		 */
		UserBase userBase = new UserBase();
		userBase.setPassword(PWDGenter.generateKen(regObjDTO.getPassword()) );
		userBase.setUserName(regObjDTO.getUserName());
		userBase.setRegTime(now);
		userBase.setStatus(UserBaseStatus.WAIT_FOR_ACTIVE);
		userBaseDao.insert(userBase);
		log.info(String.format("inser into userBase =%s", mapper.writeValueAsString(userBase)));
		
		/**
		 * 联系方式
		 * 邮箱：默认待激活
		 */
		UserLink emailLink = new UserLink();
//		emailLink.setCreateTime(now);
		emailLink.setStatus(UserLinkStatus.WAIT_ACTIVE);;
		emailLink.setLinkType(UserLinkTypes.EMAIL);
		emailLink.setLinkValue(regObjDTO.getEmail());
		emailLink.setUserId(userBase.getId());
		userLinkDao.insert(emailLink);
		log.info(String.format("inser into emailLink =%s", mapper.writeValueAsString(emailLink)));
		userBase.getUserLinks().add(emailLink);
		
		 
		
		/**
		 * 保存用户账户信息
		 */
		UserAccount userAccount = new UserAccount();
		userAccount.setUserId(userBase.getId());
		userAccountDao.insert(userAccount);
		log.info(String.format("inser into userAccount =%s", mapper.writeValueAsString(userAccount)));
		userBase.setUerAccount(userAccount);
		
		/**
		 * 向邮箱发信,激活邮箱
		 */
		MailSender mailSender = new MailSender();
		Date days3Later = DateUtils.addDays(now, 3);
		int emailLinkId = emailLink.getId();
		String endtime = DateFormatUtils.format(days3Later, "yyyy-MM-dd HH:mm:ss");
		String content = String.format("endtime=%s&id=%d&email=%s", endtime,emailLinkId,regObjDTO.getEmail());
		mailSender.regSendEmail(regObjDTO.getEmail(), "信用网 邮箱验证 ", now, content);
		log.info(String.format("mailSender sender content =%s", content));
		/**
		 * 保存修改邮箱的记录
		 */
		OperateLog operateLog = new OperateLog();
		operateLog.setIp(regObjDTO.getIp());
		operateLog.setOperateTime(now);
		operateLog.setOperateType(OperateTypes.REG_EMAIL);
		operateLog.setAfterValue(regObjDTO.getEmail());
		operateLog.setUser_id(userBase.getId());
		operateLogDao.insert(operateLog);
		log.info(String.format("inser into operateLog =%s", mapper.writeValueAsString(operateLog)));
		/**
		 * 保存修改密码的操作
		 */
		OperateLog operateLog2 = new OperateLog();
		operateLog2.setIp(regObjDTO.getIp());
		operateLog2.setOperateTime(now);
		operateLog2.setOperateType(OperateTypes.REG_PASSWORD);
		operateLog2.setAfterValue(PWDGenter.generateKen(regObjDTO.getPassword()) );
		operateLog2.setUser_id(userBase.getId());
		operateLogDao.insert(operateLog2);
		log.info(String.format("inser into operateLog2 =%s", mapper.writeValueAsString(operateLog2)));
		
		ret.setResult(true);
		ret.setEntity(userBase);
		ret.setMsg("SUCCESS");
		return ret;
	}
	
	/**
	 * 1：判断邮箱是否为空，邮箱是否被使用
	 * 2：用户名是否为空，用户名是否被使用过
	 * 3: 密码是否为空，密码与确认密码是否一致，确认密码是否为空
	 * @param regObjDTO
	 * @param ret
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkRegCondition(RegObjDTO regObjDTO,EntityReturnData ret) throws SQLException{
		String userName = regObjDTO.getUserName();
		String email = regObjDTO.getEmail();
		String passowrd = regObjDTO.getPassword();
		String rePassword = regObjDTO.getRePassword();
		if(StringUtils.isBlank(userName)){
			ret.setMsg(RegProcessResult.USER_NAME_BLANK_FAILURE.toString());
			return false;
		}
		if(StringUtils.isBlank(email)){
			ret.setMsg(RegProcessResult.EMAIL_BLANK_FAILURE.toString());
			return false;
		}
		if(!StringMatchUtil.isEmail(email)){
			ret.setMsg(RegProcessResult.EMAIL_ERROR_FAILURE.toString());
			return false;
		}
		if(StringUtils.isBlank(passowrd)){
			ret.setMsg(RegProcessResult.PASSWORD_BLANK_FAILURE.toString());
			return false;
		}
		if(StringUtils.isBlank(rePassword)){
			ret.setMsg(RegProcessResult.REPASSWORD_BLANK_FAILURE.toString());
			return false;
		}
		if (!rePassword.equals(passowrd)){
			ret.setMsg(RegProcessResult.PASSWORD_NOT_EQUAL_REPASSWORD_FAILURE.toString());
			return false;
		}
		
		
		List<UserBase> users =userBaseDao.getUsersByUserName(userName);
		if(CollectionUtils.isNotEmpty(users)){
			ret.setMsg(RegProcessResult.USER_NAME_IS_USED_FAILURE.toString());
			return false;
		}
		List<UserLink> emailLinks =  userLinkDao.getUsersByEmail(email);
		if(CollectionUtils.isNotEmpty(emailLinks)){
			ret.setMsg(RegProcessResult.EMAIL_IS_USED_FAILURE.toString());
			return false;
		}
		return true;
	}

	/**
	 * 用户登陆操作  
	 * @throws SQLException 
	 * @throws BusinessException 
	 */
	public UserBase doLogin(String username, String password) throws SQLException, BusinessException {
		if(StringUtils.isBlank(username)){
			 return null;
		}else if(StringUtils.isBlank(password)){
			return null;
		} 
		
		List<UserBase>  userBases =   userBaseDao.getUsersByUserName(username);
		if(CollectionUtils.isEmpty(userBases)){
			return null;
		}
		password = PWDGenter.generateKen(password);
		UserBase userBase = userBases.get(0);
		if(!userBase.getPassword().equals(password)){
			return null;
		}
		if(userBase.getStatus() != UserBaseStatus.NORMAL){
			return userBase;
		}
		//查看该用户的帐务信息 
		UserAccount uerAccount = userAccountDao.getUserAccountByUserId(userBase.getId());
		if(uerAccount == null){
			
			com.gxkj.taobaoservice.entitys.BusinessException fentity = businessExceptionService.initBusinessException(this.getClass(), Thread.currentThread().getStackTrace()[1].getMethodName()
					, BusinessExceptionInfos.NO_USER_ACCOUNT_BY_USERID, "{username:"+username+"}", userBase.getId());
			businessExceptionService.insertEntity(fentity);
			
			throw new BusinessException(BusinessExceptionInfos.NO_USER_ACCOUNT_BY_USERID);
		}
		userBase.setUerAccount(uerAccount);
		
		/**
		 * 查看用户联系方式 
		 */
		List<UserLink> userLinks = userLinkDao.getUsersByUserId(userBase.getId());
		userBase.setUserLinks(userLinks);
		
		return userBase;
	}

}
