package org.example.ch8.orphan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Parent parent = em.find(Parent.class, 255L);
        parent.getChild().forEach(child -> {
            System.out.println("child = " + child.getName());
        });

        parent.getChild().remove(0);
        tx.commit();

        System.out.println("--- after remove ---");
        parent.getChild().forEach(child -> {
            System.out.println("child = " + child.getName());
        });

        emf.close();
    }
}
