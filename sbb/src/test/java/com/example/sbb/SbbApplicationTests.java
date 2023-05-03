package com.example.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);//questionRepository에서 Id2 객체로 가져옴
        assertTrue(oq.isPresent());//존재하는지 체크
        Question q = oq.get();//존재하면 q에 값을 담음

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");//content에 입력되는 값
        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());//createdate에 답변달린 시간을 입력
        this.answerRepository.save(a);//answerRepository에 저장

    }

}
