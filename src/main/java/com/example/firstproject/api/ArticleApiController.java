package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// RestApi용 controller! 데이터(JSON)를 반환
public class ArticleApiController {

    @Autowired // DI
    private ArticleRepository articleRepository;

    // GET
    @GetMapping("/api/articles")
    // Article 전체를 JSON 데이터로 반환
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    // 여기선 단일 Article을 반환할 것이므로 List를 삭제
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    // RequestBody를 활용해서 JSON 데이터를 받기
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }


    // PATCH

    // DELETE
}
