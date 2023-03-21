package com.project.Board.domain.dto.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Member {
    private Long id;
    private String name;
    private String sex;
    private int ageGroup;
    private String userId;
    private String password;
    private String nickname;
    private int height;
    private int weight;
    private String roles;


}