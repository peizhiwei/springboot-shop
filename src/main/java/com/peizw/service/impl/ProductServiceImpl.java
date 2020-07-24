package com.peizw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peizw.entities.Product;
import com.peizw.repositories.ProductRepository;
import com.peizw.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getproductsbyshopnumber(Integer shopnumber) {
		List<Product> products = productRepository.getproductsbyshopnumber(shopnumber);
		return products;
	}

	@Override
	public List<Product> getmemorizerbyshopnumber(Integer shopnumber) {
		List<Product> memorizer = productRepository.getmemorizersbyshopnumber(shopnumber);
		return memorizer;
	}

}
