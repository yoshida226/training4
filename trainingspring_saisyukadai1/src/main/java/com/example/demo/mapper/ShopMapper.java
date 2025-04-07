package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Shop;

@Mapper
public interface ShopMapper {
	List<Shop> selectAll();
	Shop selectShopById(Long id);
}
