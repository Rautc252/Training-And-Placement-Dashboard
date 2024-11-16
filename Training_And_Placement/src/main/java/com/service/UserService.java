package com.service;

import com.entity.User;

public interface UserService {
	
	public boolean registerUser(User user);
	public User loginUser(String username,String password);
	
	public User getUserById(int id);
	public boolean updateUserProfile(User updatedUser);
}