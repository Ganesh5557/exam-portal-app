package com.ganesh.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.Service.Interfaces.User.UserServiceInterface;
import com.ganesh.model.User.Role;
import com.ganesh.model.User.User;
import com.ganesh.model.User.UserRole;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserControllers {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired UserServiceInterface userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		
//		Encoding the password
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> userRoleSet =  new HashSet<UserRole>();
		UserRole userRole = new UserRole();
		Role role= new Role();
		role.setRole("NORMAL");
		role.setRole_id(45L);
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		try {
			 user= this.userService.createUser(user, userRoleSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userService.getUsers();
		
	}
	
	@GetMapping("/{username}")
	public User findUserByUsername(@PathVariable("username") String userN ) {
		
		return this.userService.findUserByUsername(userN);
	}
	
	
	
	
	
	
}
