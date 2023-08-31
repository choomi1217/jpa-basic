package org.example.ch10.jpql.join.pathExpressions;

import org.example.ch10.jpql.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 단일 값 연관 경로탐색
 * */
public class SingleValue {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m.orders FROM Member m where m.name = 'kim' and m.address.city = 'seoul' and m.team.name = 'teamA'";

        List<Object> resultList = em.createQuery(query, Object.class).getResultList();

        resultList.forEach(o -> {
            Order order = (Order) o;
            System.out.println("order id: " + order.getId());
        });

    }
}
