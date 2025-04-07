package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	//編集画面表示
	@GetMapping("/shop/{id}/edit")
	public String displayEditPage(@PathVariable Long id, Model model) {
		Shop shop = shopService.selectShopById(id);
		model.addAttribute("shopInfo", shop);
		return "shop/edit";
	}
	
	//編集情報保存
	@PostMapping("/shop/save")
	public String update(@ModelAttribute Shop shop) {
		shopService.updateShop(shop);
		return "redirect:/shop/" + shop.getId();
	}
	
	//編集情報保存
	@PostMapping("/shop/insert")
	public String insert(@ModelAttribute Shop shop) {
		shopService.insertShop(shop);
		return "shop/list";
//		return "redirect:/shop/" + shop.getId();
	}
	

	@GetMapping("/shop/add")
	public String displayAdd(Model model) {
		model.addAttribute("newShop", new Shop());
		return "shop/add";
	}

}