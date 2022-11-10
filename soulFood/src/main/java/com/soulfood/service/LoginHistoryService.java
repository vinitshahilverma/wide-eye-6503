package com.soulfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soulfood.model.Login;
import com.soulfood.model.LoginHistory;
import com.soulfood.repository.LoginHistoryRepo;



@Service
public class LoginHistoryService implements LoginHostoryInterface {
	
	
	@Autowired
	private LoginHistoryRepo repo;


	@Override
	public void storeHistory(Login log) {
		
		
		LoginHistory his = new LoginHistory();
		
		his.setLoginId(log.getLoginId());
		his.setTime(log.getKeyExpiryDate());
	
		
		repo.save(his);
		
		System.out.println("done.......!");
		
		
	}

	@Override
	public List<LoginHistory> getAllHistory() {
		
		List<LoginHistory> listHistory = repo.findAll();
		
		if(listHistory.size()>0) {
			return listHistory;
		
	    }
		return null;
	}
	
}
