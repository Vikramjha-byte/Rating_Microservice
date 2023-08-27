package com.lmwv.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmwv.user.service.entities.User;
import com.lmwv.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	//create
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	//single user get
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = service.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//all user get
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = service.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
