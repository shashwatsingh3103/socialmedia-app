package com.springboot.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.socialmedia.models.Post;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.response.Apiresponse;
import com.springboot.socialmedia.service.postservice;
import com.springboot.socialmedia.service.userservice;

@RestController
public class Postcontroller {

	@Autowired
	postservice postservice;
	
	@Autowired
	userservice userservice;
	
	@PostMapping("/api/createpost")
	public ResponseEntity<Post> createpost(@RequestBody Post p , @RequestHeader("Authorization") String jwt) throws Exception{
		
		User uu = userservice.findbytoken(jwt);
		
	   Post pp= postservice.createpost(p, uu.getId());
	   
		
		return new ResponseEntity<Post>(pp,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/deletepost/{pid}")
	public ResponseEntity<Apiresponse> deletepost(@PathVariable("pid") int pid , @RequestHeader("Authorization") String jwt) throws Exception{
		
		User uu = userservice.findbytoken(jwt);
;
		
		
		String s = postservice.deletepost(pid, uu.getId());
		Apiresponse a = new Apiresponse(s,true);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/api/post/{id}")
	
	public ResponseEntity<Post> postbyid(@PathVariable("id") int id) throws Exception{
		Post p= postservice.postbyid(id);
		return new ResponseEntity<Post>(p,HttpStatus.OK);
	}
	
@GetMapping("/api/userpost")
	
	public ResponseEntity<List<Post>> postbyuserid( @RequestHeader("Authorization") String jwt) throws Exception{
	
	User uu = userservice.findbytoken(jwt);
	
	List<Post> p= postservice.findpostbyuserid(uu.getId());
		return new ResponseEntity<>(p,HttpStatus.OK);
	}


@GetMapping("/api/allpost")

public ResponseEntity<List<Post>> allpost() throws Exception{
	List<Post> p= postservice.findallpost();
	return new ResponseEntity<>(p,HttpStatus.OK);
}

@PostMapping("/api/like/{pid}")


public ResponseEntity<Post> likepost( @RequestHeader("Authorization") String jwt ,@PathVariable("pid") int pid ) throws Exception{
	
	User uu = userservice.findbytoken(jwt);
	
	Post p= postservice.likedpost(uu.getId(), pid);
	return new ResponseEntity<>(p,HttpStatus.OK);
}

	

@PostMapping("save/{pid}")

public ResponseEntity<Post> savepost(@RequestHeader("Authorization") String jwt ,@PathVariable("pid") int pid ) throws Exception{
	
	User uu = userservice.findbytoken(jwt);
	Post p= postservice.savedpost(uu.getId(), pid);
	return new ResponseEntity<>(p,HttpStatus.OK);
}
}
