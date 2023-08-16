package org.example.ch8.proxy.accessType.field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Team teamA = em.getReference(Team.class, "A");
        System.out.println("id : " + teamA.getId());
        System.out.println("class : " + teamA.getClass());

        emf.close();
    }
}
