package com.ganesh.model.Category;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ganesh.model.Quiz.Quiz;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cat_id;
	private String title, descr;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnore
	private Set<Quiz> quizes= new LinkedHashSet<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(Long cat_id, String title, String descr, Set<Quiz> quizes) {
		
		this.cat_id = cat_id;
		this.title = title;
		this.descr = descr;
		this.quizes = quizes;
	}


	public Long getCat_id() {
		return cat_id;
	}


	public void setCat_id(Long cat_id) {
		this.cat_id = cat_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public Set<Quiz> getQuizes() {
		return quizes;
	}


	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}

	
	
}
