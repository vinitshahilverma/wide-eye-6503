package com.soulfood.service;

import java.util.List;

import com.soulfood.exception.ItemException;
import com.soulfood.model.Category;
import com.soulfood.model.Item;
import com.soulfood.model.Restaurant;

public interface ItemService {

	public Item addItem(Item item) throws ItemException;
	
	public Item updateItem(Item item) throws ItemException;
	
	public Item viewItem(Integer itemId) throws ItemException;
	
	public Item removeItem(Item item) throws ItemException;
	
	public List<Item> viewAllItemsByCategory(Category cat) throws ItemException;
	
	public List<Item> viewAllItems(Restaurant res) throws ItemException;;
	
	public Item viewAllItemsByName(String name) throws ItemException;;
	
}
