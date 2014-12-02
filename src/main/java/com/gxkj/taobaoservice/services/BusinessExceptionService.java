package com.gxkj.taobaoservice.services;

import java.sql.SQLException;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.taobaoservice.entitys.BusinessException;

public interface BusinessExceptionService {
	
	public void insertEntity(BusinessException entity) throws SQLException;
	
	public BusinessException initBusinessException(Class<?> clazz,String methodName,BusinessExceptionInfos type,String params,Integer userid);

}
