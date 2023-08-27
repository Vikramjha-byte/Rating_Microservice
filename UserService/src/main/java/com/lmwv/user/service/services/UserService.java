package com.lmwv.user.service.services;

import java.util.List;

import com.lmwv.user.service.entities.User;

public interface UserService {

	// user operations

	// create
	User saveUser(User user);

	// get all User 
	List<User> getAllUser();

	// get single user
	User getUser(String userId);
	
	//update the user details
	User updateUser(String UserId,User User);
	
	//delete the user
	User deleteUser(String userId);
}
