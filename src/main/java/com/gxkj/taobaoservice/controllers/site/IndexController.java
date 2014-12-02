package com.gxkj.taobaoservice.controllers.site;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gxkj.common.util.Encrypt;
import com.gxkj.taobaoservice.constants.EncryptKey;
import com.gxkj.taobaoservice.enums.UserLinkActiveResult;
import com.gxkj.taobaoservice.services.UserLinkService;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired
	private UserLinkService userLinkService;
	/**
	 * 前台首页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "site/index";
		return mv;	
	}
	
	/**
	 * 邮箱激活帐户 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/email_active",method=RequestMethod.GET)
	public String emailActive(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,
			@RequestParam("data")	String data){
		
		String mv = "site/index";
		
		if(StringUtils.isBlank(data)){
			modelMap.put("error", "您输入的有问题");
			mv = "error/active_error";
			return mv;	
		}
		Encrypt encrypt = new Encrypt();
		encrypt.setKey(EncryptKey.encryptKeyString); 
		encrypt.setDesString(data); 
		String mingWen=encrypt.getStrM(); //调用get函数获取解密后明文。
		String[] args = mingWen.split("&");
		if(args.length != 3){
			modelMap.put("error", "你属于非法操作哦");
			mv = "error/active_error";
			return mv;
		}
		
		String endtime = args[0];
		String id = args[1];
		String email = args[2];
		if(StringUtils.isBlank(endtime) || StringUtils.isBlank(id) || StringUtils.isBlank(email)){
			modelMap.put("error", "你属于非法操作哦");
			mv = "error/active_error";
			return mv;
		}
		Integer id_Integer = Integer.parseInt(id);
		try {
			Date endtime_date = DateUtils.parseDateStrictly(endtime, new String[]{"yyyy-MM-dd HH:mm:ss"});
			UserLinkActiveResult userLinkActiveResult = userLinkService.activeEmail(email, id_Integer, endtime_date);
			if(userLinkActiveResult == UserLinkActiveResult.HAVE_PASS_ACTIVE_DATE_FAILER){
				modelMap.put("error", userLinkActiveResult.getName());
				mv = "error/active_error";
				return mv;
			}else if(userLinkActiveResult == UserLinkActiveResult.SUCCESS){
				/**
				 * 此处要做登陆操作 
				 * undo
				 */
				mv = "/";
				return mv;
			}
		} catch (Exception e) {
			modelMap.put("error", "你属于非法操作哦");
			mv = "site/active_error";
			return mv;	
		}
		
		
		return mv;	
	}
	
	
	
	
	
	
}
