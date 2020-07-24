package com.peizw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peizw.entities.ResultMessage;
import com.peizw.entities.Shop;
import com.peizw.service.ShopService;

@Controller
public class IndexController {
	private String message = null;
	
	@Autowired
	private ShopService shopService;
	
    @RequestMapping("/")
    public String index() {
    	message = null;
        return "index";
    }
    @RequestMapping("/index1")
    public String reindex1() {
    	message = "ありがどございます！";
    	return "index";
    }
    @RequestMapping("/index2")
    public String reindex2() {
    	message = "またおねがいします！";
    	return "index";
    }
    @RequestMapping("/getmessage")
    @ResponseBody
    public ResultMessage getmessage() {
    	ResultMessage rs = new ResultMessage();
    	rs.setMessage(message);
    	return rs;
    }
    @RequestMapping("/computer")
    public String product1() {
    	return "computer";
    }
    @RequestMapping("/memorizer")
    public String product2() {
    	return "memorizer";
    }
    @RequestMapping("/orderlist")
    public String orderlist() {
    	return "orderlist";
    }
    
    //获取所有商店信息
    @RequestMapping("/getshopinfolist")
    @ResponseBody
    public List<Shop> getshopinfolist(){
    	List<Shop> shoplist = shopService.getallshop();
		return shoplist;
    }
}
