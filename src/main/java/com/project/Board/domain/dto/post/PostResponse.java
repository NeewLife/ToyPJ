package com.project.Board.domain.dto.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private int postId;
    private String title;
    private String writer;
    private String content;
    private int viewCount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private boolean deleteYn;
    private boolean noticeYn;
    private int id;
}
