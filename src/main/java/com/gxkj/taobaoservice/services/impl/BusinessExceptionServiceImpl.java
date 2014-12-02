package com.gxkj.taobaoservice.services.impl;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.util.ClassUtils;
import com.gxkj.taobaoservice.daos.BusinessExceptionDao;
import com.gxkj.taobaoservice.entitys.BusinessException;
import com.gxkj.taobaoservice.services.BusinessExceptionService;
@Service
public class BusinessExceptionServiceImpl implements BusinessExceptionService {

	@Autowired
	private BusinessExceptionDao businessExceptionDao;
	
	public void insertEntity(BusinessException entity) throws SQLException {
		 
		businessExceptionDao.insert(entity);
	}

 
	public  BusinessException initBusinessException(Class<?> clazz, String methodName,BusinessExceptionInfos type,String paramString,Integer userid) {
		String classPath =  ClassUtils.getClassPath(clazz);
		 
		BusinessException entity = new BusinessException();
		entity.setClassPath(classPath);
		entity.setCreateTime(new Date());
		entity.setMethodName(methodName);
		entity.setType(type);
		entity.setParamString(paramString);
		entity.setUserId(userid);
		return entity;
	}
	
}
