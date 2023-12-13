package com.example.firstsoloproject.entitly;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@ToString
@Getter
@Table(name = "article")
public class Article {

    @Id //대표값지정 주민등록번호 같은것임
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 id를 자동생성한다
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


}
