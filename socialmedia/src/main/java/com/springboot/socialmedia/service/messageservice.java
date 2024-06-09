package com.springboot.socialmedia.service;

import java.util.List;

import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.*;

public interface messageservice {

	
	public Message createmessage(User userid,int chatid, Message chat) throws Exception ;
	
	
	public List<Message> findchatmessage(int  chatid) throws Exception ;
}
