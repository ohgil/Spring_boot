package com.example.sbb.Answer;

import ch.qos.logback.core.model.Model;
import com.example.sbb.Question.Question;
import com.example.sbb.Question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        //
        Question question = this.questionService.getQuestion(id);//값이 여러개였으면 list 등 배열과 같이 다른방법을 사용하는게 나음
        this.answerService.create(question, content);//질문id, 답변내용 answer repository에 저장하기위해 생성자
        return String.format("redirect:/question/detail/%s", id);//내가 받아온 상태를 다시 처리할 수 있게 리턴값으로 지정
    }
}