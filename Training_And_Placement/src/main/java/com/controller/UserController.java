package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/registerform")
	public String openRegister(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/registerform")
	public String submitform(@ModelAttribute("user") User user,Model model){
		
		boolean result =userService.registerUser(user);
		if(result){
			model.addAttribute("success","user registrated...!");
		}else {
			model.addAttribute("error","user not registrated...!");
		}
		return "register"; 
	}
		
	@GetMapping("/loginform")
	public String openLogin(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/loginform")
	public String submitloginnform(@ModelAttribute( "user")User user , Model model) {
		User validateuseUser = userService.loginUser(user.getUsername(),user.getPassword());
		if(validateuseUser!=null) {
			model.addAttribute("modelName",validateuseUser.getName());
			model.addAttribute("modelId",validateuseUser.getId());
			model.addAttribute("modelUsername",validateuseUser.getUsername());
			model.addAttribute("modelEmail",validateuseUser.getEmail());
			model.addAttribute("modelField",validateuseUser.getField());
			model.addAttribute("modelDob",validateuseUser.getDob());
			model.addAttribute("modelContact",validateuseUser.getContact());
			model.addAttribute("modelAddress",validateuseUser.getAddress());
			
			
			return "profile";
		}else {
			model.addAttribute("error","User and pssword doesnt match ");
			return "login";
		}
		
	}
	
	

	 
	@GetMapping("/updateProfile")
	public String openUpdateProfile(Model model) {
	    // Fetch the current user by ID, replace 1 with your actual logic for fetching the logged-in user
	    int userId = 101; 
	    User currentUser = userService.getUserById(userId); 

	    if (currentUser != null) {
	        model.addAttribute("user", currentUser);  // Use "user" instead of "user1"
	    } else {
	        model.addAttribute("error", "User not found");
	        return "profile";
	    }
	    return "updateprofile";
	}

	@PostMapping("/updateProfile")
	public String submitUpdateProfile(@ModelAttribute("user") User user, Model model) {
	    boolean isUpdated = userService.updateUserProfile(user);
	    if (isUpdated) {
	        model.addAttribute("success", "Profile updated successfully!");
	        return "profile"; // Ideally, fetch the updated user data to display in the profile
	    } else {
	        model.addAttribute("error", "Profile update failed!");
	        return "updateprofile";
	    }
	}

	
		
}