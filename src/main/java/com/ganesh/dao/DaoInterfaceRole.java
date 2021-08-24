package com.ganesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.User.Role;

public interface DaoInterfaceRole extends JpaRepository<Role, Long>  {

}
