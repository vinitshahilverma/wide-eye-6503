package com.soulfood.exception;

public class UserNotLoggedInException extends Exception {

	public UserNotLoggedInException() {
		super();
	}
	
	public UserNotLoggedInException(String msg) {
		super(msg);
	}
	
}