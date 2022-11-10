package com.soulfood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.CustomerNotFound;
import com.soulfood.model.Customer;
import com.soulfood.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo CR;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFound {
    
       if(customer!=null) {
    	   
    	   CR.save(customer);
    	   
    	   return customer;
       }
       else
    	   throw new CustomerNotFound("customer detail should not be null");
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFound {
		
      Optional<Customer> opt=CR.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			Customer updatedCustomer= CR.save(customer);
			return updatedCustomer;
			
		}else
			throw new CustomerNotFound("Invalid Customer detils..."); 
		
	}

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerNotFound {
		
		Optional<Customer> opt=CR.findById(customerId);
	      
	      if(opt.isPresent()) {
	    	  
	    	  Customer deletedCustomer=opt.get();
	    	  CR.delete(deletedCustomer);
	    	  
	    	  return deletedCustomer;
	      }
	      else {
	    	  throw new CustomerNotFound("Customer not found with this Id"+customerId);
	      }
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerNotFound {
		
		 Optional<Customer> opt=CR.findById(customerId);
         
			if(opt.isPresent()) {
				Customer customer=opt.get();
				return customer;
			}
			else {
				throw new CustomerNotFound("Customer not found with this Id: "+customerId);
				
			}
	}
	
	
}
