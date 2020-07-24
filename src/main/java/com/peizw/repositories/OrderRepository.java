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
	/**
	 * 添加订单前查询这些订单在数据库中是否已存在
	 */
	@Query(value = "SELECT COUNT(1) FROM `order` WHERE product_id=?1",nativeQuery = true)
	Integer checkorderexist(Integer productId);
	/**
	 * 添加订单时，如果数据库中该订单已存在，则只添加订单数
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE `order` SET `order_num` = (`order_num`+?1) WHERE `product_id` = ?2",nativeQuery = true)
	void addordernum(Integer orderNum,Integer productId);
	/**
	 * 添加订单
	 */
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
	 * 提交订单后更新产品库存
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE `product` SET `product_stock`= (`product_stock`-(SELECT `order_num` FROM `order` WHERE `product_id`=?1)) WHERE `product_id` = ?1",nativeQuery = true)
	public void updataproductstock(Integer productId);
}
