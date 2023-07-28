package org.example.member.ch2;

import org.example.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
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
        member.setAge(10);

        em.persist(member);

        member.setAge(20);
        Long id = member.getId();

        Member findMember = em.find(Member.class, id);
        System.out.println("findMember = " + findMember.getName() + ", age = " + findMember.getAge());

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("members.size() = " + members.size());

        em.remove(member);
    }
}
