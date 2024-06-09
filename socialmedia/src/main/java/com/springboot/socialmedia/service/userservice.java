package com.springboot.socialmedia.service;

import java.util.List;

import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.response.Authresponse;

public interface userservice {

	public Authresponse registeruser(User user) throws UserException ;
	
	public User findbyid(int id) throws UserException;
	
	public User findbyemail(String email) throws UserException;
	
	public User follow(int  following , int  follower) throws UserException;
	
	public User unfollow(int  following , int  follower) throws UserException;
	
	public String updateuser(int id , User u) throws UserException;
	
	public List<User> searchusers(String query) throws UserException;
	
	public List<User> findallusers() throws UserException;
	
	public String deleteuser(int id) throws UserException;
	
public List<User> findbyquery (String q);

public User findbytoken (String jwt )throws UserException ;
	
}
