package com.project.Board.domain.mappers;

import com.project.Board.domain.dto.reply.ReplyRequest;
import com.project.Board.domain.dto.reply.ReplyResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
    void writeReply(ReplyRequest params);

    ReplyResponse findReply(int postId);
}
