package com.soulfood.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private LocalDateTime orderDate;

    private FoodCart foodCart;

    private String orderStatus;

    public Order() {
    }

    public Order(int orderId, LocalDateTime orderDate, FoodCart foodCart, String orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.foodCart = foodCart;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public FoodCart getFoodCart() {
        return foodCart;
    }

    public void setFoodCart(FoodCart foodCart) {
        this.foodCart = foodCart;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", foodCart=" + foodCart + ", orderStatus="
                + orderStatus + "]";
    }

    
    


}
