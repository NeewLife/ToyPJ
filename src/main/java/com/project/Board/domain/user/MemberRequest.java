package com.project.Board.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MemberRequest {            // 얘는 Member를 생성, 수정때 쓸 객체
    private String name;
    private String sex;
    private int ageGroup;
    @Column(unique = true)
    private String userId;
    private String password;
    private String nickname;
    private int height;
    private int weight;

}
