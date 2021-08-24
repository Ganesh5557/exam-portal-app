package com.ganesh.Service.Interfaces.Category;

import java.util.List;

import com.ganesh.model.Category.Category;

public interface CategoryServiceInterface {

	Category addCategory(Category category);

	Category getCategory(Long cateID);

	List<Category> getAllCategory();

	void deleteCategory(Category catToBeDeleted);

	

}
