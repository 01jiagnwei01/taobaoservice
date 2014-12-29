<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.gxkj.common.util.SystemGlobals"%>
 <!DOCTYPE html>
<html lang="zh">
<head><%--  --%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<%@include file="../common/easyui-html5.jsp" %>
</head>
<body>

 <input type="button" value ="提交" onclick="sendMsg()">
<script type="text/javascript">

function sendMsg(){
	var url = "<%=request.getContextPath() %>/jms";
		 $.ajax({
	  	  type:'post',
	  url: url,
	  data:{
	  	 
	  },
	  context: document.body,
	  success:function(json){
	 	 
	 	 alert(json);
		
	  },
	  error:function(xhr,textStatus,errorThrown){
	  		var responseText = xhr.responseText;
	    	$.messager.alert('系统提示',' 失败 !','error');
	  
	  } 
});
	
}
</script>
</body>
</html>