package com.springboot.socialmedia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.exceptions.ChatException;
import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.repository.Chatrepository;




@Service
public class chatserviceimpl  implements chatservice{

	
	@Autowired
	Chatrepository chatrepository;
	
	@Autowired
	userservice userservice;
	
	
	
	
	
	@Override
	public Chat createchat(int userid, int reqid) throws ChatException, UserException {
		
		User u = userservice.findbyid(userid);
		User r = userservice.findbyid(reqid);
		
		Chat isavil = chatrepository.findchatsofuser(u, r);
		if (isavil!=null) {
			return isavil;
		}
		Chat c = new Chat();
		c.getUsers().add(u);
		c.getUsers().add(r);
		c.setTime(LocalDateTime.now());
		
		
	Chat k=	chatrepository.save(c);
		
		return k;
	}

	@Override
	public Chat findchatbyid(int chatid) throws ChatException {
		
		Optional<Chat> cha= chatrepository.findById(chatid);
		if (cha.isEmpty()) {
			throw new ChatException("chat does not exist");
		}
		
		
		
		return cha.get();
	}

	@Override
	public List<Chat> findchatbyuserid(int id) throws ChatException {
		
		List<Chat> c = chatrepository.findByUsersId(id);
		
		
		return c;
	}

	
	
	
	
}
