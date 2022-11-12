package com.soulfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soulfood.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	@Query("select s from Restaurant s, Address a where a.city=?1")
	public List<Restaurant> getNearByRestaurant(String location);
	
}
