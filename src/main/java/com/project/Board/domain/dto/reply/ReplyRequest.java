package com.project.Board.domain.dto.reply;

import lombok.Data;

@Data
public class ReplyRequest {
    private String repWriter;
    private String repContent;
    private int postId;
    private String repPassword;
}
