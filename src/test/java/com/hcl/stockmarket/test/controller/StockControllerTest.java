package com.hcl.stockmarket.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hcl.stockmarket.controller.StocksController;
import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {
	
	@InjectMocks
	StocksController stocksController;
	
	@Mock
	StockService stockService;
	
	@Autowired
	private WebApplicationContext context;
	
	MarketShare marketShare;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		marketShare = new MarketShare(1, "HCL", 24, (double) 10, 2, 22);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void UserControllerTest() throws Exception
	{
		when(stockService.createdStock(marketShare)).thenReturn(new ResponseDTO("Stocks created successfully"));
		ResponseDTO actual = stocksController.creatStock(marketShare);
		this.mockMvc.perform(
				post("/stocks").contentType(MediaType.APPLICATION_JSON));
		assertEquals("Stocks created successfully", actual.getMessage());
	}
	
	
	@Test
	public void UserControllerGetTest() throws Exception
	{
		when(stockService.getAllShares(marketShare.getCompanyname())).thenReturn((List<MarketShare>) marketShare);
		ResponseEntity<List<MarketShare>> actual = stocksController.getStocks(marketShare.getCompanyname());
		this.mockMvc.perform(
				get("/stocks").contentType(MediaType.APPLICATION_JSON));
		assertEquals(201, actual.getStatusCodeValue());
	}
	
}
