package com.project.Board;

import com.project.Board.domain.mappers.UserMapper;
import com.project.Board.domain.user.Member;
import com.project.Board.domain.user.MemberRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void joinUser() {
        MemberRequest member = new MemberRequest();
        member.setName("오세영");
        member.setSex("남자");
        member.setAgeGroup(20);
        member.setUserId("dhtpdud2009");
        member.setPassword("123qwe");
        member.setNickname("자력갱생하십시오");
        member.setHeight(188);
        member.setWeight(67);
        userMapper.joinUser(member);

        List<Member> members = userMapper.findAll();
        System.out.println("=====================");
        System.out.println(members);
        System.out.println("=====================");
    }
}
