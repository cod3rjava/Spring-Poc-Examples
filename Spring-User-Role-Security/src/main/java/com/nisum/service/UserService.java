package com.nisum.service;

import java.util.List;

import com.nisum.dto.UserRequest;
import com.nisum.dto.UserResponse;
import com.nisum.exception.UserNotFoundException;

public interface UserService {

	UserResponse createUser(UserRequest userRequest);

	List<UserResponse> getUsers();

	UserResponse getUserById(Long id) throws UserNotFoundException;
	
	UserResponse updateUser(UserRequest userRequest, Long id) throws UserNotFoundException;

	void deleteUserById(Long id) throws UserNotFoundException;
	
	UserResponse getUserByUsername(String username) throws UserNotFoundException;
}
