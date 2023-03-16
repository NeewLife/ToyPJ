package com.project.Board.domain.controller;

import com.project.Board.domain.user.Member;
import com.project.Board.domain.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class MemberController {

    @GetMapping("/login")
    public String loginPage() {
        return "post/login";
    }

    @PostMapping("/signup")
    public void userSignUp(Member member){
        UserMapper.userSignUp(member);
    }
}
