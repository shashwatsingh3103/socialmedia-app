package com.springboot.socialmedia.response;

public  class Authresponse {

	
	private String token ;
	private String message;
	public Authresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Authresponse(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}
	
	
}
