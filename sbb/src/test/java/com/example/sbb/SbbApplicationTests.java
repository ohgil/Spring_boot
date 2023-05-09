package com.example.sbb;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.sbb.Answer.Answer;
import com.example.sbb.Answer.AnswerRepository;
import com.example.sbb.Question.Question;
import com.example.sbb.Question.QuestionRepository;
import com.example.sbb.Question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }
}