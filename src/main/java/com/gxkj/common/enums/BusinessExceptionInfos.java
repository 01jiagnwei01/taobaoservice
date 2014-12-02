package com.gxkj.common.enums;

public enum BusinessExceptionInfos {

	NO_USER_FOUND_BY_ID("1","根据ID没有找到用户 ") ;
	
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
