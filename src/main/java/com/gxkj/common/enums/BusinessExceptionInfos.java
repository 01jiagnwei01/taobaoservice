package com.gxkj.common.enums;

public enum BusinessExceptionInfos {

	NO_USER_FOUND_BY_ID("1","根据ID没有找到用户 "),
	NO_USER_ACCOUNT_BY_USERID("2","根据USERID没有找到用户账号信息 "),
	EMAIL_DUPLICATE_EXIST("3","邮箱重复存在 "),
	RECHARDAPPLY_STATUS_NOT_WAIT_FOR("4","申请充值的记录的状态不是待审核状态 "),
	THIRDORDERNO_IS_USED("5","该流水号已经被使用过且充值成功");
	
	private String errorCode; 
	
	private String errorMsg;
	
	private BusinessExceptionInfos(String errorCode, String errorMsg) {  
		       this.errorCode = errorCode; 
		       this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	 
}
