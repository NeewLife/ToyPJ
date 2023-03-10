package com.project.Board.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private int postId;
    private String title;
    private String writer;
    private String content;
    private boolean noticeYn;
    private int userId;


}
