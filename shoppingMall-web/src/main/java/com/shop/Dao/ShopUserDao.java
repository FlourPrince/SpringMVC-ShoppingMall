package com.shop.Dao;

import com.shop.Table.ShopUser;

public interface ShopUserDao {
 
	public ShopUser selectOne1(String userName);
	
	public void insert(ShopUser shopUser);
}
