package com.capg.StockApp.service;

import java.util.List;

import javax.validation.Valid;

import com.capg.StockApp.beans.Stock;

public interface StockService {

	List<Stock> getAllStocks();


	Stock saveStock(Stock s);

	void doUpdate(int id, double price);


	

}
