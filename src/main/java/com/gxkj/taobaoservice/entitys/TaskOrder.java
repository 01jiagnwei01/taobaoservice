package com.gxkj.taobaoservice.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.gxkj.taobaoservice.enums.GoodCommentTimeLimits;
import com.gxkj.taobaoservice.enums.PayMethods;
import com.gxkj.taobaoservice.enums.TaskOrderStatus;
import com.gxkj.taobaoservice.enums.TaskTypes;

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
	@Min(value=1)
	private Integer userId;
	
	/**
	 * 创建时间
	 */
	@NotNull
	@Column(name="create_time" )
	private  Date createTime;
	
	/**
	 * 任务发布人淘宝号
	 */
	@Column(name="taobao_xiaohao" )
	@NotEmpty
	private String taobaoXiaohao;
	
	/**
	 * 任务发布人QQ
	 */
	@Column(name="user_qq" )
	@NotEmpty
	private String userQq;
	
	/**
	 * 商品地址
	 */
	@Column(name="product_link" )
	@NotEmpty
	@Length(min=10)
	private String productLink;
	
	/**
	 * 商品标题
	 */
	@Column(name="product_title" )
	@NotEmpty
	@Length(min=10)
	private String productTitle ;
	
	/**
	 * 付款方式
	 */
	@Column(name="pay_method" )
	@Enumerated(EnumType.STRING)
	@NotNull
	private PayMethods payMethod ;
	
	/**
	 * 担保金
	 */
	@Column(name="guarantee_price" )
	@NotNull
	@Min(2)
	private BigDecimal guaranteePrice ;
	
	/**
	 * 基本发布点
	 */
	@Column(name="basic_publish_dot" )
	@NotNull
	private BigDecimal basicPublishDot;
	
	/**
	 * 任务类型
	 */
	@Column(name="task_type" )
	@Enumerated(EnumType.STRING)
	@NotNull
	private  TaskTypes taskType;
	
	/**
	 * 产品好评内容
	 */
	@Column(name="good_comment" )
	@NotNull
	private  String goodComment;
	
	/**
	 * 好评时限
	 */
	@Column(name="good_comment_time_limit" )
	@Enumerated(EnumType.STRING)
	@NotNull
	private  GoodCommentTimeLimits goodCommentTimeLimit;
	
	/**
	 * 好评需要发布点数
	 */
	@Column(name="good_comment_time_dot" )
	@NotNull
	@Min(value=0)
	private  BigDecimal goodCommentTimeDot;
	
	/**
	 * 订单状态
	 */
	@Column(name="status" )
	@Enumerated(EnumType.STRING)
	@NotNull
	private TaskOrderStatus status = TaskOrderStatus.WAIT_FOR_SURE;
	
	/**
	 * 完成增值任务，接收方受益点数
	 */
	@Column(name="zengzhi_receiver_gain_points" )
	@NotNull
	@Min(value=0)
	private  BigDecimal zengzhiReceiverGain_points = BigDecimal.ZERO;
	/**
	 * 完成增值任务，平台受益点数
	 */
	@Column(name="zengzhi_pingtai_gain_points" )
	@NotNull
	@Min(value=0)
	private  BigDecimal zengzhiPingtaiGain_points = BigDecimal.ZERO;
	
	/**
	 * 完成基本任务，接收方受益点数
	 */
	@Column(name="basic_receiver_gain_point" )
	private  BigDecimal basicReceiverGainPoint = BigDecimal.ZERO;
	/**
	 * 完成基本任务，平台受益点数
	 */
	@Column(name="basic_pingtai_gain_point" )
	@NotNull
	@Min(value=0)
	private  BigDecimal basicPingtaiGainPoint = BigDecimal.ZERO;
	
	/**
	 * 重复次数
	 */
	@Column(name="repeate_times" )
	@NotNull
	@Min(value=1)
	private Integer repeateTimes = new Integer("1");
	
	
	/**
	 * 增值任务
	 */
	@Transient
	private List<TaskAppreciation> taskAppreciations;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTaobaoXiaohao() {
		return taobaoXiaohao;
	}

	public void setTaobaoXiaohao(String taobaoXiaohao) {
		this.taobaoXiaohao = taobaoXiaohao;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public PayMethods getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(PayMethods payMethod) {
		this.payMethod = payMethod;
	}

	public BigDecimal getGuaranteePrice() {
		return guaranteePrice;
	}

	public void setGuaranteePrice(BigDecimal guaranteePrice) {
		this.guaranteePrice = guaranteePrice;
	}

	public BigDecimal getBasicPublishDot() {
		return basicPublishDot;
	}

	public void setBasicPublishDot(BigDecimal basicPublishDot) {
		this.basicPublishDot = basicPublishDot;
	}

	public TaskTypes getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskTypes taskType) {
		this.taskType = taskType;
	}

	public String getGoodComment() {
		return goodComment;
	}

	public void setGoodComment(String goodComment) {
		this.goodComment = goodComment;
	}

	public GoodCommentTimeLimits getGoodCommentTimeLimit() {
		return goodCommentTimeLimit;
	}

	public void setGoodCommentTimeLimit(GoodCommentTimeLimits goodCommentTimeLimit) {
		this.goodCommentTimeLimit = goodCommentTimeLimit;
	}

	public BigDecimal getGoodCommentTimeDot() {
		return goodCommentTimeDot;
	}

	public void setGoodCommentTimeDot(BigDecimal goodCommentTimeDot) {
		this.goodCommentTimeDot = goodCommentTimeDot;
	}

	public List<TaskAppreciation> getTaskAppreciations() {
		return taskAppreciations;
	}

	public void setTaskAppreciations(List<TaskAppreciation> taskAppreciations) {
		this.taskAppreciations = taskAppreciations;
	}
	
	
	

}
