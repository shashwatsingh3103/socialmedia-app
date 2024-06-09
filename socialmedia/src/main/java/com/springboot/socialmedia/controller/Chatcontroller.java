package com.springboot.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.exceptions.ChatException;
import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.service.chatservice;
import com.springboot.socialmedia.service.userservice;

@RestController
class Chatcontroller {

	
	@Autowired
	userservice userservice;
	@Autowired
	chatservice chatservice;
	
  @PostMapping("api/createchat/{id}")
  public Chat createchat(@PathVariable int id , @RequestHeader("Authorization") String jwt) throws ChatException, UserException {
	User u = userservice.findbytoken(jwt);
	Chat c = chatservice.createchat(u.getId(), id);
	return c ;
	
}
  
  @GetMapping("api/get/{id}")
  public Chat getchat(@PathVariable int id ) throws ChatException {

	Chat c = chatservice.findchatbyid(id);
	return c ;
  }
  
  
  @GetMapping("api/getchats")
  public List<Chat> getuserchat( @RequestHeader("Authorization") String jwt ) throws ChatException, UserException {
	  User u = userservice.findbytoken(jwt);
	List<Chat> c = chatservice.findchatbyuserid(u.getId());
	return c ;
  }
  
	
	
}
