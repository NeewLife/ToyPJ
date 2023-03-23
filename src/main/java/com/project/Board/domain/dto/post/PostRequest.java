package com.project.Board.domain.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private int postId;
    private String title;
    private String writer;
    private String content;
    private int id;

    @Override
    public String toString() {
        return "PostRequest{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
