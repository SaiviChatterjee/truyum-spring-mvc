package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	CartDao cartDao;
	
	public boolean addCartItem(Long userId,Long menuItemId) {
		try {
			cartDao.addCartItem(userId, menuItemId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Cart getAllCartItems(long userID) {
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(userID);
			double total= 0.0;
			for(MenuItem menuItem:menuItemList) {
				total+=menuItem.getPrice();
			}
			Cart cart = new Cart(menuItemList, total);
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean removeCart(long userId, long menuItemId) {
		try {
			cartDao.removeCartItem(userId, menuItemId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
