package com.project.Board.domain.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    private int ageGroup;
    @Column(unique = true)
    private String userId;
    private String password;
    private String nickname;
    private int height;
    private int weight;
    private String roles;


}