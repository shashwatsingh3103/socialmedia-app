package com.springboot.socialmedia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.Message;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.repository.Chatrepository;
import com.springboot.socialmedia.repository.Messagerepository;



@Service
public class messageserviceimpl implements messageservice {

	@Autowired
	Messagerepository messagerepository;
	@Autowired
	chatservice chatservice;
	@Autowired
	Chatrepository chatrepository;
	
	
	@Override
	public Message createmessage(User user, int chatid, Message chat) throws Exception {
		
		Chat c = chatservice.findchatbyid(chatid);
		
		Message m = new Message();
		m.setContent(chat.getContent());
		m.setTime(LocalDateTime.now());
		m.setImage(chat.getImage());
		m.setUser(user);
		m.setChat(c);
		Message mm = messagerepository.save(m);
		c.getMessages().add(mm);
		chatrepository.save(c);
		
		
		return mm;
	}

	@Override
	public List<Message> findchatmessage(int chatid) throws Exception {
		Chat c = chatservice.findchatbyid(chatid);
		
		List<Message> cc= messagerepository.findByChatId(chatid);
		return cc;
	}

}
