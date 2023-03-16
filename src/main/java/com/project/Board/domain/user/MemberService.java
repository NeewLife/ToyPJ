package com.project.Board.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Optional<Member> findOne(String userId) {
        return repository.findByUserid(userId);
    }
}
