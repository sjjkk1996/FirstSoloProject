package com.example.firstsoloproject.service;

import com.example.firstsoloproject.dto.JoinDto;
import com.example.firstsoloproject.entitly.Join;
import com.example.firstsoloproject.repository.JoinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JoinService {
    @Autowired
    private JoinRepository joinRepository;


    public Join save(JoinDto joinDto) {
        Join join = joinDto.toEntity();
        log.info(join.toString());
        if(join.getId()!=null){
            return null;
        }
        return joinRepository.save(join);

    }
}
