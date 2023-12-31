package com.thejoeun.practice1.boilerplate1.jpa;

import com.thejoeun.practice1.boilerplate1.model.Member;
import com.thejoeun.practice1.boilerplate1.repository.MemberRepository;
import com.thejoeun.practice1.boilerplate1.repository.mapper.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaTest {
    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("JPA 사용 가능 여부 테스트")
    @Test
    void jpaTest1() {
        Member member = memberRepository.findById(2L).get();
        assertThat(member.getEmail()).isEqualTo("test20@test.com");
    }
}
