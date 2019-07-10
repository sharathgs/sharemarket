package com.hcl.stockmarket.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.repository.MarketRepo;
import com.hcl.stockmarket.service.StockService;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

	@InjectMocks
	StockService stockService;
	
	@Mock
	MarketRepo marketRepo;
	
	
	public MarketShare getMarketShare()
	{
		MarketShare marketShare = new MarketShare();
		marketShare.setCompanyname("HCL");
		marketShare.setId(1);
		marketShare.setNoOfStocks(1000);
		marketShare.setPriceOfShare((double) 100);
		marketShare.setStockLeft(12);
		marketShare.setStockSold(88);
		return marketShare;
	}	
	
	
	@Test
	public void creatingStock()
	{
		MarketShare marketShare = getMarketShare();
		Mockito.when(marketRepo.save(marketShare)).thenReturn(marketShare);
		ResponseDTO actualResponse = stockService.createdStock(marketShare);
		Assert.assertEquals("Stocks created successfully", actualResponse.getMessage());
	}
	
	@Test
	public void gettingStockforOne()
	{
		MarketShare marketShare = getMarketShare();
		List<MarketShare> marketShares = new ArrayList<MarketShare>();
		Mockito.when(marketRepo.findAll()).thenReturn(marketShares);
		List<MarketShare> actualResponse = stockService.getAllShares(marketShare.getCompanyname());
	}
	
	@Test
	public void gettingStockforAll()
	{
		MarketShare marketShare = getMarketShare();
		List<MarketShare> marketShares = new ArrayList<MarketShare>();
		Mockito.when(marketRepo.findAll()).thenReturn(marketShares);
		List<MarketShare> actualResponse = stockService.getAllShares(null);
	}
	
	
}
