package com.soulfood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.OrderException;
import com.soulfood.model.OrderDetails;
import com.soulfood.repository.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo or;

    @Override
    public OrderDetails addOrder(OrderDetails order) throws OrderException {
        if(order!=null){
            or.save(order);
            return order;
        }
        else{
            throw new OrderException("Fill all the proper detail of order");
        }
        
    }

    @Override
    public OrderDetails updateOrder(OrderDetails order) throws OrderException {
        Optional<OrderDetails> opt=or.findById(order.getOrderId());
		
		if(opt.isPresent()) {
			
			OrderDetails updatedCustomer= or.save(order);
			return updatedCustomer;
			
		}else
			throw new OrderException("Invalid Order detils"); 
    }

    @Override
    public OrderDetails removeOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> opt=or.findById(orderId);
	      
        if(opt.isPresent()) {
            
            OrderDetails deletedCustomer=opt.get();
            or.delete(deletedCustomer);
            
            return deletedCustomer;
        }
        else {
            throw new OrderException("Order not found with Id"+orderId);
        }
    }

    @Override
    public OrderDetails viewOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> opt=or.findById(orderId);
         
        if(opt.isPresent()) {
            OrderDetails customer=opt.get();
            return customer;
        }
        else {
            throw new OrderException("Order not found with Id: "+orderId);
            
        }
    }
    
}
