package com.peizw.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peizw.entities.Product;
import com.peizw.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

//	private Integer shopnumber;

	@RequestMapping("/sendshopnumber")
	@ResponseBody
	public void sendshopnumber(HttpServletRequest request, Integer shopnumber) {
		request.getSession().setAttribute("shopNumber", shopnumber);
//		this.shopnumber = shopnumber;
	}

	// 根据商店番号获取所有电脑的产品信息
	@RequestMapping("/getcomputerlist")
	@ResponseBody
	public List<Product> findproducts(HttpServletRequest request) {
//		Integer shopnumber = this.shopnumber;
		Integer shopNumber = (Integer) request.getSession().getAttribute("shopNumber");
		List<Product> products = productService.getproductsbyshopnumber(shopNumber);
		return products;
	}

	// 根据商店番号获取所有电脑的产品信息
	@RequestMapping("/getmemorizerlist")
	@ResponseBody
	public List<Product> getmemorizerlist(HttpServletRequest request) {
		Integer shopNumber = (Integer) request.getSession().getAttribute("shopNumber");
		List<Product> products = productService.getmemorizerbyshopnumber(shopNumber);
		return products;
	}

}
