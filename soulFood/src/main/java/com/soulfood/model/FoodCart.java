package com.soulfood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    
    @JsonIgnore
    @OneToOne
    private Customer customer;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();
    
  
    
    
}
