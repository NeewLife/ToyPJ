package com.project.Board.domain.dto.reply;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyResponse {
    private int postId;
    private int repId;
    private String repWriter;
    private String repContent;
    private LocalDateTime repCreatedTime;
    private int repDeleteYn;

}
