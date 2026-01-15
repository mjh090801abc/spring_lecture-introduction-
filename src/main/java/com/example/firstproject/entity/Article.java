package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능
@AllArgsConstructor
@ToString
@NoArgsConstructor // 디폴트 생성자(매게변수를 가지고 있지 않음)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성 어노테이션
    private Long id; // 대표값 (사람으로 따지면 주민등록번호)

    @Column
    private String title;

    @Column
    private String content;

    // article을 고친건 수정되고 고치지 않은건 그 전에 적은것이 그대로 저장되도록 PATCH 메소드 작성
    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }
        if (article.content != null) {
            this.content = article.content;
        }
    }
}