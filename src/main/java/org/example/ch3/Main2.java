package org.example.ch3;

import org.example.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member memberA = new Member();
        memberA.setName("A");
        memberA.setAge(20);

        Member memberB = new Member();
        memberB.setName("B");
        memberB.setAge(30);

        em.persist(memberA);
        em.persist(memberB);


        tx.commit();

        em.remove(memberA);
        em.remove(memberB);

        tx.commit();

        emf.close();
    }

}
