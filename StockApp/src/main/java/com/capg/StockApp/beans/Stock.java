package com.capg.StockApp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Entity   
@Table(name = "Stock")
@ApiModel(value = "Stock Bean")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "StockId")
	private int stockId;
	
	@ApiModelProperty(name = "StockName",value = "Hold the min 3 char stock name",required = true)
	@NotEmpty(message = "Stock Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Stock Name should have minimum 3 and maximim 15 characters")
	@Pattern(regexp = "^[A-Za-z]*", message = "Stock Name should not be a number")
	@Column(unique = true)
	private String stockName;
	
	@ApiModelProperty(name = "StockPrice",value = "Holds only positive value")
	@Positive(message = "Price should be positive")
	private double price;
	
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Stock(int stockId,String stockName,double price) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.price = price;
	}



	public int getStockId() {
		return stockId;
	}



	public void setStockId(int stockId) {
		this.stockId = stockId;
	}



	public String getStockName() {
		return stockName;
	}



	public void setStockName(String stockName) {
		this.stockName = stockName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", price=" + price + "]";
	}




	

	
}
