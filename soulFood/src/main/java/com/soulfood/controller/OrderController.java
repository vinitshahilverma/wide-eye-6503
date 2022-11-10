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

import com.soulfood.exception.OrderException;
import com.soulfood.model.Order;
import com.soulfood.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {
    
    @Autowired
    private OrderService os;

    @PostMapping("/AddOrder")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderException{

        Order AddOrder = os.addOrder(order);
        
        return new ResponseEntity<Order>(AddOrder,HttpStatus.CREATED);
    }


    @PutMapping("/updateOrder")
	public ResponseEntity<Order> updateCustomer( @RequestBody Order order)throws OrderException{
		
		Order updatedOrder=os.updateOrder(order);
		
		return new ResponseEntity<Order>(updatedOrder,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeOrder/{id}")
	public ResponseEntity<Order> removeCustomer(@PathVariable("id") Integer orderId)throws OrderException{
		
		Order removedOrder=os.removeOrder(orderId);
		
		return new ResponseEntity<Order>(removedOrder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<Order> viewOrder(@PathVariable("id") Integer orderId)throws OrderException{
		
		Order order=os.viewOrder(orderId);
		
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
	}

    

}
