package com.project.Board.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(Model model) {
        return "post/write";
    }

    @GetMapping("/post/index.do")
    public String openMain(Model model) {
        return "post/index";
    }

    @GetMapping("/post/mypage.do")
    public String openMyPage(Model model) {
        return "post/mypage";
    }

    @GetMapping("/post/post.do")
    public String openPost(Model model) {
        return "post/post";
    }

    @GetMapping("/post/view.do")
    public String openViewPage(Model model) {
        return "post/view";
    }

    @GetMapping("/post/register.do")
    public String openRegister(Model model) {
        return "post/register";
    }

}