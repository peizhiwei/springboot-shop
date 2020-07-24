package com.peizw.service;


import java.util.List;

import com.peizw.entities.Product;


public interface ProductService {

	List<Product> getproductsbyshopnumber(Integer shopnumber);
	
	List<Product> getmemorizerbyshopnumber(Integer shopnumber);
}
