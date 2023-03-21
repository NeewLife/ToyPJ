package com.project.Board.domain.controllers;

import com.project.Board.domain.services.PostService;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite(Model model) {
        return "post/write";
    }

    @GetMapping("/post/index")
    public String openMain(Model model) {
        return "post/index";
    }

    @GetMapping("/post/mypage")
    public String openMyPage(Model model) {
        return "post/mypage";
    }

    @GetMapping("/post/post")
    public String openPost(Model model) {
        return "post/post";
    }

    @GetMapping("/post/view")
    public String openViewPage(Model model) {
        return "post/view";
    }

    @GetMapping("/post/register")
    public String openRegister(Model model, MemberRequest memberRequest) {
        model.addAttribute("memberRequest", memberRequest);
        return "post/register";
    }

    private final MemberService memberService;
    @GetMapping("/post/login")
    public String loginPage() {
        return "post/login";
    }

}