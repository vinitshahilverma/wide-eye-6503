package com.soulfood.service;

import java.util.List;

import com.soulfood.exception.RestaurantException;
import com.soulfood.model.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant rest)throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant rest)throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
	
	public Restaurant viewRestaurant(Integer restaurantId)throws RestaurantException;
	
	public List<Restaurant> viewRestaurantByCity(String location) throws RestaurantException;
	
	public List<Restaurant> viewRestaurantByItemName(String location) throws RestaurantException;
	
	
}
