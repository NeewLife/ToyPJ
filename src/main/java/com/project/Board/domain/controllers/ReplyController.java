package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.reply.ReplyRequest;
import com.project.Board.domain.services.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reply/write")
    public String writeReply(Model model, ReplyRequest params){
        model.addAttribute(params);
        replyService.writeReply(params);
        return "redirect:/post/view?postId="+params.getPostId();
    }
}
