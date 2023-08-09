package org.example.practice.service;

import org.example.practice.entity.Delivery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class DeliveryService {

    private final EntityManagerFactory emf;

    public DeliveryService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Delivery save(Delivery delivery) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(delivery);
        tx.commit();
        return delivery;
    }
}
