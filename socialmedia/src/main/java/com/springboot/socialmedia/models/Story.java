package com.springboot.socialmedia.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	private String caption ;
	private LocalDateTime createdat;
	@ManyToOne
	private User user;
	
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Story(int id, String caption, LocalDateTime createdat, User user, String image) {
		super();
		this.id = id;
		this.caption = caption;
		this.createdat = createdat;
		this.user = user;
		this.image = image;
	}

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
