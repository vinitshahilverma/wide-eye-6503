package com.soulfood.exception;

public class UnAuthorizedCustomerException extends  Exception{
	
	public UnAuthorizedCustomerException() {
		
	}
	
    public UnAuthorizedCustomerException(String message) {
    	super(message);
    	
	}

}
