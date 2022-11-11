package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.OrderDetails;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails,Integer>{
    
}
