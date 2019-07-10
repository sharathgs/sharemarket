package com.hcl.stockmarket.exception;

public class StockMarketException {
	
	private String message;	
	
	public StockMarketException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
