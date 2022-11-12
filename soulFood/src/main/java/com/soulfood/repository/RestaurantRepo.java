package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulfood.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	
	
}
