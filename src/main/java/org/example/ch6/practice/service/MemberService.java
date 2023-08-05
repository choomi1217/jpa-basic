package org.example.ch6.practice.service;

import org.example.ch6.practice.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class MemberService {
    private final EntityManagerFactory emf;

    public MemberService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Member save(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(member);
        tx.commit();

        return member;
    }

    public Member find(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member member = em.find(Member.class, id);
        tx.commit();
        return member;
    }
}
