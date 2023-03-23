package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.services.PostService;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite(Model model, PostRequest params) {
        model.addAttribute("post", params);
        System.out.println(params);
        return "post/write";
    }

    @PostMapping("/post/save")
    public String savePost(Model model, PostRequest params){
        model.addAttribute(params);
        System.out.println("================");
        System.out.println(params.toString());
        postService.savePost(params);
        return "redirect:/post/view";
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
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/post";
    }

    @GetMapping("/post/view")
    public String openViewPage(@RequestParam final int id, Model model) {
        PostResponse posts = postService.findPostById(id);
        model.addAttribute("posts", posts);
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