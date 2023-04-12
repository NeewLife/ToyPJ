package com.project.Board.domain.services;

import com.project.Board.domain.dto.user.Member;
import com.project.Board.domain.dto.user.MemberRequest;
import com.project.Board.domain.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;


    public int checkId(String userId){
        return userMapper.checkId(userId);
    }
    public int checkNickname(String nickname){
        return userMapper.checkNickname(nickname);
    }

    public void signup(MemberRequest memberRequest){
        memberRequest.setPassword(passwordEncoder.encode(memberRequest.getPassword()));
        userMapper.joinUser(memberRequest);
    }

    public Optional<Member> loginUser(String userId) {
        return userMapper.loginUser(userId);
    }

    public Member findByUserId(String userId){
        return userMapper.findByUserId(userId);
    }

    @Transactional
    public void update(MemberRequest member){
        userMapper.update(member);
    }

    public void delete(MemberRequest memberRequest){
        userMapper.delete(memberRequest);
    }

}
