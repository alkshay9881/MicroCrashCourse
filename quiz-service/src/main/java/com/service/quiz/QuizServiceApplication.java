package com.service.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.service.quiz.External")
public class QuizServiceApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(QuizServiceApplication.class);

    public static void main(String[] args) {
        logger.info("Hi h");
        SpringApplication.run(QuizServiceApplication.class, args);
    }
}
