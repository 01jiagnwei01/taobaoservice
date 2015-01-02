package com.gxkj.taobaoservice.controllers.demo.stocks.domain;


public class Stock {
	private String ticker;

	private StockExchange stockExchange;

	// For de-seialization:
	public Stock() {
	}
	
	public Stock(StockExchange stockExchange, String ticker) {
		this.stockExchange = stockExchange;
		this.ticker = ticker;
	}

	public String getTicker() {
		return ticker;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	@Override
	public String toString() {
		return "Stock [ticker=" + ticker + ", stockExchange=" + stockExchange + "]";
	}
}
