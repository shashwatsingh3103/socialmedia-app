package com.springboot.socialmedia.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String content ;
	private String image ;
	@ManyToOne
	private User user ;
	
	@ManyToOne
	private Chat chat ;
	private LocalDateTime  time ;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, String content, String image, User user, Chat chat, LocalDateTime time) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.user = user;
		this.chat = chat;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
}
