package com.service;

import java.util.List;

import com.entity.Cart;

public interface CartService 
{
	Object addToCart(Cart c);
	
	List<Cart> getItems();

}