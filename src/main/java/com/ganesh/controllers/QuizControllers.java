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

import com.ganesh.Service.Interfaces.Quiz.QuizServiceInterface;
import com.ganesh.model.Quiz.Quiz;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizControllers {
	
	
	@Autowired
	private QuizServiceInterface quizService;

	@GetMapping("/")
	public List<Quiz> getAllQuiz() {
		return this.quizService.getAllQuiz();
	}

	@GetMapping("/{quizId}")
	public Quiz getCategory(@PathVariable("quizId") Long quizId) {
		return this.quizService.getQuiz(quizId);
	}

	@PostMapping("/")
	public <T> ResponseEntity<T> addQuiz(@RequestBody Quiz quiz) {
		Quiz quizAdded = this.quizService.addQuiz(quiz);
		return (ResponseEntity<T>) ResponseEntity.ok(quizAdded);
	}

	@PutMapping("/")
	public <T> ResponseEntity<T> updateCategory(@RequestBody Quiz quiz) {
		Quiz quizUpdated = this.quizService.addQuiz(quiz);
		return (ResponseEntity<T>) ResponseEntity.ok(quizUpdated);
	}

	@DeleteMapping("/{quizID}")
	public void deleteCategory(@PathVariable("quizID") Long quizID) {
		Quiz quizToBeDeleted = this.quizService.getQuiz(quizID);
		this.quizService.deleteQuiz(quizToBeDeleted);

	}

}
