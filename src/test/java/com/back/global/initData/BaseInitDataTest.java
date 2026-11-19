package com.back.global.initData;

import com.back.domain.member.member.entity.Member;
import com.back.domain.member.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class BaseInitDataTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("샘플 데이터 - 회원 6명 생성")
    void t1() {
        List<Member> members = memberRepository.findAll();

        assertThat(members).hasSize(6);
        assertThat(members)
                .extracting(Member::getUsername)
                .containsExactly("system", "holding", "admin", "user1", "user2", "user3");
        assertThat(members)
                .extracting(Member::getName)
                .containsExactly("시스템", "홀딩", "관리자", "유저1", "유저2", "유저3");
    }
}
