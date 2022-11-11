package com.soulfood.service;

import com.soulfood.model.CurrentUserSession;
import com.soulfood.model.Customer;
import com.soulfood.model.CustomerDTO;
import com.soulfood.exception.InvalidUserNameOrPassword;
import com.soulfood.exception.UnAuthorizedCustomerException;
import com.soulfood.exception.UserAllReadyLoggedInException;
import com.soulfood.exception.UserNotFound;




public interface CustomerLogin {

	public CurrentUserSession logOutFromAccount(String key) throws UnAuthorizedCustomerException;

	public CurrentUserSession logIntoAccount(CustomerDTO customerDTO)throws UserNotFound, UserAllReadyLoggedInException,InvalidUserNameOrPassword;

	public Customer viewCustomer(Customer customer);


	
}
