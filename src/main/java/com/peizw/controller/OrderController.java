package com.peizw.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.peizw.entities.Order;
import com.peizw.entities.ResultMessage;
import com.peizw.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	// 添加电脑订单
	@RequestMapping("/addcomputerorderlist")
	@ResponseBody
	public ResultMessage addcomputerorderlist(String orderlist) {
		// 把JSON字符串转换成对象数组
		List<Order> orders = JSONArray.parseArray(orderlist, Order.class);
		for (Order order : orders) {
			Order orderobj = new Order();
			orderobj.setOrderNum(order.getOrderNum());
			orderobj.setProductId(order.getProductId());
			orderobj.setProductName(order.getProductName());
			orderobj.setProductPrice(order.getProductPrice());
			orderobj.setProductStock(order.getProductStock());
			orderobj.setShopName(order.getShopName());
			orderService.addorderlist(orderobj);
		}
		ResultMessage rs = new ResultMessage();
		rs.setFlag(true);
		rs.setMessage("/memorizer");
		return rs;
	}

	// 添加存储器订单
	@RequestMapping("/addmemorizerorderlist")
	@ResponseBody
	public ResultMessage addmemorizerorderlist(String orderlist) {
		// 把JSON字符串转换成对象数组
		List<Order> orders = JSONArray.parseArray(orderlist, Order.class);
		for (Order order : orders) {
			Order orderobj = new Order();
			orderobj.setOrderNum(order.getOrderNum());
			orderobj.setProductId(order.getProductId());
			orderobj.setProductName(order.getProductName());
			orderobj.setProductPrice(order.getProductPrice());
			orderobj.setProductStock(order.getProductStock());
			orderobj.setShopName(order.getShopName());
			orderService.addorderlist(orderobj);
		}
		ResultMessage rs = new ResultMessage();
		rs.setFlag(true);
		rs.setMessage("/orderlist");
		return rs;
	}

	// 获取订单
	@RequestMapping("/getorderlist")
	@ResponseBody
	public List<Order> getorderlist() {
		List<Order> orderlist = orderService.getorderlist();
		return orderlist;
	}
	// 计算订单总价
	@RequestMapping("/sumprice")
	@ResponseBody
	public BigDecimal sumprice() {
		BigDecimal sumprice = orderService.sumprice();
		return sumprice;
	}
	//清除订单信息
	@RequestMapping("/cleanorderlist")
	@ResponseBody
	public void cleanorderlist() {
		orderService.cleanorderlist();
	}
	//跟新产品库存
	@RequestMapping("/updateproductstock")
	@ResponseBody
	public ResultMessage updateproductstock(String productidarray) {
		String[] proIdArr=productidarray.split(",");
		for(String pId : proIdArr) {
			orderService.updataproductstock(Integer.valueOf(pId));
		}
		ResultMessage rs = new ResultMessage();
		rs.setFlag(true);
		rs.setMessage("订单提交成功！");
		return rs;
	}
}
