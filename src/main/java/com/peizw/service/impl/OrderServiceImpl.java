package com.peizw.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peizw.entities.Order;
import com.peizw.repositories.OrderRepository;
import com.peizw.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	/**
	 * 添加订单前，查询数据库验证待添加的订单是否已存在
	 */
	@Override
	public Integer checkorderexist(Integer productId) {
		Integer ordernum = orderRepository.checkorderexist(productId);
		return ordernum;
	}
	/**
	 * 添加订单时，如果数据库中已存在该订单，则只添加订单数
	 */
	@Override
	public void addordernum(Integer orderNum ,Integer productId) {
		orderRepository.addordernum(orderNum,productId);
	}
	/**
	 * 添加订单
	 */
	@Override
	public void addorderlist(Order order) {
		orderRepository.addorderlist(order);
	}

	@Override
	public List<Order> getorderlist() {
		List<Order> orderlist = orderRepository.getorderlist();
		return orderlist;
	}

	@Override
	public void cleanorderlist() {
		orderRepository.cleanorderlist();
	}

	@Override
	public BigDecimal sumprice() {
		BigDecimal sumprice = orderRepository.sumprice();
		return sumprice;
	}

	@Override
	public void updataproductstock(Integer productId) {
		orderRepository.updataproductstock(productId);
	}
	

}
