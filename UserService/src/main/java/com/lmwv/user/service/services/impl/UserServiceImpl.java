package com.lmwv.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lmwv.user.service.entities.User;
import com.lmwv.user.service.exceptions.ResourceNotFoundException;
import com.lmwv.user.service.repository.UserRepository;
import com.lmwv.user.service.services.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger =(Logger) LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with ID= <"+userId+">"));
		
		//fetch rating of the above user from RATING_SERVICE
		
		ArrayList userRatings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, ArrayList.class);
		logger.info("{}",userRatings);
		user.setRatings(userRatings);
		return user;
	}

	@Override
	public User updateUser(String UserId, User User) {
		return null;
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
