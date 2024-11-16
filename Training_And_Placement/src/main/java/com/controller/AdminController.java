package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Admin;
import com.repository.AdminRepository;
import com.service.Adminservice;

@Controller
public class AdminController {
	
	@Autowired
	Adminservice adminservice;
	
	@Autowired
	AdminRepository adminRepository;
	

	@GetMapping("/adminform")
	public String openadminlogin(Model model) {
		model.addAttribute("admin",new Admin());
		return "adminlogin";
	}
	
	@PostMapping("/adminform")
	public String submitadminlogin(@ModelAttribute("admin") Admin admin , Model model) {
		Admin validateAdmin = adminservice.loginAdmin(admin.getUsername(),admin.getPassword());
		if(validateAdmin!=null) {
			
			return "Adminprofile";
		}else {
			model.addAttribute("error","User and pssword doesnt match ");
			return "adminlogin";
		}
	}
}
