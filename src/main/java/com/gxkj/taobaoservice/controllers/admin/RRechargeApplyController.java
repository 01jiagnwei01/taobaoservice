package com.gxkj.taobaoservice.controllers.admin;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.common.util.ListPager;
import com.gxkj.taobaoservice.dto.EntityReturnData;
import com.gxkj.taobaoservice.dto.SessionConstant;
import com.gxkj.taobaoservice.entitys.AdminUser;
import com.gxkj.taobaoservice.entitys.RechargeApply;
import com.gxkj.taobaoservice.enums.RechargeApplyStatus;
import com.gxkj.taobaoservice.services.RechargeApplyService;

@Controller
@RequestMapping("/admin/rechargeapply")
public class RRechargeApplyController {
	
	@Autowired
	public RechargeApplyService rechargeApplyService;

	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "admin/rechargeapply";
		return mv;
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @param thirdOrderNo
	 * @param amount
	 * @param userId
	 * @param status
	 * @param createBeginTime
	 * @param createEndTime
	 * @param reviewBeginTime
	 * @param reviewEndTime
	 * @param auditorId
	 * @param pageno
	 * @param pagesize
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/dopage",method={RequestMethod.POST})
	@ResponseBody
    public EntityReturnData doPage( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="thirdOrderNo",defaultValue="") String thirdOrderNo,
			@RequestParam(value="amount",defaultValue="0")  BigDecimal amount,
			@RequestParam(value="userId",defaultValue="0")  Integer userId,
			@RequestParam(value="status",defaultValue="")  RechargeApplyStatus status,
			@RequestParam(value="createBeginTime" )  Date createBeginTime,
			@RequestParam(value="createEndTime" )  Date createEndTime, 
			@RequestParam(value="reviewBeginTime" )  Date reviewBeginTime,
			@RequestParam(value="reviewEndTime" )  Date reviewEndTime,
			@RequestParam(value="auditorId",defaultValue="0")  Integer auditorId,
			@RequestParam(value="pageno",defaultValue="0") int pageno,
    		@RequestParam(value="limit",defaultValue="20") int pagesize
    		,ModelMap modelMap)  {
			EntityReturnData ret = new EntityReturnData();
			ret.setResult(true);
			try {
				ListPager paper = rechargeApplyService.doPage(pageno, pagesize, thirdOrderNo, amount, userId, status, createBeginTime, createEndTime, reviewBeginTime, reviewEndTime, auditorId);
				ret.setEntity(paper);
			} catch (Exception e) {
				e.printStackTrace();
				ret.setMsg(e.getMessage());
				ret.setResult(false);
			}
			return ret;
	}
	
	/**
	 * 审核通过
	 * @param request
	 * @param response
	 * @param applyId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/doagree",method={RequestMethod.POST})
	@ResponseBody
    public EntityReturnData doagree( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="applyId",defaultValue="0")  Integer applyId
    		,ModelMap modelMap)  {
			EntityReturnData ret = new EntityReturnData();
			ret.setResult(true);
			try {
				AdminUser adminUser = SessionConstant.getAdminUserInSession(request);
				RechargeApply entity =rechargeApplyService.doAgreeRechargeApply(applyId, adminUser);
				ret.setEntity(entity);
			} catch (Exception e) {
				e.printStackTrace();
				ret.setMsg(e.getMessage());
				ret.setResult(false);
			}
			return ret;
	}
	/**
	 *  审核拒绝
	 * @param request
	 * @param response
	 * @param applyId
	 * @param reason
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/doarefuse",method={RequestMethod.POST})
	@ResponseBody
    public EntityReturnData doarefuse( HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="applyId",defaultValue="0")  Integer applyId,
			@RequestParam(value="reason",defaultValue="")  String reason
    		,ModelMap modelMap)  {
			EntityReturnData ret = new EntityReturnData();
			ret.setResult(true);
			try {
				AdminUser adminUser = SessionConstant.getAdminUserInSession(request);
				RechargeApply entity =rechargeApplyService.doRefuseRechargeApply(applyId, adminUser, reason);
				ret.setEntity(entity);
			} catch (Exception e) {
				e.printStackTrace();
				ret.setMsg(e.getMessage());
				ret.setResult(false);
			}
			return ret;
	}
}
