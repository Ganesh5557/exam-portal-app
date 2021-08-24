package com.ganesh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.Service.Interfaces.Category.CategoryServiceInterface;
import com.ganesh.model.Category.Category;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryControllers {
	
	@Autowired
	private CategoryServiceInterface catergoryService;
	
	@GetMapping("/")
	public List<Category> getAllCategory() {
		return this.catergoryService.getAllCategory();
	}
	
	@GetMapping("/{categId}")
	public Category getCategory(@PathVariable("categId") Long cateID) {
		return this.catergoryService.getCategory(cateID);
	}
	
	@PostMapping("/")
	public <T> ResponseEntity<T> addCategory(@RequestBody Category category){
		Category cat = this.catergoryService.addCategory(category);
		return (ResponseEntity<T>) ResponseEntity.ok(cat);
	}
	
	@PutMapping("/")
	public <T> ResponseEntity<T> updateCategory(@RequestBody Category category){
		Category catUpdated = this.catergoryService.addCategory(category);
		return (ResponseEntity<T>) ResponseEntity.ok(catUpdated);
	}
	
	@DeleteMapping("/{catId}")
	public void deleteCategory(@PathVariable("catId") Long catId){
		Category catToBeDeleted = this.catergoryService.getCategory(catId);
		this.catergoryService.deleteCategory(catToBeDeleted);
		
	}

}
