package com.example.firstsoloproject.entitly;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity //db가 해당객체를 인식 가능(해당 클래스로 테이블을 만듬 )
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자 추가 어노테이션
@Slf4j
@ToString
@Getter
@Table(name = "member")
public class Join {

    @Id //대표값지정 주민등록번호 같은것임
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 id를 자동생성한다
    private Long id;

    @Column
    private String userId;

    @Column
    private String userPw;

    @Column
    private String userName;

    @Column
    private String userNickname;

    @Column
    private String userEmail;


}
