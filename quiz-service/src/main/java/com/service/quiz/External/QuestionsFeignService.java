package com.service.quiz.External;
import com.service.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

//@FeignClient(name = "questions-service")
@FeignClient(
        name = "QUESTIONS-SERVICE"
)
public interface QuestionsFeignService {

    @GetMapping("/api/questions/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable("quizId") Integer quizId);

}