package com.example.sbb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}//QuestionRepository는 jpa에서 받아온다