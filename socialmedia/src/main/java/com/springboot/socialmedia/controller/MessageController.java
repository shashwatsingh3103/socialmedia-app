package com.springboot.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.models.Message;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.service.messageservice;
import com.springboot.socialmedia.service.userservice;

@RestController
public class MessageController {

	@Autowired
	messageservice messageservice;	
	@Autowired
	
	userservice userservice;
	 
	
	@PostMapping("/api/sendmessage/{cid}")
	public Message sendmessage( @RequestHeader("Authorization") String jwt, @RequestBody Message m , @PathVariable("cid")int id) throws Exception {
		
		User u =  userservice.findbytoken(jwt);
		
		Message mess = messageservice.createmessage(u, id, m);
		
		
		return mess;
		
	}
	
	

	@GetMapping("/api/messages/{cid}")
	public List< Message >sendmessage(  @PathVariable("cid")int id) throws Exception {
		
	
		
		List<Message> mess = messageservice.findchatmessage(id);
		
		
		return mess;
		
	}
	
	
}
