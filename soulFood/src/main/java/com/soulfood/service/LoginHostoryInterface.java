package com.soulfood.service;

import java.util.List;

import com.soulfood.model.Login;
import com.soulfood.model.LoginHistory;

public interface LoginHostoryInterface {
	
	
	public void storeHistory(Login log);
	
	public List<LoginHistory> getAllHistory();

}
