package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.page.PagingResponse;
import com.project.Board.domain.dto.page.SearchDto;
import com.project.Board.domain.dto.post.PostRequest;
import com.project.Board.domain.dto.post.PostResponse;
import com.project.Board.domain.dto.reply.ReplyRequest;
import com.project.Board.domain.dto.reply.ReplyResponse;
import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.services.MemberService;
import com.project.Board.domain.services.PostService;
import com.project.Board.domain.services.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final ReplyService replyService;

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite(
            @RequestParam (value = "postId", required = false) final Integer postId, Model model
            , @AuthenticationPrincipal Member member) {
        if (postId != null){
            PostResponse posts = postService.findPostById(postId);
            // 임의의 URI로 접근할 경우를 방지하기 위한 로직
            if (member.getId() != posts.getId()){
                return "post/post";
            }
            model.addAttribute("post", posts);
            return "post/write";
        }
        return "post/write";
    }

    @PostMapping("/post/save")
    public String savePost(Model model, PostRequest params){
        model.addAttribute(params);
        postService.savePost(params);
        return "redirect:/post/post";
    }

    @PostMapping("/post/update")
    public String updatePost(final PostRequest params){
        postService.updatePost(params);
        return "redirect:/post/post";
    }

    @PostMapping("/post/delete")
    public String deletePost(@RequestParam final int postId, int id,
                             @AuthenticationPrincipal Member member) {
        if (id != member.getId()){
            return "redirect:/post/post";
        }
        postService.deletePost(postId);
        return "redirect:/post/post";
    }

    @GetMapping("/post/index")
    public String openMain(Model model) {
        return "post/index";
    }

    @GetMapping("/post/mypage")
    public String openMyPage(@AuthenticationPrincipal Member member, Model model) {
        Member memberRequest = memberService.findByUserId(member.getUserId());
        model.addAttribute("member", memberRequest);
        return "post/mypage";
    }

    @GetMapping("/post/post")
    public String openPost(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> posts = postService.findAllPost(params);
        model.addAttribute("posts", posts);
        return "post/post";
    }

    @GetMapping("/post/view")
    public String openViewPage(@RequestParam final int postId, Model model) {
        System.out.println("postId : " + postId);
        postService.viewCountUp(postId);
        PostResponse posts = postService.findPostById(postId);
        model.addAttribute("posts", posts);
        List<ReplyResponse> replies = replyService.findReply(postId);
        System.out.println("replies : " + replies);
        model.addAttribute("replies",replies);
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