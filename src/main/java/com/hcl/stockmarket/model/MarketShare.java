package com.hcl.stockmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockshare")
public class MarketShare {
	
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private int noOfStocks;
	private Double priceOfShare;
	private int stockSold;
	private int stockLeft;
	
	
	
	
	public Double getPriceOfShare() {
		return priceOfShare;
	}

	public void setPriceOfShare(Double priceOfShare) {
		this.priceOfShare = priceOfShare;
	}

	public MarketShare() {
		super();
	}
	
	public MarketShare(int id, String companyname, int noOfStocks, Double priceOfShare, int stockSold, int stockLeft) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.noOfStocks = noOfStocks;
		this.priceOfShare = priceOfShare;
		this.stockSold = stockSold;
		this.stockLeft = stockLeft;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(int noOfStocks) {
		this.noOfStocks = noOfStocks;
	}	
	public int getStockSold() {
		return stockSold;
	}
	public void setStockSold(int stockSold) {
		this.stockSold = stockSold;
	}
	public int getStockLeft() {
		return stockLeft;
	}
	public void setStockLeft(int stockLeft) {
		this.stockLeft = stockLeft;
	}
	

}
