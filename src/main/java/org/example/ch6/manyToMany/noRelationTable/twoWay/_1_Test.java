package org.example.ch6.manyToMany.noRelationTable.twoWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _1_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Product note = new Product();
        note.setName("note");
        Product pen = new Product();
        pen.setName("pen");
        em.persist(note);
        em.persist(pen);

        Member member = new Member();
        member.setUsername("cho");
        member.addProduct(note);
        member.addProduct(pen);
        em.persist(member);

        tx.commit();
        em.clear();

        Member cho = em.find(Member.class, member.getId());
        System.out.println("----- " + cho.getUsername() + " 회원님의 주문상품 목록 -----");
        cho.getProducts().forEach(product -> {
            System.out.println("product = " + product.getName());
        });

        Product product = em.find(Product.class, note.getId());
        System.out.println("-----" + product.getName() + " 상품을 구매한 회원 목록 -----");
        product.getMembers().forEach(m -> {
            System.out.println("member = " + m.getUsername());
        });

        emf.close();
    }
}
