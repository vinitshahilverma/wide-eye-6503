package com.soulfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulfood.exception.UserNotFound;
import com.soulfood.model.User;
import com.soulfood.service.UserInterferce;

@RestController
public class UserController {
	
	@Autowired
	private UserInterferce ui;
	


	@PostMapping("/bhukkad/users")
	public ResponseEntity<User> storeUser(@RequestBody User u){
		
		User cm = ui.addUser(u);
	
		
		return new ResponseEntity<User>(cm, HttpStatus.OK);
	}
	
	@GetMapping("/bhukkad/users/{id}")
    public ResponseEntity<User>	 getUserById(@PathVariable("id") Integer  userId ){
		
		User u =  ui.findUserById(userId);
		
		if(u!=null) {
			return new ResponseEntity<User> (u, HttpStatus.OK);
		}
		else{
			throw new UserNotFound("UserId not Found.."+ userId);
		}
	}
	
	@PutMapping("/bhukkad/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User u, @PathVariable("id") Integer id){
		
		User cm = ui.updatePassword(id, u);
		
		return new ResponseEntity<User>(cm, HttpStatus.OK);
	}
	
	@DeleteMapping("/bhukkad/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
		
		User cm = ui.deleteUserbyId(id);
		
		return new ResponseEntity<User>(cm, HttpStatus.OK);
	}
	
}