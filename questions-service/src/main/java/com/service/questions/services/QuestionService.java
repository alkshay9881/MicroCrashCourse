package com.service.questions.services;

import com.service.questions.entities.Question;

import java.util.List;

public interface QuestionService {


    Question create(Question question);

    List<Question> get();

    Question getOne(Integer id);

    void deleteQuestion(Integer id);

   Question updateQuestion(Integer id , Question question);

    List<Question> getQuestionsByQuizId(Integer quizId);

}
