package com.project.Board.user;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;    //이메일
    private String password; //패스워드
    private String role;     //권한
}