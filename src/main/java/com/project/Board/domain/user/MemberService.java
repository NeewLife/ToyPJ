package com.project.Board.domain.user;

import com.project.Board.domain.mappers.UserMapper;
import com.project.Board.domain.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;
    private final UserMapper userMapper;

    public void signup(MemberRequest memberRequest){
        userMapper.joinUser(memberRequest);
    }

    public List<Member> findAllUser() {
        return userMapper.findAll();
    }

    public Optional<Member> findOne(String userId) {
        return repository.findByUserId(userId);
    }
}
