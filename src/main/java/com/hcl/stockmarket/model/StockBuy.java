package com.hcl.stockmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "buyedStocks")
public class StockBuy {
	
	@Id
	@GeneratedValue
	private int id;
	private String companyname;
	private int price;
	
	@NotNull(message = "stocks could not cross 5")
	@Min(1)
	@Max(5)
	private int stocksTaken;
	private int user_id;
	
	
	public StockBuy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStocksTaken() {
		return stocksTaken;
	}

	public void setStocksTaken(int stocksTaken) {
		this.stocksTaken = stocksTaken;
	}

	
	

}
