package org.example.ch5.practice.Controller;

import org.example.ch5.practice.Entity.Item;
import org.example.ch5.practice.Entity.Member;
import org.example.ch5.practice.Entity.Order;
import org.example.ch5.practice.Entity.OrderItem;
import org.example.ch5.practice.OrderStatus;
import org.example.ch5.practice.Service.ItemService;
import org.example.ch5.practice.Service.MemberService;
import org.example.ch5.practice.Service.OrderService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Controller {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member1 = new Member("홍길동", "강원도", "원주시", "123-123");

        Item cookie = new Item("과자",5000, 10000);
        Item chocolate = new Item("초콜렛",5000, 10000);
        Item icecream = new Item("아이스크림",5000, 10000);

        Order order = orderService.order(em, member1, cookie);
        order.addOrderItem(new OrderItem(chocolate, 5000, 1));
        order.addOrderItem(new OrderItem(icecream, 5000, 4));

        Order order2 = orderService.order(em, member1, chocolate);
        Order order3 = orderService.order(em, member1, icecream);

        em.persist(member1);
        em.persist(cookie);
        em.persist(chocolate);
        em.persist(icecream);

        tx.commit();

        System.out.println("-----" + member1.getName() + "회원님의 주문 목록 -----");
        member1.getOrderList().forEach(o -> {
            System.out.println("주문번호 : " + o.getId());
            o.getOrderItemList().forEach(oi -> {
                System.out.println("상품명 : " + oi.getItem().getName());
                System.out.println("상품가격 : " + oi.getOrderPrice());
                System.out.println("상품수량 : " + oi.getCount());
            });
            System.out.println("-*-*-*-*-*-");
        });

        emf.close();

    }

}