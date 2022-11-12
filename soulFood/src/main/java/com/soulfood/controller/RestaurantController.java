package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.RestaurantException;
import com.soulfood.model.Restaurant;
import com.soulfood.service.RestaurantService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
}
