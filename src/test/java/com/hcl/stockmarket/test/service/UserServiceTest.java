package com.hcl.stockmarket.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.repository.UserRepo;
import com.hcl.stockmarket.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepo userRepo;
	
	
	public User getUser()
	{
		User user = new User();
		user.setAddress("dasarahalli");
		user.setAge(24);
		user.setEmailid("sharathgs@gmail.com");
		user.setPassword("12345678");
		user.setPendingamount((double) 20000);
		user.setUser_id(1);
		user.setUsername("sharath");
		return user;
	}
	
	@Test
	public void userCreation()
	{
		User userData = getUser();
		Mockito.when(userRepo.save(userData)).thenReturn(userData);
		ResponseDTO actualResponse = userService.createUser(userData);
		Assert.assertEquals("User added successfully", actualResponse.getMessage());
	}
	
}
