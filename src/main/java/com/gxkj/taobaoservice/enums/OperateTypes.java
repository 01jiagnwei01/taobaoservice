package com.gxkj.taobaoservice.enums;

public enum OperateTypes {
	REG_PASSWORD("注册设置密码"),
	REG_EMAIL("注册设置邮箱"),
	UPDATE_PASSWORD("修改密码"),
	UPDATE_PHONE("修改手机号码"),
	UPDATE_EMAIL("修改邮箱"),
	UPDATE_QQ("修改QQ"),
	ACTIVE_EMAIL("邮箱激活"),
	FIND_PASSWORD_SEND_EMAIL("找回密码发送邮件") ;
	
	private String name; 
	private OperateTypes(String name ) {  
		       this.name = name; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	


}
