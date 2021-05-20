package com.capg.StockApp.dao;

import java.util.List;

import com.capg.StockApp.beans.Transaction;

public interface CustomRepository {

	List<Transaction> getTransactionByType(String type);
}
