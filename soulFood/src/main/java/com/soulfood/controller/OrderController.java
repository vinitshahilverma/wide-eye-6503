package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.soulfood.service.OrderService;

@Controller
public class OrderController {
    
    @Autowired
    private OrderService os;

    

}
