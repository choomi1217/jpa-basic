package org.example.ch6.manyToMany.relationTable.surrogateKey;

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

        Product pen = new Product();
        pen.setName("pen");
        em.persist(pen);

        Member member = new Member();
        member.setUsername("cho");
        em.persist(member);

        Order order = new Order();
        order.setMember(member);
        order.setProduct(pen);
        order.setOrderAmount(3);
        order.setOrderDate(new Date());
        em.persist(order);

        tx.commit();
        em.clear();

        Order ordered = em.find(Order.class, order.getId());
        System.out.println("회원명 : " + ordered.getMember().getUsername());
        System.out.println("주문 아이템 : " + ordered.getProduct().getName());
        System.out.println("주문 개수 : " + ordered.getOrderAmount());

    }
}
