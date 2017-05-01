package com.marcin.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.marcin.model.User;

@WebService
//@Service
public interface UserService {

	@WebMethod(operationName = "getUsers", action = "http://localhost:4747/user/getUsers")
	public List<User> getUsers();

	@WebMethod(operationName = "editUser", action = "http://localhost:4747/user/editUser")
	public void editUser(@WebParam User userEdit);

	@WebMethod(operationName = "addUser", action = "http://localhost:4747/user/addUser")
	public void addUser(@WebParam User user);

	@WebMethod(operationName = "deleteUser", action = "http://localhost:4747/user/deleteUser")
	public void deleteUser(@WebParam int id);
}
