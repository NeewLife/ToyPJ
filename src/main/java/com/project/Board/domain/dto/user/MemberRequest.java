package com.project.Board.domain.dto.user;

import lombok.Data;
;

@Data
public class MemberRequest {            // 얘는 Member를 생성, 수정때 쓸 객체

    private String name;
    private String sex;
    private int ageGroup;
    private String userId;
    private String password;
    private String nickname;
    private int height;
    private int weight;

}
