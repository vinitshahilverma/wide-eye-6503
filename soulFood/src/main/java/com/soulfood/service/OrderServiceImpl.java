package com.soulfood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.OrderException;
import com.soulfood.model.OrderDetails;
import com.soulfood.repository.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private OrderRepo or;
//
//    @Override
//    public Order addOrder(Order order) throws OrderException {
//        if(order!=null){
//            or.save(order);
//            return order;
//        }
//        else{
//            throw new OrderException("Fill all the proper detail of order");
//        }
//        
//    }
//
//    @Override
//    public Order updateOrder(Order order) throws OrderException {
//        Optional<Order> opt=or.findById(order.getOrderId());
//		
//		if(opt.isPresent()) {
//			
//			Order updatedCustomer= or.save(order);
//			return updatedCustomer;
//			
//		}else
//			throw new OrderException("Invalid Order detils"); 
//    }
//
//    @Override
//    public Order removeOrder(Integer orderId) throws OrderException {
//        Optional<Order> opt=or.findById(orderId);
//	      
//        if(opt.isPresent()) {
//            
//            Order deletedCustomer=opt.get();
//            or.delete(deletedCustomer);
//            
//            return deletedCustomer;
//        }
//        else {
//            throw new OrderException("Order not found with Id"+orderId);
//        }
//    }
//
//    @Override
//    public Order viewOrder(Integer orderId) throws OrderException {
//        Optional<Order> opt=or.findById(orderId);
//         
//        if(opt.isPresent()) {
//            Order customer=opt.get();
//            return customer;
//        }
//        else {
//            throw new OrderException("Order not found with Id: "+orderId);
//            
//        }
//    }
    
}
