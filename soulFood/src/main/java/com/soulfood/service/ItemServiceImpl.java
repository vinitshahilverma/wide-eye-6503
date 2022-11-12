package com.soulfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.CategoryException;
import com.soulfood.exception.ItemException;
import com.soulfood.exception.RestaurantException;
import com.soulfood.model.Category;
import com.soulfood.model.Item;
import com.soulfood.model.Restaurant;
import com.soulfood.repository.CategoryRepo;
import com.soulfood.repository.ItemRepo;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	public ItemRepo iRepo;
	
	@Autowired
	public RestaurantService rService;
	
	
	@Autowired
	public CategoryRepo cRepo;

	@Override
	public Item addItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		
		if(item == null) {
			throw new ItemException("Item not be null");
		}
		
		return iRepo.save(item);
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		// TODO Auto-generated method stub
		
		Item items = iRepo.findById(item.getItemId()).orElseThrow(()-> new ItemException("Item not available for updation"));
		return iRepo.save(item);
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		// TODO Auto-generated method stub
		
		Item item = iRepo.findById(itemId).orElseThrow(() -> new ItemException("Item not available with Id :" + itemId));
		return item;
	}

	@Override
	public Item removeItem(Item item) throws ItemException {
		
		Item items = iRepo.findById(item.getItemId()).orElseThrow(() -> new ItemException("Item not available for deletation"));
		return items;
	}

	@Override
	public List<Item> viewAllItemsByCategory(Category cat) throws ItemException {
		// TODO Auto-generated method stub
		
		
		List<Item> itemList = iRepo.findByCategory(cat);
		
		if(itemList == null) {
			throw new ItemException("Item not availabel with this category");
		}
		return itemList;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) throws ItemException, RestaurantException {
		// TODO Auto-generated method stub
		
		Restaurant rest = rService.viewRestaurant(res.getRestaurantId());
		
		return rest.getItemList();
	}

	@Override
	public Item viewAllItemsByName(String name) throws ItemException {
		// TODO Auto-generated method stub
		
		Item item = iRepo.findByItemName(name);
		
		if(item == null) {
			throw new ItemException("Item not availabel with this category");
		}
		return item;
	}

}
