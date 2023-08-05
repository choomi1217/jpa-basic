package org.example.ch6.manyToMany.relationTable.compositeKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class _1_Test {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setUsername("cho");
        em.persist(member);

        Product note = new Product();
        note.setName("note");
        Product pen = new Product();
        pen.setName("pen");
        em.persist(note);
        em.persist(pen);

        MemberProduct memberProduct1 = new MemberProduct();
        memberProduct1.setMember(member);
        memberProduct1.setProduct(note);
        memberProduct1.setOrderAmount(2);
        memberProduct1.setOrderDate(new Date());
        MemberProduct memberProduct2 = new MemberProduct();
        memberProduct2.setMember(member);
        memberProduct2.setProduct(pen);
        memberProduct2.setOrderAmount(3);
        memberProduct2.setOrderDate(new Date());
        em.persist(memberProduct1);
        em.persist(memberProduct2);

        tx.commit();
        em.clear();

        // 조회
        MemberProductId memberProductId1 = new MemberProductId();
        memberProductId1.setMember(member.getId());
        memberProductId1.setProduct(note.getId());

        MemberProductId memberProductId2 = new MemberProductId();
        memberProductId2.setMember(member.getId());
        memberProductId2.setProduct(pen.getId());

        MemberProduct findMemberProduct1 = em.find(MemberProduct.class, memberProductId1);
        MemberProduct findMemberProduct2 = em.find(MemberProduct.class, memberProductId2);

        System.out.println("회원명 : " + findMemberProduct1.getMember().getUsername());
        System.out.println("주문 아이템 : " + findMemberProduct1.getProduct().getName());
        System.out.println("주문 개수 : " +findMemberProduct1.getOrderAmount());
        System.out.println("주문 아이템 : " + findMemberProduct2.getProduct().getName());
        System.out.println("주문 개수 : " +findMemberProduct2.getOrderAmount());


    }
}
