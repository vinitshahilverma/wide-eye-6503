package com.soulfood.service;

import com.soulfood.model.AdminDto;
import com.soulfood.model.CustomerToken;
import com.soulfood.exception.AdminAcessNotGrantedException;
import com.soulfood.exception.UserAccessNotGrantedException;
import com.soulfood.exception.UserNotFound;
import com.soulfood.exception.UserNotLoggedInException;

public interface AdminService {

	public AdminDto addAdmin(String token, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public AdminDto removeAdmin(String token, String mToken, Integer custId)throws AdminAcessNotGrantedException,UserNotFound;
	
	public boolean verifyAdmin(CustomerToken cToken,Integer custId) throws AdminAcessNotGrantedException ;
	
	public boolean verifyUser(CustomerToken cToken) throws UserAccessNotGrantedException,UserNotFound,UserNotLoggedInException;
	
}