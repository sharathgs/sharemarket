package com.hcl.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stockmarket.model.MarketShare;
import com.hcl.stockmarket.model.StockBuy;

@Repository
public interface BuyStockRepo extends JpaRepository<StockBuy, Integer> {

}
