package org.example.ch3;

import org.example.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _1_Entity {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        logic(em);
        tx.commit();

        emf.close();
    }

    private static void logic(EntityManager em) {
        Member member = new Member();
        member.setName("cho");
        member.setAge(20);

        em.persist(member);

        Member member1 = em.find(Member.class, member.getId());
        Member member2 = em.find(Member.class, member.getId());

        em.remove(member);

        System.out.println(member1 == member2);

    }
}
