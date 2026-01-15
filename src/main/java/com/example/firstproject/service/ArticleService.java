package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service // 서비스 선언! (서비스 객체를 스프링 부트에 생성)
public class ArticleService {
    @Autowired // DI
    private ArticleRepository articleRepository;

    // Controller에서 Service를 return 받으므로 Service의 메소드를 사용함. 그런데 기능은 같으므로 Repository의 메소드를 그대로 끌고옴
    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        // POST는 생성하기 위한 것인데 만약에 사용자가 id값도 직접 추가해버리면 기존에 있던 id와 충돌해서 다른 id가 강제로 바뀌는 경우가 있을 수 있음
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. 수정용 엔티티 생성
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 2. 대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리(대상이 없거나, id가 다른 경우)
        if (target == null || id != article.getId()) {
            log.info("id: {}, article: {}", id, article.toString());
            return null;
        }

        // 4. 업데이트 및 정상 응답(200)
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;

    }

    public Article delete(Long id) {
        // 1. 대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 2. 잘못된 요청 처리(대상 없는 경우)
        if (target == null) {
            return null;
        }
        // 3. 대상 삭제 후 응답 반환
        articleRepository.delete(target);
        return target;
    }
}
