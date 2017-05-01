package com.marcin.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.marcin.model.User;

@Transactional
public interface UserDao {
	public List<User> getUsers();
	
	public void addUser(User user);
	
	public void editUser(User userEdit);
	
	public void deleteUser(int id);
}
