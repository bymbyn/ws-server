package com.marcin.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.dao.UserDao;
import com.marcin.model.User;

//@WebService(endpointInterface = "com.marcin.service.UserService")
@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void editUser(User userEdit) {
		userDao.editUser(userEdit);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

}
