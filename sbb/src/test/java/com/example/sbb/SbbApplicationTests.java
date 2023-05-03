package com.example.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa() {
        Optional<Answer> oa = this.answerRepository.findById(1);//answerRepository Id 1번값을 가져옴.
        assertTrue(oa.isPresent());//조건 맞으면
        Answer a = oa.get();//객체에 통으로 값을 담는다
        assertEquals(2, a.getQuestion().getId());//그리고 a객체의 question_id가 2인지 확인

    }

}
