package com.gxkj.taobaoservice.controllers.demo.stocks.gateway;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.support.RabbitGatewaySupport;
 


import com.gxkj.taobaoservice.controllers.demo.stocks.domain.Quote;
import com.gxkj.taobaoservice.controllers.demo.stocks.domain.Stock;
import com.gxkj.taobaoservice.controllers.demo.stocks.domain.StockExchange;
 

public class RabbitMarketDataGateway extends RabbitGatewaySupport implements MarketDataGateway{

	private final List<MockStock> stocks = new ArrayList<MockStock>();
	
	private static final Random random = new Random();
	public RabbitMarketDataGateway() {
		this.stocks.add(new MockStock("AAPL", StockExchange.nasdaq, 255));
		this.stocks.add(new MockStock("CSCO", StockExchange.nasdaq, 22));
		this.stocks.add(new MockStock("DELL", StockExchange.nasdaq, 15));
		this.stocks.add(new MockStock("GOOG", StockExchange.nasdaq, 500));
		this.stocks.add(new MockStock("INTC", StockExchange.nasdaq, 22));
		this.stocks.add(new MockStock("MSFT", StockExchange.nasdaq, 29));
		this.stocks.add(new MockStock("ORCL", StockExchange.nasdaq, 24));
		this.stocks.add(new MockStock("CAJ", StockExchange.nyse, 43));
		this.stocks.add(new MockStock("F", StockExchange.nyse, 12));
		this.stocks.add(new MockStock("GE", StockExchange.nyse, 18));
		this.stocks.add(new MockStock("HMC", StockExchange.nyse, 32));
		this.stocks.add(new MockStock("HPQ", StockExchange.nyse, 48));
		this.stocks.add(new MockStock("IBM", StockExchange.nyse, 130));
		this.stocks.add(new MockStock("TM", StockExchange.nyse, 76));
	}
	
	public void sendMarketData() {
		Quote quote = generateFakeQuote();
		Stock stock = quote.getStock();
		
		logger.info("Sending Market Data for " + stock.getTicker());
		
		System.out.println("Sending Market Data for " + stock.getTicker());
		
		String routingKey = "app.stock.quotes."+ stock.getStockExchange() + "." + stock.getTicker();
		
		getRabbitTemplate().convertAndSend(routingKey, quote);
	}

	private Quote generateFakeQuote() {
		MockStock stock = this.stocks.get(random.nextInt(this.stocks.size()));
		String price = stock.randomPrice();  
		
		return new Quote(stock, price);
	}
	
	private static class MockStock extends Stock {

		private final int basePrice;
		private final DecimalFormat twoPlacesFormat = new DecimalFormat("0.00");

		private MockStock(String ticker, StockExchange stockExchange, int basePrice) {
			super(stockExchange, ticker);
			this.basePrice = basePrice;
		}

		private String randomPrice() {
			return this.twoPlacesFormat.format(this.basePrice + Math.abs(random.nextGaussian()));
		}
	}

}
