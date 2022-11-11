package com.soulfood.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class OrderDetails {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private LocalDateTime orderDate;

    @OneToOne 
    private FoodCart foodCart;

    private String orderStatus;

    

    
    


}
