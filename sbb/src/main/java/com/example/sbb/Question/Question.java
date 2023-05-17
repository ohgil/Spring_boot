package com.example.sbb.Question;
import java.time.LocalDateTime;
import java.util.List;

import com.example.sbb.Answer.Answer;
import com.example.sbb.user.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)//질문이 삭제됐을때 답변도 자동으로 삭제될 수 있게 제약을 걸어둠
    private List<Answer> answerList;//1대 다 관계로 List 사용

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;
}