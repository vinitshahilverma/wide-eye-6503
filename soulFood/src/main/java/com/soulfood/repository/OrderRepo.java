package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>{
    
}
