package com.peizw.service;

import java.math.BigDecimal;
import java.util.List;

import com.peizw.entities.Order;


public interface OrderService {
	void addorderlist(Order order);
	
	List<Order> getorderlist();
	
	void cleanorderlist();
	
	public BigDecimal sumprice();
	
	public void updataproductstock(Integer productId);
}
