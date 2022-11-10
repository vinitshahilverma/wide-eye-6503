package com.soulfood.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    private Customer customer;

    private List<Item> itemList;

    public FoodCart() {
    }

    public FoodCart(int cartId, Customer customer, List<Item> itemList) {
        this.cartId = cartId;
        this.customer = customer;
        this.itemList = itemList;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
    }

    
    
    
}
