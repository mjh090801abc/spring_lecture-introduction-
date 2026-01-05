package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        // addAttribute로 변수 등록
        model.addAttribute("username", "문정훈");

        return "greetings"; // 응답 페이지 설정 (브라우저로 전송)
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "문정훈");

        return "goodbye";
    }
}
