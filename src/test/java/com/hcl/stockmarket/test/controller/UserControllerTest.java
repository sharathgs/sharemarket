package com.hcl.stockmarket.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hcl.stockmarket.controller.UserController;
import com.hcl.stockmarket.dto.ResponseDTO;
import com.hcl.stockmarket.model.User;
import com.hcl.stockmarket.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	User user;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		user = new User(1, "Sharath", "dasarahalli",24,"sharath@gmail.com","12345678", (double) 10000);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

		
	@Test
	public void UserControllerTest() throws Exception
	{
		when(userService.createUser(user)).thenReturn(new ResponseDTO("user added successfully"));
		ResponseDTO actual = userController.createUser(user);
		this.mockMvc.perform(
				post("/users/create").contentType(MediaType.APPLICATION_JSON));
		assertEquals("user added successfully", actual.getMessage());
	}

}
