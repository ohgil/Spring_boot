package com.example.sbb;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);//questionRepository Id 2번값을 가져옴
        assertTrue(oq.isPresent());//조건 맞으면
        Question q = oq.get();//a객체에 넣는다

        List<Answer> answerList = q.getAnswerList();//질문이 여러개 달릴 수 있어서 List로 받아옴

        assertEquals(1, answerList.size());//가져온 값이 1개인지 확인
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
        //하지만 이렇게 할 경우 오류 발생

    }

}
