package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 서비스 선언! (서비스 객체를 스프링 부트에 생성)
public class ArticleService {
    @Autowired // DI
    private ArticleRepository articleRepository;

    // Controller에서 Service를 return 받으므로 Service의 메소드를 사용함. 그런데 기능은 같으므로 Repository의 메소드를 그대로 끌고옴
    public List<Article> index() {
        return articleRepository.findAll();
    }
}
