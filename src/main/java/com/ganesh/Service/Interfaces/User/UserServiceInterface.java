package com.ganesh.Service.Interfaces.User;

import java.util.List;
import java.util.Set;

import com.ganesh.model.User.User;
import com.ganesh.model.User.UserRole;

public interface UserServiceInterface {
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public List<User> getUsers();

	public User findUserByUsername(String userN);

}
