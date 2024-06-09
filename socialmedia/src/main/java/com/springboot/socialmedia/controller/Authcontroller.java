package com.springboot.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.config.Jwtprovider;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.request.Loginrequest;
import com.springboot.socialmedia.response.Authresponse;
import com.springboot.socialmedia.service.Customuserdetailservice;
import com.springboot.socialmedia.service.userservice;

@RestController

@RequestMapping("/auth")
public class Authcontroller {

	@Autowired
	userservice userservice;
	
	@Autowired
	Customuserdetailservice customuserdetailservice;
	
	@Autowired
	PasswordEncoder passwordencoder;
	
	
@PostMapping("/signup")
	
	public Authresponse signup(@RequestBody User u) throws Exception {
		
	Authresponse uu = userservice.registeruser(u);
	return uu;
	}


@PostMapping("/signin")
public Authresponse signin(@RequestBody Loginrequest l)  {
	
	Authentication auth = authenticate(l.getEmail(),l.getPassword());

	String token = Jwtprovider.generatetoken(auth);
	Authresponse au = new Authresponse(token, "signin sucessfully");
	
	return au;
	
}


private Authentication authenticate(String email, String password) {

	UserDetails userDetails = customuserdetailservice.loadUserByUsername(email);
	if(userDetails==null) {
		throw new BadCredentialsException("invalid username");
	}
	if(!passwordencoder.matches(password,userDetails.getPassword())) {
		throw new BadCredentialsException("invalid password");
	}
	
	
	return new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
}
}
