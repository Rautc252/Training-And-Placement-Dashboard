package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	Teacher findByUsername(String username);
	
}
