package com.gxkj.taobaoservice.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gxkj.taobaoservice.enums.GoodCommentTimeLimits;

/**
 * 创建任务订单 
 */
@Entity
@Table(name="task_order")
public class TaskOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3560729988994035043L;
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false) 
	private Integer id;
	
	/**
	 * 用户ID
	 */
	@Column(name="user_id" )
	private Integer userId;
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time" )
	private  Date createTime;
	
	@Column(name="taobao_xiaohao" )
	private String taobaoXiaohao;
	
	@Column(name="user_qq" )
	private String userQq;
	
	@Column(name="product_link" )
	private String productLink;
	
	@Column(name="product_title" )
	private String productTitle ;
	
	@Column(name="pay_method" )
	private Integer payMethod ;
	
	@Column(name="guarantee_price" )
	private BigDecimal guaranteePrice ;
	
	@Column(name="basic_publish_dot" )
	private BigDecimal basicPublishDot;
	
	@Column(name="task_type" )
	@Enumerated(EnumType.STRING)
	private  TaskTypes taskType;
	
	/**
	 * 产品好评
	 */
	@Column(name="good_comment" )
	private  String goodComment;
	
	/**
	 * 好评时限
	 */
	@Column(name="good_comment_time_limit" )
	@Enumerated(EnumType.STRING)
	private  GoodCommentTimeLimits goodCommentTimeLimit;
	
	/**
	 * 好评需要发布点数
	 */
	@Column(name="good_comment_time_dot" )
	private  BigDecimal goodCommentTimeDot;
	

}
