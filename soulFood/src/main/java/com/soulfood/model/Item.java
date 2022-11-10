package com.soulfood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Integer itemId;
        private String itemName;

        @OneToOne
        private Category category;
        private Integer quantity;
        private double cost;

        @ManyToMany  (cascade = CascadeType.ALL, mappedBy = "itemList")
        private List<Restaurant> restaurant = new ArrayList<>();
        
}
