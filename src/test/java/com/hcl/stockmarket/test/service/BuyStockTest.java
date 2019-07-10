package com.hcl.stockmarket.test.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.StockBuy;
import com.hcl.stockmarket.repository.BuyStockRepo;
import com.hcl.stockmarket.repository.MarketRepo;
import com.hcl.stockmarket.repository.UserRepo;
import com.hcl.stockmarket.service.BuyService;
import com.hcl.stockmarket.service.StockService;
import com.hcl.stockmarket.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class BuyStockTest {

	@InjectMocks
	BuyService buyService;
	
	@Mock
	BuyStockRepo buyStockRepo;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	MarketRepo marketRepo;
	
	public StockBuy getPositiveBuy()
	{
		StockBuy stockBuy = new StockBuy();
		stockBuy.setCompanyname("HCL");
		stockBuy.setId(1);
		stockBuy.setPrice(200);
		stockBuy.setStocksTaken(3);
		stockBuy.setUser_id(1);
		return stockBuy;
	}
	
	
	public StockBuy getPositiveBuyForAbovePrice()
	{
		StockBuy stockBuy = new StockBuy();
		stockBuy.setCompanyname("HCL");
		stockBuy.setId(1);
		stockBuy.setPrice(400);
		stockBuy.setStocksTaken(3);
		stockBuy.setUser_id(1);
		return stockBuy;
	}
	
	public StockBuy getPositiveBuyForAboveStock()
	{
		StockBuy stockBuy = new StockBuy();
		stockBuy.setCompanyname("HCL");
		stockBuy.setId(1);
		stockBuy.setPrice(200);
		stockBuy.setStocksTaken(6);
		stockBuy.setUser_id(1);
		return stockBuy;
	}
	
	@Test
	public void buyStockPositive()
	{
		StockBuy stockBuy = getPositiveBuy();
		//Mockito.when(userRepo.findById(Mockito.anyInt())).thenReturn(Mockito.anyInt());
		Mockito.when(buyStockRepo.save(stockBuy)).thenReturn(stockBuy);
		ResponseDTO actualResponse = buyService.buyStocks(stockBuy);
		Assert.assertEquals("Stock added successfully", actualResponse.getMessage());
	}
	
	
	@Test
	public void buyStockNegativeForAbovePrice()
	{
		StockBuy stockBuy = getPositiveBuyForAbovePrice();
		Mockito.when(buyStockRepo.save(stockBuy)).thenReturn(stockBuy);
		ResponseDTO actualResponse = buyService.buyStocks(stockBuy);
		Assert.assertEquals("Buying of stock could not cross 300", actualResponse.getMessage());
	}
	
	@Test
	public void buyStockNegativeForAboveStock()
	{
		StockBuy stockBuy = getPositiveBuyForAboveStock();
		Mockito.when(buyStockRepo.save(stockBuy)).thenReturn(stockBuy);
		ResponseDTO actualResponse = buyService.buyStocks(stockBuy);
		Assert.assertEquals("Stock could not cross 5 in size", actualResponse.getMessage());
	}
	
	@Test
	public void updateStockTest()
	{
		StockBuy stockBuy = getPositiveBuy();		
		//Mockito.when(buyStockRepo.findById(stockBuy.getId())).thenReturn(Optional<StockBuy>().stockBuy);
		Mockito.when(buyStockRepo.save(stockBuy)).thenReturn(stockBuy);
		ResponseDTO actualResponse = buyService.updateBuy(stockBuy);
		Assert.assertEquals("Stock updated successfully", actualResponse.getMessage());
	}
	
}
