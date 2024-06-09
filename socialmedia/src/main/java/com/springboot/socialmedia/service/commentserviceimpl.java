package com.springboot.socialmedia.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.Comment;
import com.springboot.socialmedia.repository.Commentrepository;
import com.springboot.socialmedia.repository.Postrepository;
import com.springboot.socialmedia.models.*;

@Service
public class commentserviceimpl implements Commentservice {

	@Autowired
	postservice postservice;
	@Autowired
	userservice userservice;
	
	
	@Autowired
	Commentrepository commentrepository;
	
	
	@Autowired
	Postrepository postrepository;
	@Override
	public Comment createcomment(Comment c, int pid, int uid) throws Exception {
		
		User u = userservice.findbyid(uid);
		Post p = postservice.postbyid(pid);
		
		Comment com =  new Comment();
		com.setContent(c.getContent());
		com.setId(c.getId());
		com.setUser(u);
		com.setCreatedat(LocalDateTime.now());
		Comment cc=commentrepository.save(com);
		p.getComment().add(com);
		postrepository.save(p);
		
	
		return cc;	
	}

	@Override
	public Comment deletecomment(int cid, int uid) throws Exception {
		
		
		
		
		return null;
	}

	@Override
	public Comment likecomment(int cid, int uid) throws Exception {
		Comment c = findbyid(cid);
		User u = userservice.findbyid(uid);
		
		if (c.getLiked().contains(u)) {
			c.getLiked().remove(u);
		}
		else {
			c.getLiked().add(u);
		}
		Comment cc= commentrepository.save(c);
		
		
		return cc;
	}



	@Override
	public Comment findbyid(int id) throws Exception {
		
		Optional<Comment> c= commentrepository.findById(id);
		if (c.isEmpty()) {
			throw new Exception("no comment found with id "+id);
		}
		return c.get();
		
	}

}
