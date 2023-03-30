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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/checkDup")
    @ResponseBody
    public String checkDuplicate(@RequestParam("userId") String userId,
                                 @RequestParam("nickname") String nickname){
        String result = "N";
        int checkId = memberService.checkId(userId);
        int checkNickname = memberService.checkNickname(nickname);
        if (checkId != 0){
            if (checkNickname != 0) {
                result = "NICK";
                return result;
            }
            result = "ID";
            return result;
        }
        System.out.println(result);
        return result;
    }

    @PostMapping("/update")
    public String userUpdate(MemberRequest member){
        System.out.println("일단 컨트롤러 호출 성공");
        System.out.println("update의 member : " + member.toString());
        memberService.update(member);
        return "redirect:/post/mypage";
    }

    @PostMapping("/withdrawal")
    public String userDelete(MemberRequest member){
        System.out.println("일단 컨트롤러 호출 성공");
        System.out.println("withdrawal member : " + member.toString());
        memberService.delete(member);
        return "redirect:/logout";
    }
}
