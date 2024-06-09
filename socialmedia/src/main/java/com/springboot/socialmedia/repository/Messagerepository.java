package com.springboot.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.Message;

public interface  Messagerepository  extends JpaRepository<Message, Integer>{

	
	public List<Message> findByChatId(int id );
	
	
}
