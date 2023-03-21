package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    private final MemberService memberService;

    public AuthorizationController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login-process")
    public String loginUser(Model model, Member member){
        memberService.loginUser(member.getUserId());
        return "redirect:/post/login";
    }

    @PostMapping("/register")
    public String userSignUp(Model model, final MemberRequest memberRequest){
        memberService.signup(memberRequest);
        return "redirect:/post/login";
    }
}
