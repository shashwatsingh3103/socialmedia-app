package com.springboot.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.socialmedia.models.Story;
import java.util.*;

public interface Storyreposetory extends JpaRepository<Story, Integer> {
	
	public List<Story> findByUserId(int  id);

}
