package com.soulfood.model;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime timeStamp;
	private String details;
	private String message;

	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(LocalDateTime timeStamp, String details, String message) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
