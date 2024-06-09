package com.springboot.socialmedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.config.Jwtprovider;
import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.repository.Userrepository;
import com.springboot.socialmedia.service.userservice;

@RestController
public class UserController {


@Autowired
	userservice userservice;
	
	
	@GetMapping("/api/users")
	public List<User >getusers() throws UserException {
		
		
		List<User> u= userservice.findallusers();
		return u ;
		
		
	}
	
	
	@GetMapping("/api/user/{id}")
	public User getusersbyid(@PathVariable("id") int id) throws UserException  {
		
		User u = userservice.findbyid(id);
		return u ;

	}
	

	
	@PutMapping("/api/update")
	public String update(@RequestHeader("Authorization") String jwt ,@RequestBody User u ) throws UserException {
		
	
		User uu = userservice.findbytoken(jwt);
		String s = userservice.updateuser(uu.getId(), u);
		return s;
		
		
		
	}
	
	@DeleteMapping("/api/delete/")
	
	public String delete(@RequestHeader("Authorization") String jwt) throws UserException {
		
		User uu = userservice.findbytoken(jwt);
		String s=userservice.deleteuser(uu.getId());
		return s;
	}
	
	@GetMapping("/api/email/{email}")
	public User email(@PathVariable("email") String s) throws UserException {
		User u = userservice.findbyemail(s);
		return u ;
	}
	
	
	@GetMapping("/api/query/search")
	public List<User> query(@RequestParam("q")  String s) throws UserException {
		List<User> u = userservice.findbyquery(s);
		return u ;
	}
	
	
	@PutMapping("/api/follow/{id1}")
	public User follow(@PathVariable("id1")int id1 ,@RequestHeader("Authorization") String jwt) throws UserException {
		User uu = userservice.findbytoken(jwt);
		User i= userservice.follow(id1, uu.getId());
		return i ;
	}
	
	@PutMapping("/api/unfollow/{id1}")
	public User unfollow(@PathVariable("id1")int id1 ,@RequestHeader("Authorization") String jwt  ) throws UserException {
		
		User uu = userservice.findbytoken(jwt);
		User i= userservice.unfollow(id1, uu.getId());
		return i ;
	}
	
	
	@GetMapping("/api/token")
	public User  getuserfromtoken (@RequestHeader("Authorization")String jwt) throws UserException {
		
		User u = userservice.findbytoken(jwt);
		u.setPassword(null);
		return  u;
	}
	
}
