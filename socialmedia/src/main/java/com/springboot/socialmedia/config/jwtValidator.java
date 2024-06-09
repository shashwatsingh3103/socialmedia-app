package com.springboot.socialmedia.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter {

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		
		String jwt=request.getHeader(Jwtconstant.JWT_HEADER);
		
		if (jwt!=null) {
			 try {
				 
				 String email=Jwtprovider.getemailfromjwt(jwt);
				 
				List< GrantedAuthority> authority = new ArrayList<>();
				Authentication auth =new UsernamePasswordAuthenticationToken(email,null, authority);
				
				SecurityContextHolder.getContext().setAuthentication(auth);
				
			} catch (Exception e) {
				throw new BadCredentialsException("invalid token ");
			}
			 
		}
		
		filterChain.doFilter(request, response);
		
	}


}
