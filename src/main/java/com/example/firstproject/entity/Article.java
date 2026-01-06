package com.example.firstproject.entity;

import jakarta.persistence.*;

@Entity // DB가 해당 객체 인식 가능
public class Article {

    @Id
    @GeneratedValue // 1, 2, 3, ... 자동 생성 어노테이션
    private Long id; // 대표값 (사람으로 따지면 주민등록번호)

    @Column
    private String title;

    @Column
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
