package com.service;

import com.entity.Admin;


public interface Adminservice {
	
	public boolean registerAdmin(Admin admin);
	
	public Admin loginAdmin(String username,String password);

}
