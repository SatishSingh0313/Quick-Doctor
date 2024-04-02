package com.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.repo.CartRepo;
import com.service.CartService;

@Service
public class CartServiceImplementation implements CartService
{
	@Autowired(required = true)
	CartRepo cartrepo;
	
	@Override
	public Object addToCart(Cart c)
	{
		return cartrepo.save(c);		
	}
	
	@Override
	public List<Cart> getItems()
	{
		return cartrepo.findAll();
	}

	

}
