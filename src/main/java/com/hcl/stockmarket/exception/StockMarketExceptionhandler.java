package com.hcl.stockmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StockMarketExceptionhandler {

	public ResponseEntity<StockMarketException> handleException(Exception e)
	{
		return new ResponseEntity<StockMarketException>(new StockMarketException(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<StockMarketException> NotFoundException(Exception e)
	{
		return new ResponseEntity<StockMarketException>(new StockMarketException(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
}
