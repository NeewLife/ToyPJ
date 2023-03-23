package com.project.Board.domain.dto.user;

import com.project.Board.config.Security.SimplePasswordEncoder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

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
