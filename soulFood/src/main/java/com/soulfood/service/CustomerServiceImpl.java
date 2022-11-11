package com.soulfood.service;

import java.util.Optional;

import com.soulfood.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.repository.AddressRepo;
import com.soulfood.repository.CustomerRepo;
import com.soulfood.model.Customer;
import com.soulfood.exception.CustomerException;
import com.soulfood.exception.UnAuthorizedCustomerException;
import com.soulfood.exception.UserAllReadyLoggedInException;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private AddressRepo addressDao;

    @Autowired
    private CustomerRepo customerDao;
    
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;


    @Override
    public Customer addCustomer(Customer customer) throws CustomerException{

        Customer c1 = customerDao.findCustomer(customer.getFirstName(),customer.getLastName(),customer.getMobileNumber(),customer.getEmail());

        if (c1==null){
            return customerDao.save(customer);
        }
        else{
            throw new CustomerException("Customer Already Exists...");
        }
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) throws CustomerNotFoundException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            return customerDao.save(customer);
        }
        else {
            throw new CustomerNotFoundException("Customer Not Exists...");
        }
    }

    @Override
    public Customer removeCustomer(Integer id) throws CustomerNotFoundException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            Customer customer = (Customer) opt.get();

            customerDao.delete(customer);
            return customer;
        }
        else {
            throw new CustomerNotFoundException("Customer Not Exists...");
        }
    }

    @Override
    public Customer viewCustomer(Integer id) throws CustomerException {
        Optional opt = customerDao.findById(id);

        if (opt.isPresent()){
            return  (Customer) opt.get();
        }
        else {
            throw new CustomerException("Customer Not Exists...");
        }
    }
    
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findByMobileNumber(customer.getMobileNumber());
		
		if(opt.isPresent()) {
			System.out.println("User Already Exist");
			
			throw new CustomerException("Customer Already Exists");
		}
		
		return customerDao.save(customer);
		
	}
	
	@Override
	public Customer updateCustomer(Customer customer, String key) throws UnAuthorizedCustomerException, UserAllReadyLoggedInException {
		
		Customer customer2 = getCurrentLoginUser.getCurrentCustomer(key);
		
		if(customer2==null) {
//			System.out.println("No User found.. try Login first");
			
			throw new UserAllReadyLoggedInException("No User found.. try Login first");
		}
		customer.setCustomerId(customer2.getCustomerId());
		 customerDao.save(customer);
		
		 return customer;
	}
	

}
