package com.example.sbb.Question;

import java.security.Principal;
import java.security.Signature;
import java.util.List;

import com.example.sbb.Answer.AnswerForm;
import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RequestMapping("/question") //이게 없으면 밑에 /question을 다 붙여야함
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")//값을 받아오고 DB에 저장
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 Principal principal) {
        if (bindingResult.hasErrors()) {//결과에 에러가 있으면 form으로 다시 보냄
            return "question_form";
        }
        SiteUser siteUser =this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";//오류가 없으면 값을 보냄

    }
}