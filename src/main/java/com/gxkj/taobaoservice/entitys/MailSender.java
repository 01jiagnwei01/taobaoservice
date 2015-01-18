package com.gxkj.taobaoservice.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.gxkj.taobaoservice.enums.MailSenderStatus;
/**
 * 邮件发送任务
 * @author Administrator
 *
 */
@Entity
@Table(name = "mail_sender")
public class MailSender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5706118697478529778L;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false) 
	private Integer  id;
	
	/**
	 * 创建人ID 
	 */
	@Column(name = "create_user" ,   nullable = false) 
	private Integer  createUser;
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_time" ,   nullable = false)
	@Temporal(TemporalType.TIMESTAMP )
	private Date createTime;
	
	
	/**
	 * 邮件标题
	 */
	@Column(name = "title",length=100) 
	@NotEmpty(message="邮件标题不允许为空")
	private String  title;
	
	/**
	 * 邮件内容
	 */
	@Column(name = "content") 
	@Lob
	@NotEmpty(message="邮件内容不允许为空")
	private String content;
	
	/**
	 * 状态
	 */
	@Column(name = "status" ,   nullable = false)
	@Temporal(TemporalType.TIMESTAMP )
	private MailSenderStatus status;

}
