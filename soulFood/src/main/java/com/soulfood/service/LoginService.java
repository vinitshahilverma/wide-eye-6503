package com.soulfood.service;

import com.soulfood.exception.LoginException;
import com.soulfood.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
