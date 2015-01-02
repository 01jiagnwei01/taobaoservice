package com.gxkj.taobaoservice.controllers.demo.stocks.ui;

import com.gxkj.taobaoservice.controllers.demo.stocks.domain.Quote;
import com.gxkj.taobaoservice.controllers.demo.stocks.domain.TradeRequest;
import com.gxkj.taobaoservice.controllers.demo.stocks.domain.TradeResponse;
import com.gxkj.taobaoservice.controllers.demo.stocks.gateway.StockServiceGateway;

public class StockController {
	private StockPanel stockPanel;

	private StockServiceGateway stockServiceGateway;


	public StockPanel getStockPanel() {
		return stockPanel;
	}

	public void setStockPanel(StockPanel stockPanel) {
		this.stockPanel = stockPanel;
	}

	public StockServiceGateway getStockServiceGateway() {
		return stockServiceGateway;
	}

	public void setStockServiceGateway(StockServiceGateway stockServiceGateway) {
		this.stockServiceGateway = stockServiceGateway;
	}

	// "Actions"

	public void sendTradeRequest(String text) {
		String[] tokens = text.split("\\s");
		String quantityString = tokens[0];
		String ticker = tokens[1];
		int quantity = Integer.parseInt(quantityString);
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

    public void displayQuote(Quote quote) {
    	//TODO race condition with message delivery and initialization... use @Configurable?
    	if (stockPanel != null) {
    		stockPanel.displayQuote(quote);
    	}
    }

    public void updateTrade(TradeResponse tradeResponse) {
    	stockPanel.update(tradeResponse);
    }
}
