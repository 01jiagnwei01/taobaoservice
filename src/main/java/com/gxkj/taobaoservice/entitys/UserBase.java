package com.gxkj.taobaoservice.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_base")
public class UserBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5273424711942109501L;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false) 
	private int id;
	
	/**
	 * 用户名
	 */
	@Column(name="user_name" )
	private String userName;
	
	/**
	 * 密码
	 */
	@Column(name="password" )
	private String password;
	
	/**
	 * 手机
	 */
	@Column(name="tel" )
	private String telPhone;
	
	/**
	 * 邮箱
	 */
	@Column(name="e_mail" )
	private String eMail;

	/**
	 * qq
	 */
	@Column(name="qq" )
	private String qq;
	
	/**
	 * 注册时间
	 */
	@Column(name="regTime")
	@Temporal(TemporalType.TIMESTAMP )
	private Date regTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	
	
}
