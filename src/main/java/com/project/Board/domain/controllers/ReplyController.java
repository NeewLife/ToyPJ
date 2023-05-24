package com.project.Board.domain.controllers;

import com.project.Board.domain.dto.reply.ReplyRequest;
import com.project.Board.domain.dto.reply.ReplyResponse;
import com.project.Board.domain.services.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/write")
    public String writeReply(final int postId, Model model, ReplyRequest params){
        model.addAttribute(params);
        replyService.writeReply(params);
        String url = "redirect:/post/view?postId=" + postId;
        return url;
    }

    @PostMapping("/delete")
    public String deleteReply(final int postId, int repId){
        replyService.deleteReply(repId);
        String url = "redirect:/post/view?postId=" + postId;
        return url;
    }
}
