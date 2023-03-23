package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthorizationController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login-process")
    public String loginUser(Model model, Member member){
        memberService.loginUser(member.getUserId());
        return "redirect:/post/login";
    }

    @PostMapping("/register")
    public String userSignUp(Model model, MemberRequest memberRequest){
        memberService.signup(memberRequest);
        return "redirect:/post/login";
    }
}
