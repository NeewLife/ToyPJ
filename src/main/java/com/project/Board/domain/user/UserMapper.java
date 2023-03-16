package com.project.Board.domain.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Member> getUserById();
    public static void userSignUp(Member member) {
    }
}
