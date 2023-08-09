package org.example.practice.service;

import org.example.practice.entity.Category;
import org.example.practice.entity.CategoryItem;
import org.example.practice.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ItemService {
    private final EntityManagerFactory emf;
    public ItemService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Item save(Item item, Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(item);
        em.merge(category);
        CategoryItem categoryItem = new CategoryItem(category, item);
        em.persist(categoryItem);
        item.addCategoryItem(categoryItem);
        em.persist(item);
        tx.commit();

        return item;
    }
}
