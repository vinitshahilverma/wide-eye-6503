package com.soulfood.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.CustomerNotFound;
import com.soulfood.model.Customer;
import com.soulfood.service.CustomerService;

@RestController
public class CustomerController {
 
	@Autowired
	private CustomerService CS;
	
	@PostMapping("/AddCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)throws CustomerNotFound{
		
		Customer AddedCustomer=CS.addCustomer(customer);
		
		return new ResponseEntity<Customer>(AddedCustomer,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer( @RequestBody Customer customer)throws CustomerNotFound{
		
		Customer updatedCustomer=CS.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeCustomer/{id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("id") Integer customerId)throws CustomerNotFound{
		
		Customer removedCustomer=CS.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(removedCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewCustomer/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Integer customerId)throws CustomerNotFound{
		
		Customer Customer=CS.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(Customer,HttpStatus.ACCEPTED);
	}
	
	
}
