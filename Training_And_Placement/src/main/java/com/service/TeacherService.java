package com.service;

import com.entity.Teacher;

public interface TeacherService {
	
	public boolean registerTeacher(Teacher teacher);
	public Teacher loginTeacher(String username,String password);
}
