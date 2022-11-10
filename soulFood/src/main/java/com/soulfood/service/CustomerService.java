package com.soulfood.service;

import com.soulfood.exception.CustomerNotFound;
import com.soulfood.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer)throws CustomerNotFound;
	
	public Customer updateCustomer(Customer customer)throws CustomerNotFound;
	
	public Customer removeCustomer(Integer customerId)throws CustomerNotFound;
	
	public Customer viewCustomer(Integer customerId)throws CustomerNotFound;
}
