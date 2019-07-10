package com.hcl.stockmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.StockBuy;
import com.hcl.stockmarket.service.BuyService;

@RestController
@RequestMapping("/buy")
public class BuyShares {
	
	@Autowired
	BuyService buyService;
	
	@PostMapping("/stock")
	public ResponseEntity<ResponseDTO> stockBuyed(@RequestBody StockBuy stockBuy)
	{
		return new ResponseEntity<ResponseDTO>(buyService.buyStocks(stockBuy),HttpStatus.CREATED);
	}
	
	@PutMapping("/stock")
	public ResponseEntity<ResponseDTO> stockUpdation(@RequestBody StockBuy stockBuy)
	{
		return new ResponseEntity<ResponseDTO>(buyService.updateBuy(stockBuy),HttpStatus.CREATED);
	}

}
