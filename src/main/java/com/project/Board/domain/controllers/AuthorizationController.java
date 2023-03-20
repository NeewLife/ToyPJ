package com.project.Board.domain.controllers;

import com.project.Board.domain.user.Member;
import com.project.Board.domain.user.MemberRequest;
import com.project.Board.domain.user.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private final MemberService memberService;

    public AuthorizationController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login-process")
    public void loginUser(Model model, Member member){
        memberService.loginUser(member.getUserId());
    }

    @PostMapping("/register")
    public String userSignUp(Model model, final MemberRequest memberRequest){
        memberService.signup(memberRequest);

        return "redirect:/post/login";
    }
}
