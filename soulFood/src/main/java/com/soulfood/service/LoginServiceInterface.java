package com.soulfood.service;

import com.soulfood.model.Login;

import com.soulfood.model.UserDTO;

public interface LoginServiceInterface {
	
	public Login login(UserDTO loginInfo);
	
	public Login isTokenValid(String token);
	
	public String logout(String key);
	
}
