package org.example.ch3;

import org.example.member.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setName("cho");
        member.setAge(20);

        em.persist(member);;

        member.setName("Jo");
        member.setAge(30);

        em.remove(member);

        tx.commit();

        emf.close();
    }

}
