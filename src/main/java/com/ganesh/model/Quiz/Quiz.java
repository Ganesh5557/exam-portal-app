package com.ganesh.model.Quiz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ganesh.model.Category.Category;
import com.ganesh.model.Question.Questions;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quizId;
	private String title, descr;
	private int maxQues, maxMarks, noOfQues;
	private boolean active;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Questions> questions= new HashSet<>();

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Quiz(Long quizId, String title, String desc, int maxQues, int maxMarks, int noOfQues, boolean active,
			Category category, Set<Questions> questions) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.descr = desc;
		this.maxQues = maxQues;
		this.maxMarks = maxMarks;
		this.noOfQues = noOfQues;
		this.active = active;
		this.category = category;
		this.questions = questions;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return descr;
	}

	public void setDesc(String desc) {
		this.descr = desc;
	}

	public int getMaxQues() {
		return maxQues;
	}

	public void setMaxQues(int maxQues) {
		this.maxQues = maxQues;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getNoOfQues() {
		return noOfQues;
	}

	public void setNoOfQues(int noOfQues) {
		this.noOfQues = noOfQues;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	
}
