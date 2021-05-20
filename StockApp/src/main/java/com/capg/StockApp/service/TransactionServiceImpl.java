package com.capg.StockApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.StockApp.beans.Stock;
import com.capg.StockApp.beans.Transaction;
import com.capg.StockApp.dao.StockRepository;
import com.capg.StockApp.dao.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository repo;
	
	@Autowired
	StockServiceImpl service;
	
	@Override
	public List<Transaction> getAllTransactions(){
		
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public Transaction saveTransaction(Transaction t) {
		repo.save(t);
		return t;
	}

	@Override
	@Transactional
	public List<Transaction> doUpdate(String name1,int quantity, String transactionType) {
		List<Transaction> tList = repo.getTransactionByType(transactionType);
		List<Transaction> tempList = new ArrayList<>();
		tempList.clear();
		double price = 0.0;
		double q = quantity/100;
		for(Transaction t:tList) {
			int id = t.getStock().getStockId();
			double p = t.getStock().getPrice();
			String stockName = t.getStock().getStockName();
			if(stockName.equals(name1)) {
				if(transactionType.equals("buy")) {
					price = p * (Math.pow(1.02, q));
					System.out.println(price+" "+q);
					service.doUpdate(id, price);
				}
				else {
					price = p*Math.pow(0.98, q);
					System.out.println(price+" "+q);
					service.doUpdate(id, price);
				}
				tempList.add(t);
			}
			repo.save(t);
		}
		return tempList;
	}
	
	@Override
	public Transaction getDetails(int transactionId){
		return repo.findById(transactionId).get();	
		
	}
}
