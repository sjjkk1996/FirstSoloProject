package com.example.firstsoloproject.dto;

import com.example.firstsoloproject.entitly.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {
    private Long id;

    private String title;

    private String content;

    private int view;

    public Article toEntity() {
        return new Article(id, title, content, view);
    }
}
