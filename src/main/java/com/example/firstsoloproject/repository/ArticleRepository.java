package com.example.firstsoloproject.repository;

import com.example.firstsoloproject.entitly.Article;
import com.example.firstsoloproject.entitly.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();

    //게시글 뷰 시작지점
    @Modifying
    @Query("update Article p set p.view = p.view + 1 where p.id = :id")
    int updateView(Long id);

}
