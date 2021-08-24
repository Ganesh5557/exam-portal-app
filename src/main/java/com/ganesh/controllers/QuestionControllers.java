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

import com.ganesh.Service.Interfaces.Question.QuestionServiceInterface;
import com.ganesh.model.Question.Questions;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionControllers {
	@Autowired
	private QuestionServiceInterface questionService;

	@GetMapping("/")
	public List<Questions> getAllQuestion() {
		return this.questionService.getAllQuestion();
	}
	
//	@GetMapping("/quiz/{quizId}")
//	public List<Questions> getAllQuestionofQuiz(@PathVariable("quizId") Long quizId) {
//		return this.questionService.getAllQuestionofQuiz(quizId);
//	}
	
	
	@GetMapping("/quiz/{quizId}")
	public List<Questions> getMaxQuestionofQuiz(@PathVariable("quizId") Long quizId) {
		return this.questionService.getMaxQuestionofQuiz(quizId);
	}

	@GetMapping("/{quesId}")
	public Questions getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	

	@PostMapping("/")
	public <T> ResponseEntity<T> addQuestion(@RequestBody Questions question) {
		Questions quesAdded = this.questionService.addQuestion(question);
		return (ResponseEntity<T>) ResponseEntity.ok(quesAdded);
	}

	@PutMapping("/")
	public <T> ResponseEntity<T> updateCategory(@RequestBody Questions question) {
		Questions quesUpdated = this.questionService.addQuestion(question);
		return (ResponseEntity<T>) ResponseEntity.ok(quesUpdated);
	}

	@DeleteMapping("/{quesId}")
	public void deleteCategory(@PathVariable("quesId") Long quesId) {
		Questions quesToBeDeleted = this.questionService.getQuestion(quesId);
		this.questionService.deleteQues(quesToBeDeleted);

	}

}
