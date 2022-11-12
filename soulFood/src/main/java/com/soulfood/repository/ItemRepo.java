package com.soulfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulfood.model.Category;
import com.soulfood.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	public List<Item> findByCategory(Category cat);
	
	public Item findByItemName(String name);

}
