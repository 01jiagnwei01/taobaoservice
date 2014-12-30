package com.gxkj.taobaoservice.amqps.in;

public class TempConverterImpl implements TempConverter {

	
	public float fahrenheitToCelcius(float payload) {
		
		return (payload - 32) / 9 * 5;
	}

}
