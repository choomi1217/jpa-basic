package org.example.practice.service;

import org.example.practice.entity.Category;
import org.example.practice.entity.CategoryItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CategoryService {
    private final EntityManagerFactory emf;
    public CategoryService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Category save(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(category);
        tx.commit();

        return category;
    }

    public CategoryItem save(CategoryItem categoryItem) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(categoryItem);
        tx.commit();
        return categoryItem;
    }
}
