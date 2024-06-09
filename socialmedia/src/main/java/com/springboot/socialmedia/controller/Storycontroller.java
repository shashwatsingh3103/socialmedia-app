package com.springboot.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.models.Post;
import com.springboot.socialmedia.models.Story;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.service.storyservice;
import com.springboot.socialmedia.service.userservice;

@RestController
public class Storycontroller {

	@Autowired
	storyservice storyservice ;
	
	@Autowired
	userservice userservice;
	
	
	@PostMapping("/api/createstory")
	public ResponseEntity<Story>  createStory( @RequestBody  Story s ,@RequestHeader("Authorization") String jwt   ) throws Exception {
		
		User u = userservice.findbytoken(jwt);
		
	Story ss=	storyservice.createstory(s, u.getId());
	return new ResponseEntity<Story>(ss,HttpStatus.OK);
		}
	
	
	@GetMapping("/api/story/{uid}")
	public List<Story> getStory( @PathVariable("uid")int id  ) throws Exception {
		
		
		
	List<Story >ss=	storyservice.getstorybyid(id);
	return ss;
		}
	
}
