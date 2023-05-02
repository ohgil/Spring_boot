package com.example.sbb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    int num = -1;

    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        return "오길환";

    }

    @GetMapping("/age")
    @ResponseBody
    public String age() {
        return "32";

    }

    @GetMapping("/height")
    @ResponseBody
    public String height() {
        return "180";

    }

    @GetMapping("/plus")
    @ResponseBody
    public int ShowPlus(int a, int b) {
        return a + b;

    }

    @GetMapping("/minus")
    @ResponseBody
    public int Showminus(int a, int b) {
        return a - b;

    }

    @GetMapping("/increase")
    @ResponseBody
    public int Showincrease() {
        num++;
        return num;

    }

    @RequestMapping("mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "홍길동" -> "INFP";
            case "홍길순" -> "ENFP";
            case "임꺽정" -> "ENFJ";
            case "반장" -> "ESTJ";
            default -> "모름";
        };
    }
}

//자바 => 구성패턴
//디자인 패턴 특정한 영역에서 자주 사용되는 코드 조각들을 연구해서
//싱글톤 패턴 클래스가 생성되고 여러가지 복사도 되고 만들어지면 어떠한 상태값이 종속돼서 증감한다면 싱글톤 패턴은 하나만
//팩토리 패턴