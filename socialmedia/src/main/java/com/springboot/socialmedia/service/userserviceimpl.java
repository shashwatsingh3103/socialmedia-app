package com.springboot.socialmedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.socialmedia.config.Jwtprovider;
import com.springboot.socialmedia.exceptions.UserException;
import com.springboot.socialmedia.models.User;
import com.springboot.socialmedia.repository.Userrepository;
import com.springboot.socialmedia.response.Authresponse;


@Service
public class userserviceimpl implements userservice {
	
	@Autowired
	Userrepository userrepository;
	
	@Autowired
	PasswordEncoder passwordencoder;
	

	@Override
	public Authresponse registeruser(User u)  throws UserException {
		
		Optional<User> exist = userrepository.findByEmail(u.getEmail());
		
		if (exist.isPresent()) {
			
			throw new UserException("user alredy exist with email"+ u.getEmail());
			
		}
		
		
		User user = new User();
		user.setFirstname(u.getFirstname());
		user.setEmail(u.getEmail());
		user.setLastname(u.getLastname());
		user.setPassword(passwordencoder.encode(u.getPassword()));
		
		User uu= userrepository.save(user);
		
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		
		
		String tok = Jwtprovider.generatetoken(auth);
		Authresponse au = new Authresponse(tok, "register sucessfully");
		
		return au;
		
		
	}

	@Override
	public User findbyid(int id) throws UserException {
		
		
		Optional<User> u= userrepository.findById(id);
		if (u.isPresent()) {
			return u.get() ;
		}
		throw new UserException("user not exist with id "+id);
	}

	@Override
	public User findbyemail(String email) throws UserException {
		Optional<User> u = userrepository.findByEmail(email);
		
		if (u.isEmpty()) {
			throw new UserException("user not exist with email "+email);
		}
		return u.get();
		
	}

	@Override
	public User follow(int following, int follower) throws UserException {
	
		User folowing= findbyid(following);
		
		User folower= findbyid(follower);
		
		folower.getFollowing().add(folowing.getId());
		folowing.getFollowers().add(folower.getId());
		
		userrepository.save(folower);
		userrepository.save(folowing);
	
		
		return folower;
	}

	@Override
	public User unfollow(int following, int follower) throws UserException {
		
		
User folowing= findbyid(following);
		
		User folower= findbyid(follower);
		
		if (folower.getFollowing().contains(folowing.getId())) {
		
		

			folower.getFollowing().removeIf(element -> element.equals(folowing.getId()));
			folowing.getFollowers().removeIf(element -> element.equals(folower.getId()));
		
		userrepository.save(folower);
		userrepository.save(folowing);
	
		
		return folower;}
		throw new UserException("you  not follow userid  "+following);
	}

	@Override
	public String updateuser(int id, User u) throws UserException {
		
		Optional<User> use= userrepository.findById(id);
		if (use.isEmpty()) {
			throw new UserException("user not found with id"+id);
		}
		User user= use.get();
		
		if(u.getFirstname()!=null) {
			user.setFirstname(u.getFirstname());
		}
		
		if(u.getEmail()!=null) {
			user.setEmail(u.getEmail());
		}
		
		
		if(u.getLastname()!=null) {
			user.setLastname(u.getLastname());
		}
		
		
		if(u.getPassword()!=null) {
			user.setPassword(u.getPassword());
		}
		
		User uu=userrepository.save(user);
		return "sucessfully updated user ";
	}

	@Override
	public List<User> searchusers(String query) {
		List <User> l = userrepository.findbyquery(query);
		return l ;
	}

	@Override
	public List<User> findallusers() throws UserException {
		List<User>u=userrepository.findAll();
		return u ;
	}

	@Override
	public String deleteuser(int id) throws UserException {
		Optional<User> u = userrepository.findById(id);
		if(u.isEmpty()) {
			throw new UserException("user not find with id"+id);
		}
		userrepository.deleteById(id);
		return "user sucessfully deleted with id"+id;
	}

	@Override
	public List<User> findbyquery(String q) {
		 List<User>  u= userrepository.findbyquery(q);
		 return u;
	}

	@Override
	public User findbytoken(String jwt) throws UserException {
		
		String email= Jwtprovider.getemailfromjwt(jwt);
		
		User u = findbyemail(email);
		
		return u ;
		
		
	}

}
