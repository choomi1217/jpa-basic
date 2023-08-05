package org.example.ch6.manyToMany.noRelationTable.oneWay;

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
        member.getProducts().add(note);
        member.getProducts().add(pen);
        em.persist(member);

        tx.commit();

        em.clear(); // 영속성 컨텍스트 내의 모든 엔터티 제거, 안그러면 select 쿼리가 날아가지 않습니다

        Member cho = em.find(Member.class, member.getId());
        System.out.println("----- " + cho.getUsername() + " 회원님의 주문상품 목록 -----");
        cho.getProducts().forEach(product -> {
            System.out.println("product = " + product.getName());
        });

        emf.close();
    }
}
