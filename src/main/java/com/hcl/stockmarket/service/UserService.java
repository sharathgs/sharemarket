package com.hcl.stockmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stockmarket.controller.UserController;
import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public ResponseDTO createUser(User user)
	{		
		
		if(userRepo.save(user) != null)
			return new ResponseDTO("User added successfully");
		else
			return new ResponseDTO("User Not added successfully");
	}

}
