package com.springboot.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.socialmedia.models.Post;

public interface Postrepository  extends JpaRepository<Post, Integer>{

	
	@Query("select p from Post p where p.user.id=:i")
	List<Post> postByUserId(@Param("i") int id);
}
