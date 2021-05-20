package com.capg.StockApp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.StockApp.beans.Stock;
import com.capg.StockApp.dao.StockRepository;



@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository repo;
	
	@Override
	public List<Stock> getAllStocks(){
		
		return repo.findAll();
	}
	
	@Override
	
	public Stock saveStock(Stock s) {
		repo.save(s);
		return s;
	}	

	
	@Override
	@Transactional
	public void doUpdate(int id,double price) {
		Optional<Stock> s = repo.findById(id);
		Stock s1 = null;
		if(s.isPresent()) {
			s1 = s.get();
			//s1.setStockName(name1);
			s1.setPrice(price);
			repo.save(s1);
		}
	}
	
	

}
