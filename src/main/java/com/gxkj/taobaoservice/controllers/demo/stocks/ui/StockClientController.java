package com.gxkj.taobaoservice.controllers.demo.stocks.ui;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxkj.taobaoservice.controllers.demo.stocks.domain.TradeRequest;
import com.gxkj.taobaoservice.controllers.demo.stocks.gateway.StockServiceGateway;

@Controller
@RequestMapping("/demo/stockclient")
public class StockClientController {

	//@Autowired
	private StockServiceGateway stockServiceGateway;
	
	@RequestMapping(value="",method={RequestMethod.GET})
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		String mv = "demo/stockclient";
		return mv;
	}
	
	@RequestMapping(value="/send",method={RequestMethod.POST})
	@ResponseBody
	public String send(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String msg){
		String result = "Request Pending...";
		
		try {
			this.sendTradeRequest(msg);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			result = "Required Format: 100 TCKR" ;
		}
		return result;
	}
	public void sendTradeRequest(String ticker) {
		Random r1 = new Random(10);
		 
		int quantity = r1.nextInt(10);
		TradeRequest tr = new TradeRequest();
		tr.setAccountName("ACCT-123");
		tr.setBuyRequest(true);
		tr.setOrderType("MARKET");
		tr.setTicker(ticker);
		tr.setQuantity(quantity);
		tr.setRequestId("REQ-1");
		tr.setUserName("Joe Trader");
		tr.setUserName("Joe");
		stockServiceGateway.send(tr);		
	}
	
	public static void main(String[] args) {
		Random r1 = new Random(10);
		System.out.println(r1.nextInt(10));
	}
}
