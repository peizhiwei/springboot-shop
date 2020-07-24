package com.peizw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peizw.entities.Shop;

@Repository
public interface ShopRepositories extends JpaRepository<Shop, Integer>{
	@Query(value = "select * from shop",nativeQuery = true)
	List<Shop> getallshop();
	
}
