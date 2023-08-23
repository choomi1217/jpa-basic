package org.example.ch9.valueType.mutable;

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
        Member a = new Member();
        a.setName("member A");
        a.setAge(20);
        a.setHomeAddress(new Address("seoul", "gangnam", "123-456"));
        em.persist(a);
        tx.commit();

        tx.begin();
        Address homeAddress = a.getHomeAddress();
        homeAddress.setCity("busan");
        Member b = new Member();
        b.setName("member B");
        b.setAge(30);
        b.setHomeAddress(homeAddress);
        em.persist(b);
        tx.commit();

        emf.close();
    }
}
