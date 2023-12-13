package com.example.firstsoloproject.config;

import com.example.firstsoloproject.repository.JoinRepository;
import com.example.firstsoloproject.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailService  {

    @Autowired
    private JoinRepository joinRepository;




}
