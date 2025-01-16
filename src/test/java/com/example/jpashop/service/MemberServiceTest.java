package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(false)
    public void join() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long saveId = memberService.join(member);

        // then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void duplicatedMember() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");


        Member member2 = new Member();
        member2.setName("kim");

        // when
        try{
            memberService.join(member2); // 예외가 발생해야 한다!!
        }catch (IllegalStateException e){
            return;
        }

        // then
        Assertions.fail("예외가 발생한다.");
    }
}