package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.CartException;
import com.soulfood.exception.ItemException;
import com.soulfood.model.FoodCart;
import com.soulfood.model.Item;
import com.soulfood.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cService;
	
	@PostMapping("/foodCart")
	public ResponseEntity<FoodCart> registerCartHandler(@RequestBody FoodCart foodCart) throws CartException{
		
		FoodCart cart = cService.addFoodCart(foodCart);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/AddItemInCart/{id}")
	public ResponseEntity<FoodCart> addItemToCartHandler(@RequestBody Item item,@PathVariable("id")Integer id) throws CartException, ItemException{
		
		FoodCart cart = cService.addItemToFoodCart(id, item);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/increaseQuantity/{id}/{quantity}")
	public ResponseEntity<FoodCart> addQuantityToCartHandler(@RequestBody Item item,@PathVariable("id")Integer id,@PathVariable("quantity")Integer quantity) throws CartException, ItemException{
		
		FoodCart cart = cService.increaseQuantity(id, item, quantity);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/removeQuantity/{id}/{quantity}")
	public ResponseEntity<FoodCart> removeQuantityToCartHandler(@RequestBody Item item,@PathVariable("id")Integer id,@PathVariable("quantity")Integer quantity) throws CartException, ItemException{
		
		FoodCart cart = cService.reduceQuantity(id, item, quantity);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	@PutMapping("/removeItemFromCart/{id}")
	public ResponseEntity<FoodCart> removeItemFromCartHandler(@RequestBody Item item,@PathVariable("id")Integer id) throws CartException, ItemException{
		
		FoodCart cart = cService.removeItemFormCart(id, item);
		
		return new ResponseEntity<FoodCart>(cart,HttpStatus.OK);
		
	}
	
	 @DeleteMapping("/deleteCart")
     public ResponseEntity<FoodCart> removeItemFromCartHandler(@RequestBody FoodCart cart) throws CartException{
		
		FoodCart cart1 = cService.deleteCart(cart);
		
		return new ResponseEntity<FoodCart>(cart1,HttpStatus.OK);
		
	}

}
