package com.hcl.stockmarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stockmarket.model.MarketShare;

@Repository
public interface MarketRepo extends JpaRepository<MarketShare, Integer> {

	public List<MarketShare> findBycompanyname(String companyname);
	
}
