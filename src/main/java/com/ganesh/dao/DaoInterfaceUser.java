package com.ganesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.User.User;

public interface DaoInterfaceUser extends JpaRepository<User, Long>  {
	
  User findByUserName(String username);

}
