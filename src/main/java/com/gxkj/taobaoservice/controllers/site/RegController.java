package com.gxkj.taobaoservice.controllers.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.common.enums.BusinessExceptionInfos;
import com.gxkj.common.exceptions.BusinessException;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.RegObjDTO;
import com.gxkj.taobaoservice.services.UserBaseService;

@Controller
@RequestMapping("/reg")
public class RegController {
	
	@Autowired
	private UserBaseService userBaseService;

	@RequestMapping(value="",method=RequestMethod.GET)
	public String reg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/reg";
		return mv;	
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public EntityReturnData doreg(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,RegObjDTO regObjDTO) throws BusinessException{
		 
//		EntityReturnData ret = new EntityReturnData();
//		String yanzhengma = regObjDTO.getYanzhengma();
//		if(StringUtils.isBlank(yanzhengma) || !yanzhengma.equals(request.getSession().getAttribute(RandomValidateCode.RANDOMCODEKEY))){
//			throw new BusinessException(BusinessExceptionInfos.Yan_Zheng_MA_ERROR);
//		}
//		String ip = request.getRemoteAddr();
//		regObjDTO.setIp(ip);
//		try {
//			ret =   userBaseService.addRegUser(regObjDTO);
//		} catch (Exception e) {
//			if(e instanceof AddressException){
//				throw new BusinessException(BusinessExceptionInfos.EMAIL_ADDRESS_IS_ERROR);
//			}
//			e.printStackTrace();
//			 
//			throw new BusinessException(BusinessExceptionInfos.ADMIN_IS_MAINTING);
//		}
//		return ret;	
		throw new BusinessException(BusinessExceptionInfos.EMAIL_ADDRESS_IS_ERROR);
	}
}
