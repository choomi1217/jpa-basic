package org.example.ch6.oneToOne.slave.twoWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _1_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Locker locker = new Locker("locker1");
        Member member = new Member("member1");
        locker.setMember(member);

        em.persist(locker);
        em.persist(member);

        tx.commit();
        emf.close();
    }
}
