package com.soulfood.service;

import com.soulfood.exception.OrderException;
import com.soulfood.model.Order;

public interface OrderService {
    
    public Order addOrder(Order order) throws OrderException;

    public Order updateOrder(Order order) throws OrderException;

    public Order removeOrder(Integer orderId) throws OrderException;

    public Order viewOrder(Integer orderId) throws OrderException;

    

}
