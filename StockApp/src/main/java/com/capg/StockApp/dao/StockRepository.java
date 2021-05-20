package com.capg.StockApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.StockApp.beans.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer>,CustomRepository {

}
