package com.project.Board.domain.user;

import com.project.Board.domain.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    //private final MemberRepository repository;
    private final UserMapper userMapper;

    public void signup(MemberRequest memberRequest){
        userMapper.joinUser(memberRequest);
    }

    public Optional<Member> loginUser(String username) {
        return userMapper.loginUser(username);
    }

}
