package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admintable")
public class Admin {
	
	@Id
	@Column(nullable=false, unique=true)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private long contact;
	@Column
	private String password;
	@Column
	private String conformpassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConformpassword() {
		return conformpassword;
	}
	public void setConformpassword(String conformpassword) {
		this.conformpassword = conformpassword;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", contact="
				+ contact + ", password=" + password + ", conformpassword=" + conformpassword + "]";
	}
	public Admin(int id, String name, String email, String username, long contact, String password,
			String conformpassword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.contact = contact;
		this.password = password;
		this.conformpassword = conformpassword;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
