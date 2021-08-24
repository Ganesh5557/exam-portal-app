package com.ganesh.Service.Impl.Quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.Service.Interfaces.Quiz.QuizServiceInterface;
import com.ganesh.dao.DaoInterfaceQuiz;
import com.ganesh.model.Quiz.Quiz;

@Service
public class QuizServiceImpl implements QuizServiceInterface{
	
	@Autowired
	private DaoInterfaceQuiz daoInterfaceQuiz;

	@Override
	public List<Quiz> getAllQuiz() {
		return this.daoInterfaceQuiz.findAll();
	}

	@Override
	public void deleteQuiz(Quiz quizToBeDeleted) {
		this.daoInterfaceQuiz.delete(quizToBeDeleted);
	}

	@Override
	public Quiz getQuiz(Long quizID) {
		return this.daoInterfaceQuiz.findById(quizID).get();
	}

	@Override
	public Quiz addQuiz(Quiz quizToBeUpdated) {
		return this.daoInterfaceQuiz.save(quizToBeUpdated);
	}

}
