package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.UserNotFoundException;
import com.spring.rest.model.Users;
import com.spring.rest.service.UserServiceImpl;

@RestController
public class App {
	@Autowired
	UserServiceImpl users;

	@GetMapping("/")
	public String home() {
		
		return "Welcome to Home Page";
	}
	@GetMapping("/users")
	public List<Users> getUsersList() throws UserNotFoundException{
		List<Users> l=users.getUsers();
		if(l.isEmpty()) {
			throw new UserNotFoundException("User List is Empty");
		}
		return l;
	}
	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable int id) throws UserNotFoundException {
		Users u=users.getUserById(id);
		if(u==null) {
			throw new UserNotFoundException("User not found");
		}
		return u;
	}
	@PostMapping("/users")
	public Users addUser(@RequestBody Users user) {
		return users.addUser(user);
	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Users updateUser(@RequestBody Users user,@PathVariable int id) throws UserNotFoundException {
		Users u=users.updateUser(user, id);
		if(u==null) {
			throw new UserNotFoundException("User not found");
		}
		return u;
	}
	@DeleteMapping("/users")
	public String deleteAll() {
		return users.deleteAll();
	}
	@DeleteMapping("/users/{id}")
	public String deleteById(@PathVariable int id) throws UserNotFoundException {
		String s=users.deleteById(id);
		if(s==null) {
			throw new UserNotFoundException("User not found");
		}
		return s;
	}
	@PostMapping("/users/{id}/posts")
	public String addPostById(@RequestBody String post ,@PathVariable int id) {
		String msg=users.addPostById(id,post);
		return msg;
	}
}
