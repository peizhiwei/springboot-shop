package com.peizw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peizw.entities.Shop;
import com.peizw.service.ShopService;

@Controller
public class IndexController {
	@Autowired
	private ShopService shopService;
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/index1")
    public String reindex1(Model model) {
    	model.addAttribute("message", "ありがとうございました！");
    	return "index";
    }
    @RequestMapping("/index2")
    public String reindex2(Model model) {
    	model.addAttribute("message", "またおねがいします！");
    	return "index";
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
