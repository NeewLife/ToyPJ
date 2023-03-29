package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import com.project.Board.domain.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite(
            @RequestParam (value = "postId", required = false) final Integer postId, Model model
            , @AuthenticationPrincipal Member member) {
        if (postId != null){
            PostResponse posts = postService.findPostById(postId);
            System.out.println(member.getId());
            System.out.println(posts.getId());
            // 임의의 URI로 접근할 경우를 방지하기 위한 로직
            if (member.getId() != posts.getId()){
                System.out.println("수정할 아이디가 다릅니다.");
                return "post/post";
            }
            model.addAttribute("post", posts);
            System.out.println("수정할 페이지 기존정보를 불러옴");
            return "post/write";
        }
        return "post/write";
    }

    @PostMapping("/post/save")
    public String savePost(Model model, PostRequest params){
        model.addAttribute(params);
        System.out.println("================");
        System.out.println("post/save 실행");
        System.out.println(params.toString());
        postService.savePost(params);
        return "redirect:/post/post";
    }

    @PostMapping("/post/update")
    public String updatePost(final PostRequest params){
        System.out.println("================");
        System.out.println("post/update 실행");
        System.out.println(params.toString());
        postService.updatePost(params);
        return "redirect:/post/post";
    }

    @PostMapping("/post/delete")
    public String deletePost(@RequestParam final int postId) {
        postService.deletePost(postId);
        return "redirect:/post/post";
    }

    @GetMapping("/post/index")
    public String openMain(Model model) {
        return "post/index";
    }

    @GetMapping("/post/mypage")
    public String openMyPage(@AuthenticationPrincipal Member member, Model model) {
        Optional<Member> memberRequest = memberService.loginUser(member.getUserId());
        System.out.println("memberRequest.get() : " + memberRequest.get());
        System.out.println("memberRequest.get().getUserId() : " + memberRequest.get().getUserId());
        model.addAttribute("member", memberRequest.get());
        System.out.println("model : " + model);
        return "post/mypage";
    }

    @GetMapping("/post/post")
    public String openPost(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/post";
    }

    @GetMapping("/post/view")
    public String openViewPage(@RequestParam final int postId, Model model) {
        PostResponse posts = postService.findPostById(postId);
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
    public String loginPage(@AuthenticationPrincipal Member member) {
        if (member != null){
            return "post/index";
        }
        return "post/login";
    }

}