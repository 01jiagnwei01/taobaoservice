package com.gxkj.taobaoservice.services;

import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;

public interface UserBaseService {

	/**
	 * 用户注册
	 * @param regObjDTO
	 * @return
	 * @throws Exception
	 */
	EntityReturnData addRegUser(RegObjDTO regObjDTO)throws Exception;
	
	

}
