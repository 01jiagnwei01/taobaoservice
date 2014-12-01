package com.gxkj.taobaoservice.util.mail;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.gxkj.taobaoservice.dto.EmailExcuteResult;
import com.gxkj.taobaoservice.util.maildemo.SimpleMailSender;

public class MailSender {
	
	private String userName = "01jiangwei01@163.com";
	
	private String password = "xubaoyong200096";
	
	/**
     * 服务邮箱
     */
    private static SimpleMailSender serviceSms = null;
	
	public EmailExcuteResult  sendMail(List<String> emails,String subject,String content){
		serviceSms = this.getSimpleMailSender();
		EmailExcuteResult ret = new EmailExcuteResult();
		 for (String mail : emails) {
			 try {
				serviceSms.send(mail, subject, content);
			} catch (AddressException e) {
				e.printStackTrace();
				ret.addressErrorMails.add(mail);
			} catch (MessagingException e) {
				e.printStackTrace();
				ret.otherErrorMails.add(mail);
			}
		 }
		return ret;
	};
	
	public SimpleMailSender getSimpleMailSender(){
		if(serviceSms == null){
			serviceSms = new SimpleMailSender(userName,
					password);
		}
		return serviceSms;
	}

}
