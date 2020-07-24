package com.peizw.repositories;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.peizw.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>,JpaRepository<Order, Integer> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO `order`(`product_id`, `shop_name`, `product_name`, `product_price`, `product_stock`, `order_num`) "
			+ "VALUES(:#{#order.productId},:#{#order.shopName},:#{#order.productName},:#{#order.productPrice},:#{#order.productStock},:#{#order.orderNum})",nativeQuery = true)
	void addorderlist(@Param("order")Order order);
	@Modifying
	@Query(value = "select * FROM `order`",nativeQuery = true)
	public List<Order> getorderlist();
	
	/**
	 * 计算订单总价
	 */
	@Query(value = "SELECT SUM(product_price) FROM `order`",nativeQuery = true)
	public BigDecimal sumprice();
	/**
	 * 清除订单信息
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from `order`",nativeQuery = true)
	public void cleanorderlist();
	/**
	 * 提交订单后减去产品库存
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE `product` SET `product_stock`= (`product_stock`-(SELECT `order_num` FROM `order` WHERE `product_id`=?1)) WHERE `product_id` = ?1",nativeQuery = true)
	public void updataproductstock(Integer productId);
}
