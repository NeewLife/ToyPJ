package com.project.Board.domain.mappers;

import com.project.Board.domain.post.PostResponse;
import com.project.Board.domain.user.Member;
import com.project.Board.domain.user.MemberRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void joinUser(MemberRequest memberRequest);

    List<Member> findAll();
}
