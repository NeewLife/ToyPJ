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
    private boolean sex;
    private int ageGroup;
    @Column(unique = true)
    private String userid;
    private String pw;
    private String nickname;
    private Long height;
    private Long weight;
    private String roles;

    private Member(Long id, String name, boolean sex, int ageGroup, String userid, String pw, String nickname, Long height, Long weight, String roleUser) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.ageGroup = ageGroup;
        this.userid = userid;
        this.pw = pw;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.roles = roleUser;
    }

    protected Member() {}

    public static Member createUser(String userId, String pw) {
        return new Member(null, null, false,0, userId, pw, null, null,null, "USER");
    }
}