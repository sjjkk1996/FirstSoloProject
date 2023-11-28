package com.example.firstsoloproject.dto;

import com.example.firstsoloproject.entitly.Join;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@AllArgsConstructor
@ToString
public class JoinDto {
    private Long id;

    private String userId;

    private String userPw;

    private String userName;

    private String userNickname;

    private String userEmail;

    public Join toEntity() {
        return new Join(id, userId, userPw, userName, userNickname, userEmail);
    }

}
