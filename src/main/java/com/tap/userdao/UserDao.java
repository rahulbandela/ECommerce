package com.tap.userdao;

import java.util.List;

import com.tap.model.User;

public interface UserDao 
{
	
	public void addUser(User user);
	public User getUser(int id);
	public List<User> getAll();
	public void updateUser(User user);
	public void deleteUser(int id);
	

}
