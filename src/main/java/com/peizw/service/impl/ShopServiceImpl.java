package com.peizw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peizw.entities.Shop;
import com.peizw.repositories.ShopRepositories;
import com.peizw.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopRepositories shopRepositories;
	@Override
	public List<Shop> getallshop() {
		List<Shop> shoplist = shopRepositories.getallshop();
		return shoplist;
	}

}
