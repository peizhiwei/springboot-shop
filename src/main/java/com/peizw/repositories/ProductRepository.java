package com.peizw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.peizw.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>,JpaRepository<Product, Integer> {
	@Query(value = "SELECT s.*,p.* FROM product p,shop s "
			+ "WHERE p.shop_number=s.shop_number AND p.shop_number=?1 AND p.product_flag=1",nativeQuery = true)
	List<Product> getproductsbyshopnumber(Integer shopnumber);
	
	@Query(value = "SELECT s.*,p.* FROM product p,shop s "
			+ "WHERE p.shop_number=s.shop_number AND p.shop_number=?1 AND p.product_flag=2",nativeQuery = true)
	List<Product> getmemorizersbyshopnumber(Integer shopnumber);
	
}
