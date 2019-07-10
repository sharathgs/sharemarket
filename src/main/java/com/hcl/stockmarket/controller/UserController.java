package com.hcl.stockmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseDTO createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}

}
