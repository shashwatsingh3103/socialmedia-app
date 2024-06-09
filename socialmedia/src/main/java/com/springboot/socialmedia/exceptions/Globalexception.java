package com.springboot.socialmedia.exceptions;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Globalexception {

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errordetails> otherExceptionhandler(Exception ue, WebRequest req){
		
		Errordetails errordetails = new Errordetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<Errordetails>(errordetails,HttpStatus.BAD_REQUEST);
	}
	
	

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Errordetails> userExceptionhandler(UserException ue, WebRequest req){
		
		Errordetails errordetails = new Errordetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<Errordetails>(errordetails,HttpStatus.BAD_REQUEST);
	}
	
	

	@ExceptionHandler(ChatException.class)
	public ResponseEntity<Errordetails> chatExceptionhandler(ChatException ue, WebRequest req){
		
		Errordetails errordetails = new Errordetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<Errordetails>(errordetails,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
}
