package com.example.firstsoloproject.controller;

import com.example.firstsoloproject.dto.JoinDto;
import com.example.firstsoloproject.entitly.Join;
import com.example.firstsoloproject.repository.JoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class JoinController {

    @Autowired
    private JoinRepository joinRepository;

    @GetMapping("/join")
    public String join(){

        return "/main/join";
    }

    @PostMapping(value = "/createUser")
    public String createUser(JoinDto joinDto){
        //dto를 변환 entity로
        Join join = joinDto.toEntity();
        log.info(join.toString());

        //db안에 저장하게끔 만듬 joinentity를
        joinRepository.save(join);

         return"redirect:/main";
    }
}
