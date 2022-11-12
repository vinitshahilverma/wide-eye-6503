package com.soulfood.service;

import com.soulfood.exception.CartException;
import com.soulfood.exception.ItemException;
import com.soulfood.model.FoodCart;
import com.soulfood.model.Item;

public interface CartService {

	public FoodCart addFoodCart(FoodCart cart) throws CartException;

	public FoodCart addItemToFoodCart(Integer id, Item item) throws ItemException, CartException;

	public FoodCart increaseQuantity(Integer id, Item item, Integer quantity) throws ItemException, CartException;

	public FoodCart reduceQuantity(Integer id, Item item, Integer quantity) throws ItemException, CartException;

	public FoodCart removeItemFormCart(Integer id, Item item) throws ItemException, CartException;

	public FoodCart deleteCart(FoodCart cart) throws CartException;

}
