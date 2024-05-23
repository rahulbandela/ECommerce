package com.tap.model;

import java.sql.Date;
import java.sql.Time;

public class User 
{
	
	private int userId;
	private String name;
	private String email;
	private Long phoneNo;
	private String address;
	private String userName;
	private String password;
	private String role;	
	private Date createdDate;
	private Time lastLogin;
	
	
	public User() {
		super();
	}
	
	
	public User(String name, String email, Long phoneNo, String address, String userName, String password,
			String role) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.role = role;
		
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Time getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Time lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	

}
