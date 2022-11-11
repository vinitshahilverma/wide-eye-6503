package com.soulfood.service;

import com.soulfood.model.Customer;
import com.soulfood.exception.CustomerException;
import com.soulfood.exception.CustomerNotFoundException;
import com.soulfood.exception.UnAuthorizedCustomerException;
import com.soulfood.exception.UserAllReadyLoggedInException;

public interface CustomerService {

    public Customer addCustomer (Customer customer) throws CustomerException;

    public Customer updateCustomer (Integer id, Customer customer) throws CustomerException, CustomerNotFoundException;

    public Customer removeCustomer (Integer id) throws CustomerException, CustomerNotFoundException;

    public Customer viewCustomer (Integer id) throws CustomerException;
    
    public Customer createCustomer(Customer customer) throws UserAllReadyLoggedInException, CustomerException;
    
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException;
	


}
