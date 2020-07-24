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
