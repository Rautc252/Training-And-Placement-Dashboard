package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TeacherTable")
public class Teacher {
	@Id
	@Column(nullable = false , unique = true)
	private int id;
	@Column
	private String name;
	
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String dob;
	@Column
	private long contact;
	@Column
	private String field;
	@Column
	private String password;
	@Column
	private String conformpassword;
	@Column
	private String address;
	
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getConformpassword() {
		return conformpassword;
	}
	public void setConformpassword(String conformpassword) {
		this.conformpassword = conformpassword;
	}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", dob=" + dob
				+ ", contact=" + contact + ", field=" + field + ", password=" + password + ", conformpassword="
				+ conformpassword + ", address=" + address + "]";
	}
	
	
	
	
	public Teacher(int id, String name, String email, String username, String dob, long contact, String field,
			String password, String conformpassword, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.dob = dob;
		this.contact = contact;
		this.field = field;
		this.password = password;
		this.conformpassword = conformpassword;
		this.address = address;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
