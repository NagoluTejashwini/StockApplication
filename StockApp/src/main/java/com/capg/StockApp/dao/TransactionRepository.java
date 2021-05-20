package com.capg.StockApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.StockApp.beans.Stock;
import com.capg.StockApp.beans.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>, CustomRepository{


	

}
