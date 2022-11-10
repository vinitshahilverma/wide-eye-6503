package com.soulfood.service;

import com.soulfood.model.User;

public interface UserInterferce {
	
	public User addUser(User user);
	
	public User findUserById(Integer user_Id);
	
	public User findByUsernameAndPassword(String userName,String userPassword);

	public User updatePassword(Integer user_id, User u);
	
	public User deleteUserbyId(Integer user_id);
}
