package com.example.firstsoloproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {

    @GetMapping("/articles/create")
    public String createForm() {
        return "/main/new";
    }

    @PostMapping("/articles/create")
    public String create() {
        return "redirect:/main";
    }
}
