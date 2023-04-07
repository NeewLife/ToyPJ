package com.project.Board.domain.dto.reply;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyResponse {
    private int postId;
    private int id;
    private String repWriter;
    private String repContent;
    private LocalDateTime repCreatedTime;

}
