package com.springboot.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.models.Comment;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.service.Commentservice;
import com.springboot.socialmedia.service.userservice;

@RestController
public class Commentcontroller {

	@Autowired
	userservice userservice;
	
	@Autowired
	Commentservice commentservice;
	
	
	@PostMapping("/api/comment/{pid}")
public Comment createcomment(@RequestBody Comment c ,@PathVariable("pid") int pid ,@RequestHeader("Authorization") String jwt  ) throws Exception {
		
	User u =  userservice.findbytoken(jwt);
	
	Comment cc = commentservice.createcomment(c, pid, u.getId());
	
	
		return cc;
		
		
	}
	
	
	@PutMapping("/api/likecomment/{pid}")
public Comment createcomment(@PathVariable("pid") int pid ,@RequestHeader("Authorization") String jwt  ) throws Exception {
		
	User u =  userservice.findbytoken(jwt);
	
	Comment cc = commentservice.likecomment( pid, u.getId());
	
	
		return cc;
		
		
	}
}
