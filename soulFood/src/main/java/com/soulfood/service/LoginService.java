package com.soulfood.service;

import com.soulfood.exception.LoginException;
import com.soulfood.model.*;


public interface LoginService {

	public String loginAccount(Login dto) throws LoginException;

	public String logoutAccount(String key) throws LoginException;

}
