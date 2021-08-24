package com.ganesh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.Quiz.Quiz;

public interface DaoInterfaceQuiz extends JpaRepository<Quiz, Long>  {

}
