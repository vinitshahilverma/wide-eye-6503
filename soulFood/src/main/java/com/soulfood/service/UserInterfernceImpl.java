package com.soulfood.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.exception.UserNotFound;
import com.soulfood.model.User;
import com.soulfood.repository.UserInter;


@Service
public class UserInterfernceImpl implements UserInterferce {

	@Autowired
	private UserInter ui;
	
	@Override
	public User addUser(User user) {
		
		User u = ui.save(user);
		
		return u;
	}

	@Override
	public User findUserById(Integer user_Id) {
		
		Optional<User> ob = ui.findById(user_Id);
		
		if(ob.isPresent()) {
			
			User u = ob.get();
			return u;
		}
		return null;
		
		
		
	}

//	@Override
//	public User findByUsernameAndPassword(String userName, String userPassword) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public User findByUsernameAndPassword(String userName,String userPassword) {
	Optional<User> us = ui.findByUserNameAndUserPassword(userName, userPassword);
	
	if(us.isPresent()) {
		
		return us.get();
		
	}
	
		return null;
		
	}

	@Override
	public User updatePassword(Integer user_id, User u) {
		
		Optional<User> us = ui.findById(user_id);
		
		if(us.isPresent()) {
			
			return ui.save(u);
		}
		else {
			throw new UserNotFound("User Not Found : "+ user_id);
		}

		
	}

	@Override
	public User deleteUserbyId(Integer user_id) {
		
		Optional<User> us = ui.findById(user_id);
		
		if(us.isPresent()) {
			User u = us.get();
			
			ui.delete(u);
			
			return u;
		}
		else {
			throw new UserNotFound("User Not Found : "+ user_id);
		}
		
	}
	
	

}
