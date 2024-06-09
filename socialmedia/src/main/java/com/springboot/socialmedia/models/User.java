package com.springboot.socialmedia.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
private String firstname ;
private String lastname ;
private String email ;
private String password;
private List<Integer>followers = new ArrayList<>();
private List<Integer>following=new ArrayList<>();

@ManyToMany
@JsonIgnore
private List<Post> savedpost= new ArrayList<>();
private String gender ;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public List<Post> getSavedpost() {
	return savedpost;
}
public void setSavedpost(List<Post> savedpost) {
	this.savedpost = savedpost;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public List<Integer> getFollowers() {
	return followers;
}
public void setFollowers(List<Integer> followers) {
	this.followers = followers;
}
public List<Integer> getFollowing() {
	return following;
}
public void setFollowing(List<Integer> following) {
	this.following = following;
}
public User(String firstname, String lastname, String email, String password, List<Integer> followers,
		List<Integer> following, int id,String gender ,List<Post> savedpost) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.password = password;
	this.followers = followers;
	this.following = following;
	this.id = id;
	this.gender=gender;
	this.savedpost= savedpost;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
