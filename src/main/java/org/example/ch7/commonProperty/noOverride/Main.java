package org.example.ch7.commonProperty.noOverride;

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

        Member member = new Member();
        member.setName("cho");
        member.setEmail("abc@gmail.com");
        em.persist(member);

        Seller seller = new Seller();
        seller.setName("seller");
        seller.setShopName("shop");
        em.persist(seller);

        tx.commit();
        emf.close();
    }
}
