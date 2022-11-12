package com.soulfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.RestaurantException;
import com.soulfood.model.Restaurant;
import com.soulfood.repository.RestaurantRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	public RestaurantRepo rRepo;
	
	

	@Override
	public Restaurant addRestaurant(Restaurant rest) throws RestaurantException {
		// TODO Auto-generated method stub
		if(rest == null) {
			throw new RestaurantException("Restaurant Not be null");
		}
		
		return rRepo.save(rest);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant rest) throws RestaurantException {
		// TODO Auto-generated method stub
		Restaurant res = rRepo.findById(rest.getRestaurantId()).orElseThrow(() -> new RestaurantException("Restaurant not available for updation"));
		return rRepo.save(rest);
		
	}

	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		
		Restaurant res = rRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException("Restaurant not available for deletation"));
		
		rRepo.deleteById(restaurantId);
		return res;
	}

	@Override
	public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
		// TODO Auto-generated method stub
		
		Restaurant res = rRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException("Restaurant not available with id :" + restaurantId));
		return res;
	}

	@Override
	public List<Restaurant> viewRestaurantByCity(String location) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String location) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

}
