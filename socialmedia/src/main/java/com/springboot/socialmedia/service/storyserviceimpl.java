package com.springboot.socialmedia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.Story;
import com.springboot.socialmedia.models.User;

import com.springboot.socialmedia.repository.Storyreposetory;




@Service
public class storyserviceimpl  implements storyservice{

	@Autowired
	Storyreposetory storyreposetory;
	@Autowired
	userservice userservice;
	
	
	@Override
	public List<Story> getstorybyid(int id) throws Exception {
	
		List <Story> s=storyreposetory.findByUserId(id);
		
		return s;
	}

	@Override
	public Story createstory( Story sid, int uid) throws Exception {
	
User u = userservice.findbyid(uid);

Story s = new Story();
s.setCaption(sid.getCaption());
s.setCreatedat(LocalDateTime.now());
s.setUser(u);
s.setImage(sid.getImage());
Story k= storyreposetory.save(s);

	return k;	
		
		
	}

}
