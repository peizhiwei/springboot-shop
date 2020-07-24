package com.peizw.service;

import java.math.BigDecimal;
import java.util.List;

import com.peizw.entities.Order;


public interface OrderService {
	/**
	 * 添加订单前，查询数据库验证待添加的订单在数据库中是否已存在
	 */
	Integer checkorderexist(Integer productId);
	/**
	 * 添加订单时，如果数据库中已存在该订单，则只增加订单数
	 * @param orderNum
	 */
	void addordernum(Integer orderNum,Integer productId);
	/**
	 * 添加订单
	 * @param order
	 */
	void addorderlist(Order order);
	
	List<Order> getorderlist();
	
	void cleanorderlist();
	
	public BigDecimal sumprice();
	
	public void updataproductstock(Integer productId);
}
