package com.soulfood.service;

import com.soulfood.exception.UserException;
import com.soulfood.model.User;

public interface UserService {
	
	
	public User createUser(User user)throws UserException;
	
	public User updateUser(User user,String key)throws UserException;

}