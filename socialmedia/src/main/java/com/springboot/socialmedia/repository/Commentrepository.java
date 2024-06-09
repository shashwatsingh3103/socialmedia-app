package com.springboot.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.socialmedia.models.Comment;

public interface  Commentrepository  extends JpaRepository<Comment, Integer>{

}
