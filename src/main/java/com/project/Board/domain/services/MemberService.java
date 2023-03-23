package com.project.Board.domain.services;

import com.project.Board.domain.mappers.UserMapper;
import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public void signup(MemberRequest memberRequest){
        memberRequest.setPassword(passwordEncoder.encode(memberRequest.getPassword()));
//        System.out.println("============================");
//        System.out.println(memberRequest.getPassword());
        userMapper.joinUser(memberRequest);
    }

    public Optional<Member> loginUser(String username) {
        return userMapper.loginUser(username);
    }

}
