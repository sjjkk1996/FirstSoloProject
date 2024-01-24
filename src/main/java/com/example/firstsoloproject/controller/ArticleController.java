package com.example.firstsoloproject.controller;

import com.example.firstsoloproject.dto.ArticleDto;
import com.example.firstsoloproject.entitly.Article;
import com.example.firstsoloproject.repository.ArticleRepository;
import com.example.firstsoloproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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






    //     @PageableDefault
//
//       size : 한 페이지에 담을 모델의 수를 정할 수 있다. 기본 값은 10이다.
//
//       sort : 정렬의 기준이 되는 속성을 정한다.
//
//       direction : 오름차순과 내림차순 중 기준을 선택할 수 있다.
//
//       Pageable pageable : PageableDefault 값을 갖고 있는 변수를 선언한다.
    @GetMapping("/articles")
    public String articles(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Article> list = articleService.pageList(pageable);


        //페이징 버튼 처리
        model.addAttribute("articleList", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
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
