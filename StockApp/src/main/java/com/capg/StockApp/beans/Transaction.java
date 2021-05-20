package com.capg.StockApp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;



@Entity
public class Transaction {
	@Id
	@Column(name = "TransactionId")
	private int id;
	
	@ApiModelProperty(name = "Quantity",value = "Holds quantity")
	private int quantity;
	@ApiModelProperty(name = "TransactionType",value = "Holds value But or Sell")
	private String transactionType;
	
	@ApiModelProperty(name = "Stock",value = "Holds Stock Values")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_id", referencedColumnName = "StockId")
	private Stock stock;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Transaction(int id, int quantity, String transactionType, Stock stock) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.stock = stock;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", quantity=" + quantity + ", transactionType=" + transactionType + ", stock="
				+ stock + "]";
	}
	
	
}
