package com.springboot.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.repository.Userrepository;

// password aur user generate karne ke lie 


@Service
public class Customuserdetailservice implements UserDetailsService {


	
	@Autowired
	Userrepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
	
		Optional<User> u = userrepository.findByEmail(username);
		
		if (u.isEmpty()) {
			throw new UsernameNotFoundException("user not found with email"+username);
		}
	
	List<GrantedAuthority> auth = new ArrayList<>();// user ke roles ke liye isme koi role nahi hai issliye blank 
		
	
	
return new org.springframework.security.core.userdetails.User(u.get().getEmail(), u.get().getPassword(), auth);
	}

}
