package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Shop;
import com.example.demo.mapper.ShopMapper;

@Service
public class ShopService {
	private ShopMapper shopMapper;
	
	@Autowired
	public ShopService(ShopMapper shopMapper) {
		this.shopMapper = shopMapper;
	}

	public List<Shop> selectAll() {
		return shopMapper.selectAll();
	}
	
	public Shop selectShopById(Long id) {
		return shopMapper.selectShopById(id);
	}
	
	public void updateShop(Shop shop) {
		shopMapper.updateShop(shop);
	}
	
	public Long getMaxId() {
		return shopMapper.getMaxId();
	}
	
	public void insertShop(Shop shop) {
		shopMapper.insertShop(shop);
	}
	
	public void deleteShop(Long id) {
		shopMapper.deleteShop(id);
	}

}