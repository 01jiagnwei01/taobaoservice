package com.gxkj.taobaoservice.daos.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.gxkj.common.dao.BaseDAOImpl;
import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.daos.ApplyDrawDao;
import com.gxkj.taobaoservice.entitys.ApplyDraw;
import com.gxkj.taobaoservice.enums.RechargeApplyStatus;
@Repository
public class ApplyDrawDaoImpl  extends BaseDAOImpl implements ApplyDrawDao {

	/**
	 * 查询id不是参数applyId 但是流水号为thirdOrderNo的申请且已经申请通过的
	 * @param thirdOrderNo
	 * @param applyId
	 * @return List<ApplyDraw> 
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyDraw> getApplyDrawByThirdOrderNoAndNotIDndPassed(
			String thirdOrderNo, Integer applyId) throws SQLException {
		String hql = "from ApplyDraw where thirdOrderNo = ? and id != ? and status = '"+RechargeApplyStatus.APPROVE+"'";
		return (List<ApplyDraw>) this.selectByHQL(hql, new Object[]{thirdOrderNo,applyId});
	}
	
	/**
	  * 分页查看取款申请
	  * @param pageno 
	  * @param pagesize
	  * @param thirdOrderNo
	  * @param amount  取款金额
	  * @param userId  取款用户ID
	  * @param status  取款申请状态
	  * @param createBeginTime	创建时间起始时间
	  * @param createEndTime	创建时间结束时间
	  * @param reviewBeginTime  审核起始时间
	  * @param reviewEndTime	审核时间结束时间
	  * @param auditorId		审核人ID
	  * @return
	 * @throws SQLException 
	  */
	public ListPager doPage(int pageno, int pagesize, String thirdOrderNo,
			BigDecimal amount, Integer userId, RechargeApplyStatus status,
			Date createBeginTime, Date createEndTime, Date reviewBeginTime,
			Date reviewEndTime, Integer auditorId) throws SQLException {
		
		StringBuffer hql = new StringBuffer("  from ApplyDraw where ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotBlank(thirdOrderNo)){
			hql.append( " and thirdOrderNo = ?" );
			params.add(thirdOrderNo);
		}
		if(amount != null && amount.intValue() != 0){
			hql.append( " and amount = ?" );
			params.add(amount);
		}
		if(userId != null && userId.intValue() != 0){
			hql.append( " and userId = ?" );
			params.add(userId);
		}
		
		if(status != null ){
			hql.append( " and status = ?" );
			params.add(status);
		}
		
		if(createBeginTime != null ){
			hql.append( " and createTime >= ?" );
			params.add(createBeginTime);
		}
		
		if(createEndTime != null ){
			hql.append( " and createTime <= ?" );
			params.add(createEndTime);
		}
		
		if(reviewBeginTime != null ){
			hql.append( " and reviewTime >= ?" );
			params.add(reviewBeginTime);
		}
		
		if(reviewEndTime != null ){
			hql.append( " and reviewTime <= ?" );
			params.add(reviewEndTime);
		}
		
		if(auditorId != null && auditorId.intValue() != 0){
			hql.append( " and auditorId = ?" );
			params.add(auditorId);
		}
		
		ListPager pager = new ListPager();
		pager.setPageNo(pageno);
		pager.setRowsPerPage(pagesize);
		
		return this.selectPageByHql(hql.toString(), params.toArray(), pager);
	}

}
