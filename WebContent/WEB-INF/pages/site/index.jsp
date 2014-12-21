<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gxkj.taobaoservice.entitys.*,com.gxkj.common.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>前台首页</h1>
<hr/>
<%
UserBase userBase = SessionUtil.getSiteUserInSession(request);
if(userBase != null){
	out.println("您已经登录<a href='"+request.getContextPath()+"/home"+"'>"+userBase.getUserName()+"</a>");
	out.println("<br/><a href='"+request.getContextPath()+"/taskorder/new"+"'>发布任务</a>");
	out.println("<hr/>");
}
%>
<br/>
<a href="<%=request.getContextPath()%>/reg">注册页面</a><br/>
<a href="<%=request.getContextPath()%>/login">登陆页面</a><br/>
<a href="<%=request.getContextPath()%>/findbackpassword">找回密码</a><br/>
</body>
</html>