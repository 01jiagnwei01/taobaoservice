package com.gxkj.taobaoservice.enums;

public enum MailSenderStatus {
	NEW("新建"),PROCESS("处理中"),SUCCESS("成功"),FAILURE ("失败");
	
	private String name; 
	
	private MailSenderStatus(String name ) {  
		       this.name = name; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
