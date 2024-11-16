package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Teacher;
import com.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@Override
	public boolean registerTeacher(Teacher teacher) {
		try {
			teacherRepo.save(teacher);
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}return false;
		
	}

	@Override
	public Teacher loginTeacher(String username, String password) {
		Teacher validateteacher=teacherRepo.findByUsername(username);
		if(validateteacher != null && validateteacher.getPassword().equals(password)) {
			
			return validateteacher;
		}
		return null;
	}

}
