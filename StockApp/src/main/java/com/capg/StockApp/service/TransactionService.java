package com.capg.StockApp.service;

import java.util.List;
import java.util.Optional;

import com.capg.StockApp.beans.Transaction;

public interface TransactionService {

	List<Transaction> getAllTransactions();

	Transaction saveTransaction(Transaction t);

	List<Transaction> doUpdate(String stockName, int quantity, String transactionType);

	Transaction getDetails(int id);

}
