package com.Bookapp.service;

import org.springframework.stereotype.Service;

import com.Bookapp.exception.UserNotFoundException;
import com.Bookapp.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public String validateUser(User user) {
		if(user.getUsername().equals("admin")&& user.getPassword().equals("admin123")) {
			return "admin";
		}else if(user.getUsername().equals("Sri")&& user.getPassword().equals("sri123")) {
			return "user";
		}else {
			throw new UserNotFoundException("Invalid username or password");
		}
	}
}
