package com.marcin.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.marcin.model.User;

@Endpoint
//@WebService
public class UserServiceEndpoint {
	
	@Autowired
	private UserService userService;
	
	@PayloadRoot(localPart = "userRequest", namespace = "http://localhost:4747/user/get")
	public @ResponsePayload List<User> getUsers(@RequestPayload User request) {
		return userService.getUsers();
	}
	
	@PayloadRoot(localPart = "addUser", namespace = "http://localhost:4747/user/add")
	public void addUser(@RequestPayload User user) {
	  userService.addUser(user);;
	}
	
	@PayloadRoot(localPart = "editUser", namespace = "http://localhost:4747/user/edit")
	public void editUser(@RequestPayload User user) {
	  userService.editUser(user);;
	}
	
	@PayloadRoot(localPart = "deleteUser", namespace = "http://localhost:4747/user/delete")
	public void deleteUser(@RequestPayload int id) {
	  userService.deleteUser(id);;
	}
}
