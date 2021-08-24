package com.ganesh.Service.Interfaces.Question;

import java.util.List;

import com.ganesh.model.Question.Questions;

public interface QuestionServiceInterface {

	void deleteQues(Questions quesToBeDeleted);

	Questions getQuestion(Long quesId);

	Questions addQuestion(Questions quesToBeUpdated);

	List<Questions> getAllQuestion();

	List<Questions> getAllQuestionofQuiz(Long quizId);

	List<Questions> getMaxQuestionofQuiz(Long quizId);

}
