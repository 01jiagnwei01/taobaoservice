<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.gxkj.common.util.SystemGlobals"%>
 <!DOCTYPE html>
<html lang="zh">
<head><%--  --%>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱内容管理 </title>
<%@include file="../../common/easyui-html5.jsp" %>
<script type="text/javascript">
var fenye = "${_adminUser_.btnMap.admin_mail_content_dopage}"== "true"?true:false;
var add = "${_adminUser_.btnMap.admin_mail_content_doadd}"== "true"?true:false;
var update = "${_adminUser_.btnMap.admin_mail_content_doupdate}"== "true"?true:false;
var del = "${_adminUser_.btnMap.admin_mail_content_dodel}"== "true"?true:false;
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center'">
		<table class="easyui-datagrid"   
					id ='dg' 
		           data-options="fit:true,fitColumns:true,border:false,rownumbers:true,checkOnSelect:true,singleSelect:true,pagination:true,
		           pageSize:20,url:'<%=request.getContextPath() %>/admin/mail/content/dopage?d='+new Date().getTime(),method:'POST'
		           ,onBeforeLoad:function(param){
		           
				param['pageno'] =  param['page']-1;
				param['pagesize']  = param['rows'];
				if(!fenye){
					alert('您没有查看权限');
					return false;
				 }
		  		return true ;
		  	},
		  	toolbar: '#tb',
				loadFilter:function(data){
					 
					var result = data.result;
					if(!result){
						return {total:0,rows:[]};
					}else {
						var obj = {
							total:data.entity.totalRows,
							rows:data.entity.pageData ?data.entity.pageData:[]
						};
						return obj;
					} 
				}
		           ">
		        <thead> 
		        	<tr>
								<th data-options="field:'id',width:30" >id</th>
								<th data-options="field:'templeteId',hidden:true"  >模板ID</th>
								<th data-options="field:'title',width:150"  >标题</th>
								<th data-options="field:'updateUserId',formatter:adminUserIdFormat,width:150"  >管理员</th>
								<th data-options="field:'updateTime',formatter:dateFormat"  >修改时间</th> 
					</tr>
					
				</thead>
			</table>
	</div>
	<div id="tb" style="padding:5px;height:auto">
		<table style="width:100%">
			<tr >
				<td width="50%">
					标题: <input class="easyui-spinner" style="width:160px" id="title"/>
					<a href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchFn()">查看</a>
				</td>
				<td align="right" width="50%">
					<a href="#"  class="easyui-linkbutton" id="addBtn"  data-options="iconCls:'add_btn',plain:true" onclick="addFn()">创建</a>
				</td>
				 
			</tr>
		</table>
	</div>
	 <div id="mail_w" class="easyui-window" title="系统管理员" data-options="modal:true,closed:true,iconCls:'icon-save',
		collapsible:false,minimizable:false,maximizable:false,resizable:false" 
			style="width:600px;height:420px;padding:10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',border:false" id="content_layout" >
				<form id="ff" method="post">
					 	<table>
					 		<tr style="display: none;">
				    			<td>id:</td>
				    			<td><input class="easyui-validatebox" type="text" id="id" name="id" data-options="required:false"></input></td>
				    		</tr>
				    		<tr>
				    			<td>标题:</td>
				    			<td>
				    				<input style="width:300px;" class="easyui-validatebox" type="text" id="form_title" name="title" data-options="required:true"></input>
				    			</td>
				    		</tr>
				    		<tr >
				    			<td>模板:</td>
				    			<td>
				    				 <input id="templeteid" name="roleid" class="easyui-combogrid" style="width:200px;" data-options="
										panelWidth: 380,
										textField: 'templeteName',
										idField:'id',
										editable:false,
										mode: 'remote',
										method:'post',
										fit:true,
										pageSize:20,
										url:'<%=request.getContextPath() %>/admin/mail/templete/dopage?d='+new Date().getTime(),
										method: 'post',
										columns: [[
											{field:'id',title:'id',width:80,hidden:true},
											{field:'templeteName',title:'名字',width:120} 
										]],
										fitColumns: true,
										pagination:true,
										pageSize:20,
										onBeforeLoad:function(param){
											 param['pageno'] =  param['page']-1;
											param['limit']  = param['rows'];
									  		return true ;
									  	},
									  	loadFilter:function(data){
											var result = data.result;
											if(!result){
												return {total:0,rows:[]};
											}else {
												var obj = {
													total:data.entity.totalRows,
													rows:data.entity.pageData ?data.entity.pageData:[]
												};
												return obj;
											} 
										}
									">
				    			</td>
				    		</tr>
				    		<tr>
				    			<td>邮件内容:</td>
				    			<td>
				    				<textarea rows="16" cols="56" id="content" name="content" ></textarea>
				    			</td>
				    		</tr>
				    	</table>
				 </form>
			 </div>
			 <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
					<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:submitFormFn()">保存</a>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:closeWinFn()">取消</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

$(function(){
 
});
function searchFn(){
	var title = $("#title").val(); 
	$('#dg').datagrid('load',{
		title:title, 
		d:new Date().getTime()
	});
}
function dateFormat(value,row,index){
	if(typeof value == 'undefined'){
		return value;
	}else if(typeof value == 'number'){
		return new Date(value).format("yyyy-MM-dd hh:mm:ss");
	}
}
function userIdFormat(value,row,index){
	if(typeof value == 'undefined'){
		return value;
	}
	 
	return row['userName']+"["+row['userId']+"]"
}
function adminUserIdFormat(value,row,index){
	if(typeof value == 'undefined'){
		return value;
	} 
	return row['adminName']+"["+row['adminUserId']+"]"
}
var saveType = "add";
function closeWinFn(){
			$('#mail_w').window('close');
}
function addFn(){
	saveType = "add";
	 $("#ff").form("reset");
	 $('#mail_w').window('open').panel('setTitle',"创建邮件");
}
function submitFormFn(){
	var u_id = $("#id").val();
	var title = $("#form_title").val();
	var content = $("#content").val();
	var templeteid = $('#templeteid').combogrid('getValue');
	var templeteName = $('#templeteid').combogrid('getText'); 
	var saveObj = {};
	saveObj.id=$.trim(u_id).length==0?0:u_id;
	saveObj.templeteId= templeteid;
	saveObj.content=content;
	saveObj.title = title;
	 
	if(saveType == 'add'){ insertIntoDb(saveObj); }else if(saveType == 'update'){ updateIntoDb(saveObj); }
}
function insertIntoDb(saveObj){
	var url =  "<%=request.getContextPath()%>/admin/mail/content/doadd";
  	 $.ajax({
  	  	  type:'post',
		  url: url,
		  context: document.body,
		  data:saveObj,
		  success:function(json){
		   
		   	 var result = json.result;
		   	 var entity = json.entity;
		   	 if(result){
		   		 $('#dg').datagrid('appendRow',entity);
			 	 $.messager.alert('系统提示','保存成功!','info',closeWinFn);
		   	 }else{
		   		$.messager.alert('系统提示','保存失败，请刷新后重试!','error');
		   	 }
		 	
		  },
		  error:function(xhr,textStatus,errorThrown){
		  		var responseText = xhr.responseText;
		    	try{
		    		var json = $.parseJSON(responseText);
		    		var msg = json.msg;
		    		if(typeof  msg == 'string' && msg.indexOf("errorMsg")>0 ){
		    			var msgArray = [];
		    			msg = eval("("+msg+")");
		    			for (var i=0;i<msg.length;i++){
		    				var d = msg[i] ;
		    				msgArray.push(d['errorMsg']);
		    			}
		    			$.messager.alert('系统提示','保存失败\r\n'+msgArray.join("\r\n"),'error');
		    		}else{
		    			$.messager.alert('系统提示','保存失败\r\n'+msg,'error');
		    		}
		    	 
		    		
		    	}catch(error){
		    		alert(error);
		    		$.messager.alert('系统提示','保存失败，请刷新后重试!','error');
		    	}
		  
		  } 
	});
}
function updateIntoDb(saveObj){
	var url =  "<%=request.getContextPath() %>/admin/mail/content/doupdate";
  	 $.ajax({
  	  	  type:'post',
		  url: url,
		  context: document.body,
		  data:saveObj,
		  success:function(json){
			  //json = $.parseJSON(json);
			   	 var result = json.result;
			   	 var entity = json.entity;
			   	if(result){
			   		$('#dg').datagrid('updateRow',{
				  	 	index:updateRowIndex,
				  	 	row:entity
				  	 });
				  	  $('#dg').datagrid('selectRow',updateRowIndex);
				 	 $.messager.alert('系统提示','保存成功!','info',closeWinFn);
			   	 }else{
			   		$.messager.alert('系统提示','保存失败，请刷新后重试!','error');
			   	 }
			   	
			  	 
			
		  },
		  error:function(xhr,textStatus,errorThrown){
		  		var responseText = xhr.responseText;
		    	try{
		    		var json = $.parseJSON(responseText);
		    		var msg = json.msg;
		    		$.messager.alert('系统提示','保存失败,'+msg,'error');
		    	}catch(error){
		    		alert(22);
		    		$.messager.alert('系统提示','保存失败，请刷新后重试!','error');
		    	}
		  
		  } 
	});
}
	</script>
</html>