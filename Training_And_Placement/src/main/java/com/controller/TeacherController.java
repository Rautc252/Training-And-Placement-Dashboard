package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Teacher;
import com.repository.TeacherRepository;
import com.service.TeacherService;


@Controller
public class TeacherController {
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/registerteacher")
	public String openRegister(Model model) {
		model.addAttribute("teacher",new Teacher());
		return "registerteacher";
	}
	
	@PostMapping("/registerteacher")
	public String submitform(@ModelAttribute("teacher") Teacher teacher,Model model){
		
		boolean result =teacherService.registerTeacher(teacher);
		if(result){
			model.addAttribute("success","user registrated...!");
		}else {
			model.addAttribute("error","user not registrated...!");
		}
		return "registerteacher"; 
	}
		
	@GetMapping("/teacherloginform")
	public String openLogin(Model model) {
		model.addAttribute("teacher",new Teacher());
		return "loginteacher";
	}
	
	@PostMapping("/teacherloginform")
	public String submitloginnform(@ModelAttribute("teacher")Teacher teacher , Model model) {
		Teacher validateuseTeacher = teacherService.loginTeacher(teacher.getUsername(),teacher.getPassword());
		if(validateuseTeacher!=null) {
			model.addAttribute("modelName",validateuseTeacher.getName());
			model.addAttribute("modelId",validateuseTeacher.getId());
			model.addAttribute("modelUsername",validateuseTeacher.getUsername());
			model.addAttribute("modelEmail",validateuseTeacher.getEmail());
			model.addAttribute("modelField",validateuseTeacher.getField());
			model.addAttribute("modelDob",validateuseTeacher.getDob());
			model.addAttribute("modelContact",validateuseTeacher.getContact());
			model.addAttribute("modelAddress",validateuseTeacher.getAddress());
			
			
			return "profile";
		}else {
			model.addAttribute("error","User and pssword doesnt match ");
			return "login";
		}
		
	}
	
	
	
	
	
	

	
	
	
		
}


