package com.soulfood.controller;

import com.soulfood.model.Customer;
import com.soulfood.exception.CustomerException;
import com.soulfood.exception.CustomerNotFoundException;
import com.soulfood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping (value = "/view/{id}")
    public ResponseEntity<Customer> getCustomerHandler(@PathVariable ("id") Integer id) throws CustomerException{
        return new ResponseEntity<>(customerService.viewCustomer(id),HttpStatus.FOUND);
    }

    @PostMapping (value = "/add")
    public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{

        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/update/{id}")
    public ResponseEntity<Customer> updateCustomerHandler(@PathVariable ("id") Integer id, @RequestBody Customer customer) throws CustomerException, CustomerNotFoundException{

        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.ACCEPTED);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<Customer> deleteCustomerhandler(@PathVariable ("id") Integer id) throws CustomerException, CustomerNotFoundException{

        return new ResponseEntity<>(customerService.removeCustomer(id),HttpStatus.OK);
    }

    @GetMapping (value = "/")
    public ResponseEntity<String> generalMessage (){
        return new ResponseEntity<>("This is Customer Controller visit https://github.com/g-utsav/FoodDeliveryApp for URL extension Detail.",HttpStatus.OK);
    }
}