package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public boolean registerUser(User user) {
		try {
			userRepo.save(user);
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}return false;
		
	}

	@Override
	public User loginUser(String username, String password) {
		User validateUser=userRepo.findByUsername(username);
		if(validateUser != null && validateUser.getPassword().equals(password)) {
			
			return validateUser;
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public boolean updateUserProfile(User updatedUser) {
		 if (userRepo.existsById(updatedUser.getId())) {
		        userRepo.save(updatedUser);
		        return true;
		    }
		    return false;
	}
	
	
	

}