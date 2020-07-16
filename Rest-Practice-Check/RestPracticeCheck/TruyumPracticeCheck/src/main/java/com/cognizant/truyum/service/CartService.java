package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {
	void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;

	List<MenuItem> getAllCartItems(String userId);

	void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;
}