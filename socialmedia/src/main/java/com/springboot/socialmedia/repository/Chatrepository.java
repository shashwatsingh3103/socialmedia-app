package com.springboot.socialmedia.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.socialmedia.models.Chat;
import com.springboot.socialmedia.models.User;

public interface Chatrepository extends JpaRepository<Chat, Integer> {

	
	public List<Chat> findByUsersId(int id );
	
	@Query("select c from Chat c  where :user member of c.users and  :requser member of c.users")
	public Chat findchatsofuser(@Param("user") User user , @Param("requser") User requser);
	
	
	
}
