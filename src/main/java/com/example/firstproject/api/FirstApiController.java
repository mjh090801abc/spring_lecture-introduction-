package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 일반 controller와 차이점 : 일반 controller는 페이지가 반환됨
// 하지만 RestController는 JSON 데이터가 나옴, 즉 반환 타입이 다름
@RestController // RestApi용 컨트롤러! JSON을 반환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
