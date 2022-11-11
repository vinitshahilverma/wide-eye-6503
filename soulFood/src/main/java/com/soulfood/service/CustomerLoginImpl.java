package com.soulfood.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.soulfood.repository.CustomerRepo;
import com.soulfood.repository.SessionRepo;
import com.soulfood.model.CurrentUserSession;
import com.soulfood.model.Customer;

//import com.masai.UserLogin.Module.CurrentUserSession;
//import com.masai.UserLogin.Module.Customer;
//import com.masai.UserLogin.Module.CustomerDTO;
//import com.masai.UserLogin.Repository.CustomerDAO;
//import com.masai.UserLogin.Repository.SessionDAO;
//import com.masai.UserLogin.exception.UnAuthorizedCustomerException;
//import com.masai.UserLogin.exception.UserAllReadyLoggedInException;
//import com.masai.UserLogin.exception.UserNotFound;

//import com.foodDelivery.entity.dto.CustomerDAO;
import com.soulfood.model.CustomerDTO;
import com.soulfood.exception.InvalidUserNameOrPassword;
import com.soulfood.exception.UnAuthorizedCustomerException;
import com.soulfood.exception.UserAllReadyLoggedInException;
import com.soulfood.exception.UserNotFound;

import net.bytebuddy.utility.RandomString;


@Service
public abstract class CustomerLoginImpl implements CustomerLogin{
	
	@Autowired
	private CustomerRepo customerDAO;
	
	@Autowired
	private SessionRepo sessionDAO;
	
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
	
	@Override
   public CurrentUserSession logIntoAccount(CustomerDTO customerDTO) throws UserNotFound, UserAllReadyLoggedInException,InvalidUserNameOrPassword {
		
    Optional<Customer> opt = customerDAO.findByMobileNumberAndPassword(customerDTO.getMobileNo(),customerDTO.getPassword());

		if(!opt.isPresent()) {
			
//			System.out.println("Please Enter valid Mobile Number ");
			
			throw new UserNotFound("User Not Found first signUp");
		}
		
		Customer newCustomer1 = opt.get();
		Integer customerId1 = newCustomer1.getCustomerId();
		
		Optional<CurrentUserSession> CurrentUserOptional1 = sessionDAO.findByCustomerId(customerId1);
		
		if(CurrentUserOptional1.isPresent()) {
			
			return CurrentUserOptional1.get();
			
//			throw new UserAllReadyLoggedInException("User allready logged in with this Mobile Number ");
		}
		
		
		
		
		if(newCustomer1.getPassword().equals(customerDTO.getPassword())) {
			
			String key = RandomString.make(6);
		
		CurrentUserSession currentUserSession = new CurrentUserSession(newCustomer1.getCustomerId(),key,LocalDateTime.now());
		
		sessionDAO.save(currentUserSession);
		
		return currentUserSession;
		
		}
		else {
			
			throw new InvalidUserNameOrPassword("Invalid UserName or Password");
		}
		
   
		
	}
	
	@Override
	public CurrentUserSession logOutFromAccount(String key) throws UnAuthorizedCustomerException {
		
		Optional<CurrentUserSession> CurrentUserOptional = sessionDAO.findByUuid(key);
		
		if(!CurrentUserOptional.isPresent()) {
			
//			System.out.println("User is not logged i with this Number");
			throw new UnAuthorizedCustomerException("User is not logged i with this Number");
		}
		
		CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
		sessionDAO.delete(currentUserSession);
		currentUserSession.setUuid("");
		currentUserSession.setLocalDateTime(LocalDateTime.now());
		
		return currentUserSession;
	}

	public abstract Customer updateCustomer(@Valid Customer customer, String key);

}