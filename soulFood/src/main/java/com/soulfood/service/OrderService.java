package com.soulfood.service;

import com.soulfood.exception.OrderException;
import com.soulfood.model.OrderDetails;

public interface OrderService {
    
    public OrderDetails addOrder(OrderDetails order) throws OrderException;

    public OrderDetails updateOrder(OrderDetails order) throws OrderException;

    public OrderDetails removeOrder(Integer orderId) throws OrderException;

    public OrderDetails viewOrder(Integer orderId) throws OrderException;

    

}
