package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.FoodCart;
@Repository
public interface CartRepo extends JpaRepository<FoodCart, Integer>{

}
