package com.example.firstsoloproject.controller;

import com.example.firstsoloproject.dto.ArticleDto;
import com.example.firstsoloproject.entitly.Article;
import com.example.firstsoloproject.repository.ArticleRepository;
import com.example.firstsoloproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/articles/create")
    public String createForm() {
        return "/main/new";
    }

    @PostMapping("/articles/create")
    public String create(ArticleDto articleDto) {
        articleService.save(articleDto);
        return "redirect:/main";
    }

    @GetMapping("/articles")
    public String articles(Model model){
        List<Article> articleEntityList = articleRepository.findAll();

        model.addAttribute("articleList", articleEntityList);

        return "main/articles";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        articleService.updateView(id);//조회수 증가카운트
        model.addAttribute("article", articleEntity);

        return "main/show";
    }

}
