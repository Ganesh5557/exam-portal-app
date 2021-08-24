package com.ganesh.Service.Impl.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ganesh.dao.DaoInterfaceUser;
import com.ganesh.model.User.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private DaoInterfaceUser userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userInDao = userDao.findByUserName(username);
		
		if (userInDao == null)
			throw new UsernameNotFoundException("No USer found!!!");
		else
		return userInDao;
		
	}

}
