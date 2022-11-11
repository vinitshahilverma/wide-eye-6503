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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

        @OneToOne(cascade = CascadeType.ALL)
        private Category category;
        private Integer quantity;
        private double cost;

        @JsonIgnore
        @ManyToMany  (cascade = CascadeType.ALL, mappedBy = "itemList")
        private List<Restaurant> restaurant = new ArrayList<>();
        
}
