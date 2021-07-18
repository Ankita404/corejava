package com.Bookapp.service;

import com.Bookapp.exception.UserNotFoundException;
import com.Bookapp.model.User;

public interface UserService {
	String validateUser(User user) throws UserNotFoundException;

}


