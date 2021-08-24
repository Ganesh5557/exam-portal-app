package com.ganesh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.Question.Questions;
import com.ganesh.model.Quiz.Quiz;

public interface DaoInterfaceQuestions extends JpaRepository<Questions, Long>  {

	List<Questions> findByQuiz(Quiz quizDesired);

}
