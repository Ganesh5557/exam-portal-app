package com.ganesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ganesh.model.Category.Category;

public interface DaoInterfaceCategory extends JpaRepository<Category, Long> {

}
