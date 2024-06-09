package com.springboot.socialmedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Collections;
import jakarta.servlet.http.HttpServletRequest;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class appconfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS ))// custom password aur user ke liye 
        
        
        .authorizeHttpRequests(
                Authorize -> Authorize
                        .requestMatchers("/api/**").authenticated()// konsi aunthnicate karni hai 
                        .anyRequest().permitAll()   )
                        
                        
              // api se jane ke phele filter ko check karna hai ki user valid hai ya nahi 
                        .addFilterBefore(new jwtValidator(), BasicAuthenticationFilter.class)

        // cors api aloow karne ke iye 
                        .cors(cors->cors.configurationSource(CorsConfigurationSource()))
        .httpBasic(withDefaults())
                .csrf(csrf -> csrf.disable());
		
		
		return http.build();
		
	}
	private CorsConfigurationSource CorsConfigurationSource() {
		
		
		return new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
			
				CorsConfiguration crf= new CorsConfiguration();
				List<String >l = new ArrayList<>();
				l.add("http://localhost:8989/");
				l.add("http://localhost:3000/");
				crf.setAllowedOrigins(l);
				List<String >l2=	new ArrayList<String>();
				l2.add("*");
				crf.setAllowedMethods(l2);
				crf.setAllowCredentials(true);
				crf.setAllowedHeaders(l2);
				
				
				List<String >l3 = new ArrayList<>();
				l3.add("Authoriztion");
				crf.setExposedHeaders(l3);
				crf.setMaxAge(3600L);
				return crf;
			}
		};
	}
	@Bean
	
	PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
