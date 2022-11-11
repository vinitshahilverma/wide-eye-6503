package com.soulfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.ItemException;
import com.soulfood.model.Category;
import com.soulfood.model.Item;
import com.soulfood.model.Restaurant;
import com.soulfood.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class ItemController {
	
	@Autowired
	public ItemService iService;
	
	@PostMapping("/addItem")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws ItemException{
		
		Item item2 = iService.addItem(item);
		
		return new ResponseEntity<Item>(item2, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException{
		
		Item item2 = iService.updateItem(item);
		
		return new ResponseEntity<Item>(item2, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteItem")
	public ResponseEntity<Item> removeItem(@RequestBody Item item) throws ItemException{
		Item item2 = iService.removeItem(item);
		
		return new ResponseEntity<Item>(item2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getItem/{itemId}")
	public ResponseEntity<Item> viewItem(@PathVariable Integer itemId) throws ItemException{
		
		Item item= iService.viewItem(itemId);
		
		return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/itemByCategory")
	public ResponseEntity<List<Item>> viewItemByCategory(@RequestBody Category cat) throws ItemException{
		
		List<Item> itemList = iService.viewAllItemsByCategory(cat);
		
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/itemList")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Restaurant res) throws ItemException{
		
		List<Item> itemList = iService.viewAllItems(res);
		
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/itemByName/{name}")
	public ResponseEntity<List<Item>> viewItemByName(@PathVariable String name) throws ItemException{
	
		List<Item> itemList = iService.viewAllItemsByName(name);
		
		return new ResponseEntity<List<Item>>(itemList, HttpStatus.ACCEPTED);
	}

}
