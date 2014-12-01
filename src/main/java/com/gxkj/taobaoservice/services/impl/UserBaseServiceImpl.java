package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.util.PWDGenter;
import com.gxkj.common.util.StringMatchUtil;
import com.gxkj.taobaoservice.daos.OperateLogDao;
import com.gxkj.taobaoservice.daos.UserAccountDao;
import com.gxkj.taobaoservice.daos.UserBaseDao;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;
import com.gxkj.taobaoservice.entitys.OperateLog;
import com.gxkj.taobaoservice.entitys.UserAccount;
import com.gxkj.taobaoservice.entitys.UserBase;
import com.gxkj.taobaoservice.enums.OperateTypes;
import com.gxkj.taobaoservice.services.UserBaseService;
@Service
public class UserBaseServiceImpl implements UserBaseService {

	@Autowired
	private UserBaseDao userBaseDao;
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Autowired
	private OperateLogDao operateLogDao;
	/**
	 * 前台用户注册接口
	 */
	public EntityReturnData addRegUser(RegObjDTO regObjDTO) throws Exception {
		
		EntityReturnData ret = new EntityReturnData();
		boolean checkResult =  checkRegCondition(regObjDTO,ret);
		/**
		 * 验证不通过把验证结果返回
		 */
		if(!checkResult) return ret;
		Date now = new Date();
		/**
		 * 验证通过，数据入库
		 */
		UserBase userBase = new UserBase();
		userBase.seteMail(regObjDTO.getEmail());
		userBase.setPassword(PWDGenter.generateKen(regObjDTO.getPassword()) );
		userBase.setUserName(userBase.getUserName());
		userBase.setRegTime(now);
		userBaseDao.insert(userBase);
		
		/**
		 * 保存用户账户信息
		 */
		UserAccount userAccount = new UserAccount();
		userAccount.setUserId(userBase.getId());
		userAccountDao.insert(userAccount);
		
		userBase.setUerAccount(userAccount);
		
		/**
		 * 向邮箱发信,激活邮箱
		 */
		
		/**
		 * 保存修改邮箱的记录
		 */
		OperateLog operateLog = new OperateLog();
		operateLog.setIp(regObjDTO.getIp());
		operateLog.setOperateTime(now);
		operateLog.setOperateType(OperateTypes.REG_EMAIL);
		operateLog.setAfterValue(userBase.geteMail());
		operateLog.setUser_id(userBase.getId());
		operateLogDao.insert(operateLog);
		
		/**
		 * 保存修改密码的操作
		 */
		OperateLog operateLog2 = new OperateLog();
		operateLog2.setIp(regObjDTO.getIp());
		operateLog2.setOperateTime(now);
		operateLog2.setOperateType(OperateTypes.REG_PASSWORD);
		operateLog2.setAfterValue(userBase.getPassword());
		operateLog2.setUser_id(userBase.getId());
		operateLogDao.insert(operateLog2);
		
		ret.setResult(true);
		ret.setEntity(userBase);
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
			ret.setMsg("user_name_blank");
			return false;
		}
		if(StringUtils.isBlank(email)){
			ret.setMsg("email_blank");
			return false;
		}
		if(!StringMatchUtil.isEmail(email)){
			ret.setMsg("email_error");
			return false;
		}
		if(StringUtils.isBlank(passowrd)){
			ret.setMsg("passowrd_blank");
			return false;
		}
		if(StringUtils.isBlank(rePassword)){
			ret.setMsg("rePassword_blank");
			return false;
		}
		if (rePassword.equals(passowrd)){
			ret.setMsg("password_and_repassword_not_equal");
			return false;
		}
		
		
		List<UserBase> users = userBaseDao.getUsersByUserName(userName);
		if(CollectionUtils.isNotEmpty(users)){
			ret.setMsg("user_name_is_used");
			return false;
		}
		List<UserBase> emailusers = userBaseDao.getUsersByEmail(email);
		if(CollectionUtils.isNotEmpty(emailusers)){
			ret.setMsg("email_is_used");
			return false;
		}
		return true;
	}

}
