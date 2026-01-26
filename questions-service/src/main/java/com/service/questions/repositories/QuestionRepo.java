package com.service.questions.repositories;

import com.service.questions.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByQuizId(Integer quizId);

}
