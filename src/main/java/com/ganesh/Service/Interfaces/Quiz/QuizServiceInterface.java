package com.ganesh.Service.Interfaces.Quiz;

import java.util.List;

import com.ganesh.model.Quiz.Quiz;

public interface QuizServiceInterface {

	List<Quiz> getAllQuiz();

	void deleteQuiz(Quiz quizToBeDeleted);

	Quiz getQuiz(Long quizID);

	Quiz addQuiz(Quiz quizToBeUpdated);

}
