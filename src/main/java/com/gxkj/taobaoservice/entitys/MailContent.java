package com.gxkj.taobaoservice.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.gxkj.taobaoservice.enums.MailContentStatus;
@Entity
@Table(name = "mail_content")
public class MailContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3783367733494228252L;
	
	// 主键 ：@Id    主键生成方式：strategy = "increment"
		//映射表中id这个字段，不能为空，并且是唯一的
		@GenericGenerator(name = "generator", strategy = "increment")
		@GeneratedValue(generator = "generator")
		@Id
		@Column(name = "id", unique = true, nullable = false) 
		private Integer  id;
		
		
		/**
		 * 模板ID
		 */
		@Column(name = "templete_id",  nullable = false,length=10) 
		private String templeteId;
		
		/**
		 * 邮件内容
		 */
		@Column(name = "content") 
		@Lob
		private String content;
		/**
		 * 邮件标题
		 */
		@Column(name = "title",length=100) 
		@Lob
		private String title ;
		
		@Column(name = "update_time",   nullable = false ) 
		private Date updateTime;
		
		/**
		 * 状态
		 */
		@Column(name = "status",   nullable = false ) 
		@Enumerated(EnumType.STRING)
		private MailContentStatus status;
		
		@Column(name = "updateUserId",   nullable = false )
		private int updateUserId;
		
		@Transient
		private String updateUserName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTempleteId() {
			return templeteId;
		}

		public void setTempleteId(String templeteId) {
			this.templeteId = templeteId;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public MailContentStatus getStatus() {
			return status;
		}

		public void setStatus(MailContentStatus status) {
			this.status = status;
		}

		public int getUpdateUserId() {
			return updateUserId;
		}

		public void setUpdateUserId(int updateUserId) {
			this.updateUserId = updateUserId;
		}

		public String getUpdateUserName() {
			return updateUserName;
		}

		public void setUpdateUserName(String updateUserName) {
			this.updateUserName = updateUserName;
		}
		
		

}
