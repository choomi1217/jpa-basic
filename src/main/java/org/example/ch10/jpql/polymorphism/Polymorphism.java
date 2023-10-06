package org.example.ch10.jpql.polymorphism;


import org.example.ch10.jpql.entity.Book;
import org.example.ch10.jpql.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        treat(em);
        type(em);

    }

    private static void treat(EntityManager em) {
        System.out.println(" ----- TREAT ----- ");
        String query = "SELECT it FROM Item it WHERE TREAT(it AS Book).author LIKE '%J.K%'";
        List<Item> resultList = em.createQuery(query, Item.class).getResultList();
        resultList.forEach(item -> {
            System.out.println("item name : " + item.getName());
        });
    }

    private static void type(EntityManager em) {
        System.out.println(" ----- TYPE ----- ");
        String query = "SELECT it FROM Item it WHERE TYPE(it) IN (Book)";
        List<Item> resultList = em.createQuery(query, Item.class).getResultList();
        resultList.forEach(item -> {
            System.out.println("item name : " + item.getName());
        });
    }
}
