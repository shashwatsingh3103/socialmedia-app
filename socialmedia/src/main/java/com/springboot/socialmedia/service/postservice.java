package com.springboot.socialmedia.service;

import java.util.List;

import com.springboot.socialmedia.models.Post;

public interface postservice {

	Post createpost(Post p, int id) throws Exception;
	String deletepost(int postid, int userid) throws Exception;
	List<Post> findpostbyuserid(int userid)throws Exception;
	Post postbyid(int postid) throws Exception;
	List<Post> findallpost();
	Post savedpost(int postid , int userid) throws Exception ;
	Post likedpost(int postid , int userid) throws Exception ;
	
}
