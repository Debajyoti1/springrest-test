package com.spring.rest.service;

import java.util.List;

import com.spring.rest.model.Users;

public interface UserService {
	public List<Users> getUsers();
	public Users getUserById(int id);
	public Users addUser(Users user);
	public Users updateUser(Users user,int id);
	public String deleteAll();
	public String deleteById(int id);
	public String addPostById(int id,String post);
}
