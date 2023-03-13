package com.study.domain.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.common.dto.MessageDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "orderNum", required = false) final Long orderNum, Model model) {
    	if (orderNum != null) {
            PostResponse post = postService.findPostByOrderNum(orderNum);
            model.addAttribute("post", post);
        }
    	
        return "post/write";
    }
    
    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findNotNoticePost();
        List<PostResponse> notices = postService.findNoticePost();
        model.addAttribute("notices", notices);
        model.addAttribute("posts", posts);
        return "post/list";
    }
    
//    // 게시글 리스트 페이지
//    @PostMapping("/post/list.do")
//    public String openNoticeList(Model model) {
//        List<PostResponse> notices = postService.findNoticePost();
//        model.addAttribute("notices", notices);
//        System.out.println(notices);
//        return "post/list";
//    }
    
    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/post/list.do";
    }
    
    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long orderNum, Model model) {
        PostResponse post = postService.findPostByOrderNum(orderNum);
        model.addAttribute("post", post);
        return "post/view";
    }
    
    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params) {
        postService.updatePost(params);
        return "redirect:/post/list.do";
    }
    
    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long orderNum) {
        postService.deletePost(orderNum);
        return "redirect:/post/list.do";
    }
    
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
//    private String showMessageAndRedirect(final MessageDto params, Model model) {
//        model.addAttribute("params", params);
//        return "common/messageRedirect";
//    }

}