package com.project.Board.domain.services;

import com.project.Board.domain.dto.reply.ReplyRequest;
import com.project.Board.domain.dto.reply.ReplyResponse;
import com.project.Board.domain.mappers.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;

//    댓글 작성
    public int writeReply(ReplyRequest params){

        replyMapper.writeReply(params);
        return params.getPostId();
    }

    public void deleteReply(int repId){
        replyMapper.deleteReply(repId);
    }

    public List<ReplyResponse> findReply(int postId) {
        return replyMapper.findReply(postId);
    }
}
