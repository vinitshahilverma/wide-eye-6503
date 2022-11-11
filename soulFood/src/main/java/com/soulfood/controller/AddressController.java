package com.soulfood.controller;

import com.soulfood.model.Address;
import com.soulfood.model.Customer;
import com.soulfood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping (value = "/add")
    public ResponseEntity<Address> addAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/update")
    public ResponseEntity<Address> updateAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.ACCEPTED);
    }

    @GetMapping (value = "/")
    public ResponseEntity<String> generalMessage (){
        return new ResponseEntity<>("This is Address Controller visit https://github.com/g-utsav/FoodDeliveryApp for URL extension Detail.",HttpStatus.OK);
    }

    @DeleteMapping (value = "/remove")
    public ResponseEntity<Address> removeAddressHandler (@RequestBody Address address){
        return new ResponseEntity<>(addressService.removeAddress(address),HttpStatus.OK);
    }

    @GetMapping (value = "/get")
    public ResponseEntity<Address> viewAddressHnadler(@RequestBody Customer customer){
        return new ResponseEntity<>(addressService.viewAddress(customer.getAddress()),HttpStatus.FOUND);
    }

}
