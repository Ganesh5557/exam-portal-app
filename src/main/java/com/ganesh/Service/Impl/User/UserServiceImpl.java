package com.ganesh.Service.Impl.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.Service.Interfaces.User.UserServiceInterface;
import com.ganesh.dao.DaoInterfaceRole;
import com.ganesh.dao.DaoInterfaceUser;
import com.ganesh.model.User.User;
import com.ganesh.model.User.UserRole;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private DaoInterfaceUser userDao;

	@Autowired
	private DaoInterfaceRole roleDao;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userDao.findByUserName(user.getUserName());
		if (local != null) {
			System.out.println("User is already present");
			throw new Exception("User is already present");
		} else {
			// Save the roles from the userRole to roleDao
			
			for (UserRole item: userRoles ) {
				roleDao.save(item.getRole());
			}
//			add the roles to the existing User roles
			if (user.getUserRole() != null)
			
				user.getUserRole().addAll(userRoles);
			else
				user.setUserRole(userRoles);
			local = this.userDao.save(user);
		}

		return local;
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User findUserByUsername(String userN) {
		
		return this.userDao.findByUserName(userN);
	}

}
