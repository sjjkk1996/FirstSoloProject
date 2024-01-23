package com.example.firstsoloproject.service;

import com.example.firstsoloproject.dto.ArticleDto;
import com.example.firstsoloproject.entitly.Article;
import com.example.firstsoloproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article save(ArticleDto articleDto){
        Article article = articleDto.toEntity();
        log.info(article.toString());
        if(article.getId()!=null){
            return null;
        }
        return articleRepository.save(article);
    }

    @Transactional
    public int updateView(Long id) {
        return articleRepository.updateView(id);
    }

}
