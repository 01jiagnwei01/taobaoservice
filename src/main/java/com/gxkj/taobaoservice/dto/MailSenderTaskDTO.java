package com.gxkj.taobaoservice.dto;

import java.util.List;

import com.gxkj.taobaoservice.entitys.MailSenderTask;

public class MailSenderTaskDTO extends MailSenderTask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5381460597597202134L;
	
	private List<ShouJianRen> shouJianRen = null;

	public List<ShouJianRen> getShouJianRen() {
		return shouJianRen;
	}

	public void setShouJianRen(List<ShouJianRen> shouJianRen) {
		this.shouJianRen = shouJianRen;
	}
	
	

}
