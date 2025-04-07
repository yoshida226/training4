package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;

@Controller
public class ShopController {

//	@GetMapping("/shop/list")
//	public String test(Model model) {
//		model.addAttribute("message", "hello world");
//		return "shop/list";
//	}

	 private final ShopService shopService;
	
	@Autowired
	public ShopController(ShopService shopService) {
		this.shopService = shopService;
	}
	
    //一覧表示
	@GetMapping("/shop/list")
	public String displayShopList(Model model) {
		List<Shop> shopList = shopService.selectAll();
		model.addAttribute("shopList", shopList);
		return "shop/list";
	}
	
	//詳細表示
	@GetMapping("/shop/{id}")
	public String displayShopInfo(@PathVariable Long id, Model model) {
		Shop shop = shopService.selectShopById(id);
		model.addAttribute("shopInfo", shop);
		return "shop/info";
	}

}