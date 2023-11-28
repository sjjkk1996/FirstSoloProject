package com.example.firstsoloproject.repository;

import com.example.firstsoloproject.entitly.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
