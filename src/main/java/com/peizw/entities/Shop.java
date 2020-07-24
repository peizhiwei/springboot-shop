package com.peizw.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer shopId;
	private Integer shopNumber;
	private String shopName;
	private String shopFamilyName;
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(Integer shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopFamilyName() {
		return shopFamilyName;
	}
	public void setShopFamilyName(String shopFamilyName) {
		this.shopFamilyName = shopFamilyName;
	}
}
