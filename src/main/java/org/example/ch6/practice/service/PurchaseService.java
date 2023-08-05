package org.example.ch6.practice.service;

import org.example.ch6.practice.entity.Delivery;
import org.example.ch6.practice.entity.Member;
import org.example.ch6.practice.entity.Purchase;
import org.example.ch6.practice.entity.PurchaseItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PurchaseService {
    private final EntityManagerFactory emf;

    public PurchaseService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Purchase save(Purchase purchase) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member member = em.merge(purchase.getMember());
        Delivery delivery = em.merge(purchase.getDelivery());
        em.persist(purchase);
        member.addPurchase(purchase);
        tx.commit();
        return purchase;
    }

    public PurchaseItem save(PurchaseItem purchaseItem) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(purchaseItem);
        tx.commit();
        return purchaseItem;
    }
}
