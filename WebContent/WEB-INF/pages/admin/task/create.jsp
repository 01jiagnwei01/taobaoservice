<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.gxkj.common.util.SystemGlobals"%>
 <!DOCTYPE html>
<html lang="zh">
<head><%--  --%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建任务 </title>
<%@include file="../../common/easyui-html5.jsp" %>
</head>
<body class="easyui-layout">
	 <div data-options="region:'center'">
		 
	</div>
	 
</body>
<script type="text/javascript">
var addUserBtn = "${_adminUser_.btnMap.userdoadd}"== "true"?true:false;
var updateUserBtn = "${_adminUser_.btnMap.userdoupdate}"== "true"?true:false;
var userdodel = "${_adminUser_.btnMap.userdodel}"== "true"?true:false;
var userdopage = "${_adminUser_.btnMap.userdopage}"== "true"?true:false;
var usersetpassword = "${_adminUser_.btnMap.usersetpassword}"== "true"?true:false;


$(function(){
	 
});
 

	</script>
</html>