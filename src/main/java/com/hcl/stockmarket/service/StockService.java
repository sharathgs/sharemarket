package com.hcl.stockmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.exception.StockMarketException;
import com.hcl.stockmarket.exception.StockMarketExceptionhandler;
import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.repository.MarketRepo;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class StockService {

	@Autowired
	MarketRepo marketRepo;
	
	public ResponseDTO createdStock(MarketShare marketShare)
	{
		if(marketRepo.save(marketShare) != null)
			return new ResponseDTO("Stocks created successfully");
		else
			return new ResponseDTO("Stocks not created successfully");
	}
	
	public List<MarketShare> getAllShares(String companyName)
	{
		if(companyName == null)
			return marketRepo.findAll();
		else 
			return marketRepo.findBycompanyname(companyName);		
	}
}
