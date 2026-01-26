package com.service.quiz.services;

import com.service.quiz.External.QuestionsFeignService;
import com.service.quiz.entities.Question;
import com.service.quiz.entities.Quiz;
import com.service.quiz.repositories.QuizRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepo quizRepository;

    private final QuestionsFeignService questionsFeignService;


    public QuizServiceImpl(QuizRepo quizRepository, QuestionsFeignService questionsFeignService) {
        this.quizRepository = quizRepository;
        this.questionsFeignService = questionsFeignService;
    }


    @Override
    public Quiz saveQuiz(Quiz quiz) {
       return quizRepository.save(quiz);
    }



    public List<Quiz> getAllQuizzes() {
        List<Quiz> all = quizRepository.findAll();
        return all.stream().map(quiz -> {
            //calling question service to get the questions of the quiz
            //setting question to quiz
            quiz.setQuestionList(questionsFeignService.getQuestionsOfQuiz(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());

    }

    //call



    public Optional<Quiz> getQuizById(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found !!"));
        // getting questions list from question service
        List<Question> questionsOfQuiz = questionsFeignService.getQuestionsOfQuiz(quiz.getQuizId());
        //setting questions to quiz
        quiz.setQuestionList(questionsOfQuiz);
        return Optional.of(quiz);

    }

    @Override
    public void deleteQuiz(Integer quizId) {

    }

    @Override
    public Quiz updateQuiz(Integer quizId, Quiz updatedQuiz) {
        return null;
    }

    @Override
    public List<Quiz> searchQuiz(String title) {
        return List.of();
    }
}
