package com.ganesh.Service.Impl.Question;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.Service.Interfaces.Question.QuestionServiceInterface;
import com.ganesh.Service.Interfaces.Quiz.QuizServiceInterface;
import com.ganesh.dao.DaoInterfaceQuestions;
import com.ganesh.dao.DaoInterfaceQuiz;
import com.ganesh.model.Question.Questions;
import com.ganesh.model.Quiz.Quiz;
@Service
public class QuestionServiceImpl implements QuestionServiceInterface {

	@Autowired
	private DaoInterfaceQuestions daoInterfaceQuestion;
	
	@Autowired
	private QuizServiceInterface quizServiceInterface;

	@Override
	public void deleteQues(Questions quesToBeDeleted) {
		this.daoInterfaceQuestion.delete(quesToBeDeleted);

	}

	@Override
	public Questions getQuestion(Long quesId) {

		return this.daoInterfaceQuestion.findById(quesId).get();
	}

	@Override
	public Questions addQuestion(Questions quesToBeUpdated) {

		return this.daoInterfaceQuestion.save(quesToBeUpdated);
	}

	@Override
	public List<Questions> getAllQuestion() {

		return this.daoInterfaceQuestion.findAll();
	}

	@Override
	public List<Questions> getAllQuestionofQuiz(Long quizId) {
		Quiz quizDesired = this.quizServiceInterface.getQuiz(quizId);
		return this.daoInterfaceQuestion.findByQuiz(quizDesired);
	}

	@Override
	public List<Questions> getMaxQuestionofQuiz(Long quizId) {
		
		Quiz quizDesired = this.quizServiceInterface.getQuiz(quizId);
		List<Questions> allQues = this.daoInterfaceQuestion.findByQuiz(quizDesired);
		if (quizDesired.getMaxQues()< allQues.size()) {
			
		
		List<Questions> MaxQues = allQues.subList(0, quizDesired.getMaxQues());
		Collections.shuffle(MaxQues);}
		return allQues;
	}

}
