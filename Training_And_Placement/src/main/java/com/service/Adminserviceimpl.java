package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.repository.AdminRepository;

@Service
public class Adminserviceimpl implements Adminservice{
	@Autowired
	AdminRepository adminrepo;

	





	@Override
	public boolean registerAdmin(Admin admin) {
		try {
			adminrepo.save(admin);
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}return false;
	
	}
	
	@Override
	public Admin loginAdmin(String username, String password) {
		Admin validateAdmin=adminrepo.findByUsername(username);
		if(validateAdmin != null && validateAdmin.getPassword().equals(password)) {
			
			return validateAdmin;
		}
		return null;
	}
	
}
