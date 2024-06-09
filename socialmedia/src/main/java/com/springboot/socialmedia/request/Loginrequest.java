package com.springboot.socialmedia.request;

public class Loginrequest {

	private String email;
	private String password;
	public Loginrequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Loginrequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
