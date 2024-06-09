package com.springboot.socialmedia.exceptions;

import java.time.LocalDateTime;

public class Errordetails {

	
	private String message ;
	private String error ;
	private LocalDateTime time ;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Errordetails(String message, String error, LocalDateTime time) {
		super();
		this.message = message;
		this.error = error;
		this.time = time;
	}
	public Errordetails() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
}
