package org.example.ch4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _1_SequenceIncrement {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        IdentityUser identityUser = new IdentityUser();
        identityUser.setUsername("identityUser");
        identityUser.setAge(10);

        SequenceUser sequenceUser = new SequenceUser();
        sequenceUser.setUsername("sequenceUser");
        sequenceUser.setAge(20);

        TableUser tableUser = new TableUser();
        tableUser.setUsername("tableUser");
        tableUser.setAge(30);

        em.persist(identityUser);
        em.persist(sequenceUser);
        em.persist(tableUser);

        System.out.println("identityUser.getId() = " + identityUser.getId());
        System.out.println("sequenceUser.getId() = " + sequenceUser.getId());
        System.out.println("tableUser.getId() = " + tableUser.getId());

        tx.commit();
        emf.close();

    }
}
