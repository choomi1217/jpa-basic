package org.example.ch9.valueType.collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = em.find(Member.class, 292L);
        Set<String> favoriteFoods = member.getFavoriteFoods();

        System.out.println("----- member favorite food list -----");
        favoriteFoods.forEach(System.out::println);

    }
}
