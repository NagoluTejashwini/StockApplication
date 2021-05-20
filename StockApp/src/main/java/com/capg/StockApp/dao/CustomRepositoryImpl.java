package com.capg.StockApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.StockApp.beans.Transaction;



public class CustomRepositoryImpl implements CustomRepository{
	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	public List<Transaction> getTransactionByType(String type1) {
		
		Query q = entityManager.createQuery("from Transaction where transactionType=:type1");
		q.setParameter("type1", type1);
		return q.getResultList();
	}
	

	
}
