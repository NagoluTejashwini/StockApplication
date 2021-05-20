package com.capg.StockApp.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.StockApp.beans.Stock;
import com.capg.StockApp.beans.Transaction;
import com.capg.StockApp.service.StockService;
import com.capg.StockApp.service.TransactionService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "My Stock Application",description = "contains api to manipulate transactions")
public class StockRestController {
	
	@Autowired
	private StockService service;
	
	@Autowired
	private TransactionService service1;
	
	public StockRestController() {
		System.out.println("---->> Product Rest constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Stock App " + LocalDateTime.now();
	}
	
	@ApiOperation(value = "stock post mapping" , response = Stock.class)
	@PostMapping("/stock")
	public Stock insertStock(@RequestBody @Valid Stock s) {
		service.saveStock(s);
		return s;
	}
	
	@ApiOperation(value = "stock Get mapping to fetch all Stocks" , response = List.class)
	@GetMapping("/Stocks")
	public List<Stock> getAllStocks(){
		return service.getAllStocks();
	}
	
	@ApiOperation(value = "Transaction post mapping" , response = Transaction.class)
	@PostMapping("/transaction")
	public Transaction insertTransaction(@RequestBody @Valid Transaction t) {
		service1.saveTransaction(t);
		return t;
	}
	
	@ApiOperation(value = "Transaction Get mapping to fetch all transactions" , response = List.class)
	@GetMapping("/Transactions")
	public List<Transaction> getAllTransactions(){
		return service1.getAllTransactions();
	}
	
	@ApiOperation(value = "Update Stock Price" , response = List.class)
	@PutMapping("/stock/{stockName}/{quantity}/{transactionType}")
	public List<Transaction> doUpdate(@PathVariable String stockName,@PathVariable int quantity, @PathVariable String transactionType){
		return service1.doUpdate(stockName,quantity,transactionType);
	}
	
	
	@ApiOperation(value = "show stock details and transaction details of transaction id " , response = Transaction.class)
	@GetMapping("/transaction/{id}")
	public Transaction getDetails(@PathVariable int id){
		return service1.getDetails(id);
	}
	
	
	
}
