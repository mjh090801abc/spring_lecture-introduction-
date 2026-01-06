package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체 인식 가능
@AllArgsConstructor
@ToString
@NoArgsConstructor // 디폴트 생성자(매게변수를 가지고 있지 않음)
public class Article {

    @Id
    @GeneratedValue // 1, 2, 3, ... 자동 생성 어노테이션
    private Long id; // 대표값 (사람으로 따지면 주민등록번호)

    @Column
    private String title;

    @Column
    private String content;

}
