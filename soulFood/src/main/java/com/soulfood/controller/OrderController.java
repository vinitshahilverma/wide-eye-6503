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
import com.soulfood.model.OrderDetails;
import com.soulfood.model.OrderDetails;
import com.soulfood.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {
    
    @Autowired
    private OrderService os;

    @PostMapping("/AddOrder")
    public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) throws OrderException{

        OrderDetails AddOrder = os.addOrder(order);
        
        return new ResponseEntity<OrderDetails>(AddOrder,HttpStatus.CREATED);
    }


    @PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateCustomer( @RequestBody OrderDetails order)throws OrderException{
		
		OrderDetails updatedOrder=os.updateOrder(order);
		
		return new ResponseEntity<OrderDetails>(updatedOrder,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeOrder/{id}")
	public ResponseEntity<OrderDetails> removeCustomer(@PathVariable("id") Integer orderId)throws OrderException{
		
		OrderDetails removedOrder=os.removeOrder(orderId);
		
		return new ResponseEntity<OrderDetails>(removedOrder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewOrder/{id}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("id") Integer orderId)throws OrderException{
		
		OrderDetails order=os.viewOrder(orderId);
		
		return new ResponseEntity<OrderDetails>(order,HttpStatus.ACCEPTED);
	}

    

}
