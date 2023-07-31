package org.example.ch3;

import org.example.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _6_Merge {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
    public static void main(String[] args) {
        Member member = createMember(new Member("cho", 20)); //준영속
        member.setName("조영미");
        member.setAge(26);
        mergeMember(member);

    }

    private static void mergeMember(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member findBeforeMerged = em.find(Member.class, member.getId());
        System.out.println("FIND BEFORE MERGED MEMBER NAME '" + findBeforeMerged.getName() + "'");
        Member merged = em.merge(member);
        tx.commit();

        System.out.println(" DETACH MEMBER NAME '" + member.getName() + "'");
        System.out.println(" MERGED MEMBER NAME '" + merged.getName() + "'");

        System.out.println("Entity Manager has MEMBER ? " + em.contains(member));
        System.out.println("Entity Manager has MERGED ? " + em.contains(merged));

        Member findAfterMerged = em.find(Member.class, merged.getId());

        System.out.println("FIND AFTER MERGED MEMBER NAME '" + findAfterMerged.getName() + "'");

        em.close();
    }

    static Member createMember(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(member);
        tx.commit();
        em.close();

        return member;
    }
}
