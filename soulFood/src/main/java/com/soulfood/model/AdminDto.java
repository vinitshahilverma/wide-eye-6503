package com.soulfood.model;

import org.springframework.http.HttpStatus;

public class AdminDto {

	private String status;
	private HttpStatus httpStatus;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	@Override
	public String toString() {
		return "AdminDto [status=" + status + ", httpStatus=" + httpStatus + "]";
	}
	public AdminDto(String status, HttpStatus httpStatus) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
	}
	public AdminDto() {
		super();
	}
	
	
	
}
