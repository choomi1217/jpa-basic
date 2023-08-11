package org.example.practice.service;

import org.example.practice.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Date;

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
