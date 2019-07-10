package com.hcl.stockmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.model.StockBuy;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.repository.BuyStockRepo;
import com.hcl.stockmarket.repository.MarketRepo;
import com.hcl.stockmarket.repository.UserRepo;

@Service
public class BuyService {
	
	@Autowired
	BuyStockRepo buyStock;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	MarketRepo marketRepo;

	public ResponseDTO buyStocks(StockBuy stockBuy)
	{	
			
		//int crosslimits = stockBuy.getPrice() * stockBuy.getStocksTaken();
		//Optional<User> user = userRepo.findById(stockBuy.getUser_id());
		
		//List<MarketShare> marketShare = marketRepo.findBycompanyname(stockBuy.getCompanyname());
		
		/*if(user == null)
		{
			return new ResponseDTO("User is not available");
		}else if(marketShare == null) {
			return new ResponseDTO("Company is not available");
		}else */
		if(stockBuy.getPrice() > 300)
		{
			return new ResponseDTO("Buying of stock could not cross 300");
		}else if(stockBuy.getStocksTaken() > 5)
		{
			return new ResponseDTO("Stock could not cross 5 in size");
		}else
		{
			buyStock.save(stockBuy);
			return new ResponseDTO("Stock added successfully");
		}		
	}
	
	public ResponseDTO updateBuy(StockBuy stockBuy)
	{
		Optional<StockBuy> createdstockBuy = buyStock.findById(stockBuy.getId());
		if(createdstockBuy.isPresent())
		{
			
			if(stockBuy.getPrice() > 300)
			{
				return new ResponseDTO("Buying of stock could not cross 300");
			}else if(stockBuy.getStocksTaken() > 5)
			{
				return new ResponseDTO("Stock could not cross 5 in size");
			}else
			{
				buyStock.save(stockBuy);
				return new ResponseDTO("Stock updated successfully");
			}		
						
		}else
		{
			return new ResponseDTO("Stocks Does not exists on this name");
		}
	}
	
}
