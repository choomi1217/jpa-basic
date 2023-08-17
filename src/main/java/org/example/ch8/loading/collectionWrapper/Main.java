package org.example.ch8.loading.collectionWrapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        Member member1 = em.find(Member.class, "cho");
        List<Purchase> member1Purchases = member1.getPurchases();

        System.out.println("----- " + member1.getUsername() + " 회원님의 구매 목록 -----");

        System.out.println("proxy collection wrapper : " + member1Purchases.getClass().getName());

        member1Purchases.forEach(purchase -> {
            System.out.print("구매자 : " + purchase.getMember().getUsername());
            System.out.println( ", purchase" + purchase.getId() + " = " + purchase.getProduct().getName());
        });

        emf.close();

    }
}
