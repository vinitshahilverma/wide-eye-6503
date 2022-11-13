package com.soulfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.ItemException;
import com.soulfood.exception.RestaurantException;
import com.soulfood.model.Restaurant;
import com.soulfood.service.RestaurantService;



@RestController
public class RestaurantController {

	@Autowired
	public RestaurantService rService;
	
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant rest) throws RestaurantException{
		
		Restaurant res = rService.addRestaurant(rest);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant rest) throws RestaurantException{
		
		Restaurant res = rService.updateRestaurant(rest);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteRestaurant/{restaurantId}")
	public ResponseEntity<Restaurant> removeRestaurant(@PathVariable Integer restaurantId) throws RestaurantException{
		
		Restaurant res = rService.removeRestaurant(restaurantId);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewRestaurant/{restaurantId}")
	public ResponseEntity<Restaurant> viewRestaurant(@PathVariable Integer restaurantId) throws RestaurantException{
		
		Restaurant res = rService.viewRestaurant(restaurantId);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	
	@GetMapping("viewNearRestaurant/{location}")
	public ResponseEntity<List<Restaurant>> viewNearRestaurant(@PathVariable String location) throws RestaurantException{
		
		List<Restaurant> list = rService.viewRestaurantByCity(location);
		
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("viewRestaurantByItem/{name}")
	public ResponseEntity<List<Restaurant>> viewRestaurantByItemName(@PathVariable String name) throws RestaurantException, ItemException{
		
		List<Restaurant> list = rService.viewRestaurantByItemName(name);
		
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
}
