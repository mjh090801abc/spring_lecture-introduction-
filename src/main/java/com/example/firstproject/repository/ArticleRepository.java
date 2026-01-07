package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> { // <관리 대상 entity, 대표값의 타입>

    @Override
    ArrayList<Article> findAll();

    Long id(Long id);
}