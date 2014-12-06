package com.gxkj.common.exceptions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gxkj.taobaoservice.dto.EntityReturnData;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver  {
	
	protected ModelAndView doResolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) { 
		 
		 String viewName = determineViewName(ex, request); 
		 if (viewName != null) {// JSP格式返回  
	            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request  
	                    .getHeader("X-Requested-With")!= null && request  
	                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  
	                // 如果不是异步请求  
	                // Apply HTTP status code for error views, if specified.  
	                // Only apply it if we're processing a top-level request.  
	                Integer statusCode = determineStatusCode(request, viewName);  
	                if (statusCode != null) {  
	                    applyStatusCodeIfPossible(request, response, statusCode);  
	                }  
	                return getModelAndView(viewName, ex, request);  
	            } else {// JSON格式返回  
	                try { 
	                	ObjectMapper mapper = new ObjectMapper();
	                	EntityReturnData json = new EntityReturnData();
	                	response.setContentType("text/javascript;charset=UTF-8");  
	                    PrintWriter writer = response.getWriter(); 
	                   
	                    if (ex instanceof  BusinessException){
	                    	json.setMsg(  ex.getMessage());
	    				}else {
	    					 
	    					json.setMsg(   "系统问题,请找技术人员解决");
	    				}
	                    writer.write(mapper.writeValueAsString(json));  
	                    writer.flush();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	                return null;  
	            }  
	        } else {  
	            return null;  
	        }  
	}


}
