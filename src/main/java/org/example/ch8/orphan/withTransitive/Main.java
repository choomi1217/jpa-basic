package org.example.ch8.orphan.withTransitive;

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
        Parent parent = new Parent();
        parent.setName("parent");
        em.persist(parent);

        Child child1 = new Child();
        child1.setName("child1");
        parent.addChild(child1);

        Child child2 = new Child();
        child2.setName("child2");
        parent.addChild(child2);
        tx.commit();
        em.clear();

        parent.getChild().forEach(c -> System.out.println(c.getName()));

        System.out.println("----------");

        tx.begin();
        parent.getChild().remove(0);
        tx.commit();
        em.clear();

        System.out.println("----------");
        tx.begin();
        Parent merged = em.merge(parent);
        em.remove(merged);
        tx.commit();

        emf.close();
    }
}
