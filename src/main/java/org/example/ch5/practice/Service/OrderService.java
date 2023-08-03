package org.example.ch5.practice.Service;

import org.example.ch5.practice.Entity.Item;
import org.example.ch5.practice.Entity.Member;
import org.example.ch5.practice.Entity.Order;
import org.example.ch5.practice.Entity.OrderItem;
import org.example.ch5.practice.OrderStatus;

import javax.persistence.EntityManager;
import java.util.Date;

public class OrderService {

    public Order order(EntityManager em, Member member, Item item) {
        OrderItem orderItem = new OrderItem(item, item.getPrice(), 1);

        Order order = new Order();
        order.setMember(member);
        order.addOrderItem(orderItem);
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(new Date());
        em.persist(order);

        return order;
    }
}
