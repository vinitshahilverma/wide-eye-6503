package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.model.AdminDto;
import com.soulfood.model.CustomerToken;
import com.soulfood.exception.AdminAcessNotGrantedException;
import com.soulfood.exception.UserNotFound;
import com.soulfood.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService aServ;
	
	@PostMapping("/")
	public ResponseEntity<AdminDto> addAdminHandler(@RequestBody CustomerToken cToken) throws AdminAcessNotGrantedException,UserNotFound {
		
		return new ResponseEntity<AdminDto>(aServ.addAdmin(cToken.getMasterToken(), cToken.getCustId()), HttpStatus.ACCEPTED); 
		
	}
	
	@PatchMapping("/")
	public ResponseEntity<AdminDto> removeAdmin(@RequestBody CustomerToken cToken)throws AdminAcessNotGrantedException, UserNotFound {
		return new ResponseEntity<AdminDto>(aServ.removeAdmin(cToken.getToken(),cToken.getMasterToken(),cToken.getCustId()), HttpStatus.ACCEPTED);
	}
	
}
