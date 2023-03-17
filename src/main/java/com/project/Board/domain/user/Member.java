package com.project.Board.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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

    public Member() {};

    public String toString(){
        return "id : " + id +
                "name : " + name +
                "sex : " + sex +
                "ageGroup : " + ageGroup +
                "userId : " + userId +
                "password : " + password +
                "nickname : " + nickname +
                "height : " + height +
                "weight : " + weight +
                "roles : " + roles;
    }
}