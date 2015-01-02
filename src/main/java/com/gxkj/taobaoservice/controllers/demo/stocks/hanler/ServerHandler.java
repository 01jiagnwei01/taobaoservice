package com.gxkj.taobaoservice.controllers.demo.stocks.hanler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gxkj.taobaoservice.controllers.demo.stocks.domain.TradeRequest;
import com.gxkj.taobaoservice.controllers.demo.stocks.domain.TradeResponse;
import com.gxkj.taobaoservice.controllers.demo.stocks.service.CreditCheckService;
import com.gxkj.taobaoservice.controllers.demo.stocks.service.ExecutionVenueService;
import com.gxkj.taobaoservice.controllers.demo.stocks.service.TradingService;

public class ServerHandler {

	 private ExecutionVenueService executionVenueService;

	    private CreditCheckService creditCheckService;

	    private TradingService tradingService;
	    
	    
		
		public ServerHandler(ExecutionVenueService executionVenueService,
							 CreditCheckService creditCheckService, 
							 TradingService tradingService) {
			this.executionVenueService = executionVenueService;
			this.creditCheckService = creditCheckService;
			this.tradingService = tradingService;
		}

		public TradeResponse handleMessage(TradeRequest tradeRequest)
		{
	        TradeResponse tradeResponse;
	        List<?> errors = new ArrayList<Object>();
	        if (creditCheckService.canExecute(tradeRequest, errors))
	        {
	            tradeResponse = executionVenueService.executeTradeRequest(tradeRequest);
	        }
	        else
	        {
	            tradeResponse = new TradeResponse();
	            tradeResponse.setError(true);
	            tradeResponse.setErrorMessage(StringUtils.arrayToCommaDelimitedString(errors.toArray()));
	            
	        }
	        tradingService.processTrade(tradeRequest, tradeResponse);
	        return tradeResponse;
		}
}
