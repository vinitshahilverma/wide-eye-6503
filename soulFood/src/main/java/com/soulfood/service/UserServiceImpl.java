package com.soulfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.repository.UserDao;
import com.soulfood.repository.SessionDao;
import com.soulfood.exception.UserException;
import com.soulfood.model.CurrentUserSession;
import com.soulfood.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	@Override
	public User createUser(User user)throws UserException {
		
		
		User existingCustomer= cDao.findByMobileNo(user.getMobileNo());
		
		
		
		if(existingCustomer != null) 
			throw new UserException("Customer Already Registered with Mobile number");
			
		
		
		
			return cDao.save(user);
			
			
		}

	@Override
	public User updateUser(User User, String key) throws UserException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(User.getCustomerId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return cDao.save(User);
		}
		else
			throw new UserException("Invalid Customer Details, please login first");
	
	}
		
		
		
	}



