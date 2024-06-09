package com.springboot.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.socialmedia.models.User;

public interface Userrepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
	
	
	@Query("SELECT u FROM User u WHERE u.firstname LIKE %:q% OR u.lastname LIKE %:q% OR u.email LIKE %:q%")
	public List<User> findbyquery(@Param("q") String query);

	
	
}
