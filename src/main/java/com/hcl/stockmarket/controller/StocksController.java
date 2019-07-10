package com.hcl.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.repository.MarketRepo;
import com.hcl.stockmarket.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StocksController {
	
	@Autowired
	StockService stockService;
	
	@PostMapping("/stocks")
	public ResponseDTO creatStock(MarketShare marketShare)
	{
		return stockService.createdStock(marketShare);
	}
	
	@GetMapping("/stocks")
	public ResponseEntity<List<MarketShare>> getStocks(@RequestParam(value = "companyname", required = false) String companyname)
	{		
		return new ResponseEntity<List<MarketShare>>(stockService.getAllShares(companyname),HttpStatus.FOUND);
	}

}
