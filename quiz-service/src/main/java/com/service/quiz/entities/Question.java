package com.service.quiz.entities;



import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Table(name = "questions_app")
public class Question {


    private Integer id;
    private String question;
   /* @ElementCollection
    private List<String> options = new ArrayList<>();*/
    private String answer;
    private Integer quizId;
}
