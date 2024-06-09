package com.springboot.socialmedia.service;

import org.springframework.stereotype.Service;

import com.springboot.socialmedia.models.Comment;

public interface Commentservice {

	
	public Comment createcomment(Comment c , int pid , int uid) throws Exception ;
	

	public Comment deletecomment( int cid , int uid)throws Exception ;
	
	public Comment likecomment( int cid , int uid)throws Exception ;

	
	public Comment findbyid(int id ) throws Exception ;
	
	
}
