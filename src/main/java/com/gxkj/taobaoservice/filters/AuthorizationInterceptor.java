package com.gxkj.taobaoservice.filters;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
//import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxkj.common.annotation.WithoutAuthorize;
import com.gxkj.common.util.SystemGlobals;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.SessionConstant;
import com.gxkj.taobaoservice.entitys.AdminUser;

 
 

public class AuthorizationInterceptor extends HandlerInterceptorAdapter  {

	 
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
 
		 super.afterCompletion(arg0, arg1, arg2, arg3) ;  
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		 
		super.postHandle(arg0, arg1, arg2, arg3) ;  
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse response,
			Object arg2) throws Exception {
		String url = req.getRequestURI();
		String ctx = req.getContextPath();
		url = url.replace(ctx, "");
		
		
		if(arg2 !=null  ){
			Class<? extends Object> clazz =  arg2.getClass();
			if(clazz.isAnnotationPresent(WithoutAuthorize.class)){
				return true;
			} 
		}
		if(url.indexOf("/exception")>=0){
			return true;
			
		}
		if(url.indexOf("/admin")>=0){
			//管理员过滤
			if(url.indexOf("login")>=0 || url.indexOf("dologin")>=0 || url.indexOf("logout")>=0){
				return true;
			}
			AdminUser user = SessionConstant.getAdminUserInSession(req);
			if(user == null){
				//无权限
				response.sendRedirect(req.getContextPath() +"/admin/login");
				return false;
			}
			if(SystemGlobals.getPreference("system.admin.allow.urls").indexOf(","+url+",")>=0){
				return true;
			}
			 
			String authPath = user.getMenupaths();
			if(authPath.indexOf(";"+url+";")>=0){
				return true;
			}
			String requestType = req.getHeader("X-Requested-With");
			if(StringUtils.isNotBlank(requestType )){
				//是ajax请求，返回json对象
				ObjectMapper mapper = new ObjectMapper();
            	EntityReturnData json = new EntityReturnData();
            	json.setMsg("您没有权限"); 
				 response.setContentType("text/javascript;charset=UTF-8");   
				 PrintWriter writer = response.getWriter();   
				 writer.write(mapper.writeValueAsString(json));  
				
			} else{
				response.sendRedirect(req.getContextPath()+"/exception/noauth");
			}
		}else {
			//前台来的
			return true;
		}
		
		
		return false;
	}

}
