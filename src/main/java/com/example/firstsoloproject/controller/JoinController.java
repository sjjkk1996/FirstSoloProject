package com.example.firstsoloproject.controller;

import com.example.firstsoloproject.dto.JoinDto;
import com.example.firstsoloproject.entitly.Join;
import com.example.firstsoloproject.repository.JoinRepository;
import com.example.firstsoloproject.service.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String join(){

        return "/main/join";
    }

    @PostMapping(value = "/createUser")
    public String createUser(JoinDto joinDto){
        joinService.save(joinDto);
        return "redirect:/main";
    }

}
