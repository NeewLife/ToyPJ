package com.project.Board.domain.mappers;

import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void joinUser(MemberRequest memberRequest);


    Optional<Member> loginUser(String username);

    int checkId(String userId);

    int checkNickname(String nickname);
}
