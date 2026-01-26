package com.service.questions.services;

import com.service.questions.ExceptionHandle.ResourceNotFoundException;
import com.service.questions.entities.Question;
import com.service.questions.repositories.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {


    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }


    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Integer id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
    }



    @Override
    public void deleteQuestion(Integer id) {

        questionRepo.deleteById(id);
    }

    @Override
    public Question updateQuestion(Integer id, Question updatedQuestionDTO) {
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if (optionalQuestion.isPresent()) {
            Question existingQuestion = optionalQuestion.get();
            Question updatedQuestion = null;
            existingQuestion.setQuestion(updatedQuestion.getQuestion());
            existingQuestion.setOptions(updatedQuestion.getOptions());
            existingQuestion.setAnswer(updatedQuestion.getAnswer());
            existingQuestion.setQuizId(updatedQuestion.getQuizId());
            // Set other properties as needed
            existingQuestion = questionRepo.save(existingQuestion);
            return existingQuestion;
        } else {
            throw new IllegalArgumentException("Question not found with ID: " + id);
        }
    }

    @Override
    public List<Question> getQuestionsByQuizId(Integer quizId) {
        List<Question> questions = questionRepo.findByQuizId(quizId);

        if (questions.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Questions not found for quizId: " + quizId
            );
        }

        return questions;
    }


}
