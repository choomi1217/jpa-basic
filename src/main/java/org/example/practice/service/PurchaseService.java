package org.example.practice.service;

import org.example.practice.entity.Member;
import org.example.practice.entity.Purchase;
import org.example.practice.entity.PurchaseItem;

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

    public void addPurchaseItem(Purchase purchase, PurchaseItem purchaseItem) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Purchase merge = em.merge(purchase);
        merge.addPurchaseItem(purchaseItem);
        tx.commit();
    }
}
