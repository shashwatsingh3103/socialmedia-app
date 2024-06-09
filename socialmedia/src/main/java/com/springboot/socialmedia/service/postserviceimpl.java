package com.springboot.socialmedia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.*;
import com.springboot.socialmedia.repository.Postrepository;
import com.springboot.socialmedia.repository.Userrepository;

@Service
public class postserviceimpl implements postservice {

	
	@Autowired
	Postrepository postrepository;
	@Autowired
	userservice userservice;
	
	@Autowired
	Userrepository userrepository;
	@Override
	public Post createpost(Post p, int id) throws Exception {
	
		
		Post post = new Post();
		post.setCaption(p.getCaption());
		post.setImage(p.getImage());
         post.setCreatedat(LocalDateTime.now());
		post.setUser(userservice.findbyid(id));
		post.setVideo(p.getVideo());
		
		
	   Post pp=postrepository.save(post);
		
		return pp;
	}

	@Override
	public String deletepost(int postid, int userid) throws Exception {
	Post p= postbyid(postid);
	User u = userservice.findbyid(userid);
	if(p.getUser().getId()!=userid) {
		throw new Exception("post cannot be deleted with user id"+userid);
	}
	postrepository.delete(p);
	return "succesfully deleted post of id"+postid;
		
	}

	@Override
	public List<Post> findpostbyuserid(int userid) throws Exception {
	
		List<Post>p=postrepository.postByUserId(userid);
		return p;
		
	}

	@Override
	public Post postbyid(int postid) throws Exception {
	
		
		Optional<Post>op= postrepository.findById(postid);
		if (op.isPresent()) {
			return op.get();
		}
		throw new Exception("post not found with id"+postid);
	}

	@Override
	public List<Post> findallpost() {
		List<Post> p=postrepository.findAll();
		return p;
	}

	@Override
	public Post  savedpost(int postid, int userid) throws Exception {
	
		User u = userservice.findbyid(userid);
		Post p = postbyid(postid);
		
		if (u.getSavedpost().contains(p)) {
			u.getSavedpost().remove(p);
		}
		
		else u.getSavedpost().add(p);
		
      userrepository.save(u);
		return p; 
	}

	@Override
	public Post likedpost(int postid, int userid) throws Exception {
		
		Post p = postbyid(postid);
		User u = userservice.findbyid(userid);
		
		if (p.getLiked().contains(u)) {
			p.getLiked().remove(u);
		}else {
		p.getLiked().add(u);}
		
		Post pp=postrepository.save(p);
	return pp ;
	}

}
