package com.springboot.socialmedia.service;

import java.util.List;

import com.springboot.socialmedia.exceptions.ChatException;
import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.Chat;

public interface chatservice {

	public Chat createchat(int userid,int reqid) throws ChatException, UserException ;
	
	public Chat findchatbyid(int chatid) throws ChatException ;
	
	public List<Chat>findchatbyuserid(int id) throws ChatException ;
	
}
