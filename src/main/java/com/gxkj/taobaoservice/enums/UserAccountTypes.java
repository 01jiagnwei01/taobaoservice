package com.gxkj.taobaoservice.enums;

public enum UserAccountTypes {
	DEPOSIT("充值"),WITHDRAW("取款"),BUYPOINTS("买点"),POINTS2MONEY("点兑钱"),
	PUBLISH_TASK ("发布任务"),FINISH_TASK("发布任务"),CANCLE_TASK("任务取消"),
	ADMINISTRATOR_INTERVENTION("管理员干预");
	
	private String name; 
	private UserAccountTypes(String name ) {  
		       this.name = name; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}
