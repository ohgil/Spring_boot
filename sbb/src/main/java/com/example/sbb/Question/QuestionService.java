package com.example.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;//초기화 안하면 오류가 발생. lombok을 사용

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
}