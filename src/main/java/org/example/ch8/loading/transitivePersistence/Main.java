package org.example.ch8.loading.transitivePersistence;

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
        Child child1 = new Child();
        child1.setName("child1");
        Child child2 = new Child();
        child2.setName("child2");

        Parent parent = new Parent();
        parent.setName("parent");
        parent.addChild(child1);
        parent.addChild(child2);
        em.persist(parent);
        tx.commit();

        emf.close();
    }
}
