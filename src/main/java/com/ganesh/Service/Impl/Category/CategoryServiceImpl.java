package com.ganesh.Service.Impl.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.Service.Interfaces.Category.CategoryServiceInterface;
import com.ganesh.dao.DaoInterfaceCategory;
import com.ganesh.model.Category.Category;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface {
	
	@Autowired
	private DaoInterfaceCategory daoInterfacecategory;

	@Override
	public Category addCategory(Category category) {
		return this.daoInterfacecategory.save(category);
	}

	@Override
	public Category getCategory(Long cateID) {
		return this.daoInterfacecategory.findById(cateID).get();
	}

	@Override
	public List<Category> getAllCategory() {
		return this.daoInterfacecategory.findAll();
	}

	@Override
	public void deleteCategory(Category catToBeDeleted) {
		 this.daoInterfacecategory.delete(catToBeDeleted);
	}

}
