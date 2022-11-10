package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.soulfood.model.Login;
import com.soulfood.model.LoginStatus;
import com.soulfood.model.UserDTO;
import com.soulfood.service.LoginServiceInterface;

@RestController
public class LoginController {
	
	@Autowired
	private LoginServiceInterface loginService;
	
	@PostMapping("/bhukkad/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO loginInfo){
		Login logged = loginService.login(loginInfo);
		return new ResponseEntity<String>(logged.getApiKey(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bhukkad/logout/{key}")
	public ResponseEntity<String> logoutUser(@PathVariable("key") String key){
		String message = loginService.logout(key);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
	@GetMapping("/bhukkad/check/{key}")
	public ResponseEntity<LoginStatus> checkKey(@PathVariable("key") String key){
		Login message = loginService.isTokenValid(key);
		return new ResponseEntity<LoginStatus>(message.getStatus(), HttpStatus.OK);
	} 

}
