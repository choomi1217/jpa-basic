package org.example.ch5.practice.Service;

import org.example.ch5.practice.Entity.Member;

import javax.persistence.EntityManager;

public class MemberService {

    public static Member registMember(Member member, EntityManager em) {
        em.persist(member);
        return member;
    }

}
