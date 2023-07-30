package org.example.ch3;

import org.example.member.Member;

import javax.persistence.*;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member memberA = new Member();
        memberA.setName("A");
        memberA.setAge(10);

        Member memberB = new Member();
        memberB.setName("B");
        memberB.setAge(20);

        Member memberC = new Member();
        memberC.setName("C");
        memberC.setAge(30);

        em.persist(memberA);
        em.persist(memberB);
        em.persist(memberC);

        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
        List<Member> members = query.getResultList();

        members.forEach(m -> {
            System.out.println("name : " + m.getName());
        });

    }
}
