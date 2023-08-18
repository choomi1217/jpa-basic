package org.example.ch8.orphan.only;

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
        Parent parent = em.find(Parent.class, 269L);
        List<Child> children = parent.getChild();
        children.forEach(child -> {
            System.out.println("child = " + child.getName());
        });

        em.remove(parent);
        tx.commit();

        try {
            em.find(Child.class, children.get(0));
        }catch (IllegalArgumentException e) {
            System.out.println("child is null");
        }

        emf.close();
    }
}
