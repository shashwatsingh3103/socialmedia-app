package com.springboot.socialmedia.service;

import java.util.List;

import com.springboot.socialmedia.models.Story;

public interface storyservice {

	
	public List<Story >getstorybyid(int id) throws Exception ;
	
	public Story createstory(Story sid , int uid) throws Exception ;
	
}
