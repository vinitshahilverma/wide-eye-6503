package com.soulfood.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExist extends RuntimeException{
      
	public UserAlreadyExist(String message) {
    	   super(message);
    }
}
